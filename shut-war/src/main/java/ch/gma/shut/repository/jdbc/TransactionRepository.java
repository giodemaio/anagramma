package ch.gma.shut.repository.jdbc;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ch.gma.shut.model.ServiceCall;
import ch.gma.shut.model.Transaction;
import ch.gma.shut.repository.DatabaseConstants;
import ch.gma.shut.repository.ITransactionRepository;

@Repository
public class TransactionRepository implements ITransactionRepository {

  private static final String TRANSACTION_PROCESS_INFO_SEPARATOR = "_";

  private SimpleJdbcInsert insertTransaction;

  private ServiceCallRepository serviceCallRepository;

  @Autowired
  public TransactionRepository(DataSource dataSource, ServiceCallRepository serviceCallRepository) {
    this.serviceCallRepository = serviceCallRepository;
    initTransactionInsert(dataSource);
  }

  private void initTransactionInsert(DataSource dataSource) {
    insertTransaction = new SimpleJdbcInsert(dataSource)
      .withTableName(DatabaseConstants.TRANSACTIONS_TABLE_NAME)
      .usingGeneratedKeyColumns("TRANSACTION_ID");
  }

  @Transactional
  public void save(List<Transaction> transactions) throws DataAccessException {
    for (Transaction transaction : transactions) {
      save(transaction);

      for (ServiceCall serviceCall : transaction.getServerRoundtripElements()) {
        serviceCallRepository.save(serviceCall, transaction);
      }
    }
  }

  private void save(Transaction transaction) throws DataAccessException {
    Number transactionId = insertTransaction.executeAndReturnKey(createTransactionParameter(transaction));
    transaction.setTransactionId(transactionId.longValue());
  }

  private MapSqlParameterSource createTransactionParameter(Transaction transaction) {

    final TransactionProcessInformation transactionProcessInfo =
      new TransactionProcessInformation(transaction.getName(), TRANSACTION_PROCESS_INFO_SEPARATOR);

    // @formatter:off
    return new MapSqlParameterSource()
      .addValue("TRANSACTION_NAME", transaction.getName())
      .addValue("CLIENTTIME_MS", transaction.getDistributionTimeComputedClient())
      .addValue("SERVERTIME_MS", transaction.getDistributionTimeComputedServer())
      .addValue("ENDUSERRESPONSETIME_MS", transaction.getDistributionTimeComputedEnduser())
      .addValue("CLIENT_SERVER_REP", computeClientServerResponse(transaction))
      .addValue("NB_SVCCALLS", transaction.getServerRoundtripElements().size())
      .addValue("ASYNC_SVCCALLS", transaction.isMayContainAsyncServerRoundtrips() ? 1 : 0)
      .addValue("START_TIMESTAMP", new Date(transaction.getTimestampStart()))
      .addValue("END_TIMESTAMP", new Date(transaction.getTimestampStop()))
      .addValue("DOMAINE", transactionProcessInfo.getDomaine())
      .addValue("PROCESS", transactionProcessInfo.getProcess())
      .addValue("PROCESSID", transactionProcessInfo.getProcessId())
      .addValue("BUSINESSID", transactionProcessInfo.getBusinessId())
      .addValue("TASKTYPE", transactionProcessInfo.getTaskType())
      .addValue("TASKID", transactionProcessInfo.getTaskId())
      .addValue("STEP", transactionProcessInfo.getStep())
      .addValue("ACTION", transactionProcessInfo.getAction())
      .addValue("ENV", transaction.getEnvironment())
      .addValue("POSTE", transaction.getClientUsername())
      .addValue("SESSIONID", transaction.getSessionName())
      .addValue("DIRTY", 0L)
      .addValue("START_GDI_OBJ", transaction.getGdiObjectsStart())
      .addValue("END_GDI_OBJ", transaction.getGdiObjectsStop())
      .addValue("START_USER_OBJ", transaction.getUserObjectsStart())
      .addValue("END_USER_OBJ", transaction.getUserObjectsStop())
      .addValue("START_MEMORY", transaction.getMemoryUsedStart())
      .addValue("END_MEMORY", transaction.getMemoryUsedStop())
      .addValue("INJECTION_DATE", new Date(System.currentTimeMillis()))
      .addValue("DEPARTEMENT", transaction.getClientDepartement());
      // @formatter:on
  }

  private double computeClientServerResponse(Transaction transaction) {
    double distributionTimeComputedClient = transaction.getDistributionTimeComputedClient();
    double distributionTimeComputedServer = transaction.getDistributionTimeComputedServer();

    return distributionTimeComputedServer == 0L ? 0L : distributionTimeComputedClient / distributionTimeComputedServer;
  }

}
