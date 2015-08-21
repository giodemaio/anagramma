package ch.gma.shut.repository.jdbc;

import java.sql.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import ch.gma.shut.model.ServiceCall;
import ch.gma.shut.model.Transaction;
import ch.gma.shut.repository.DatabaseConstants;
import ch.gma.shut.repository.IServiceCallRepository;

@Repository
public class ServiceCallRepository implements IServiceCallRepository {

  private static final String TRANSACTION_PROCESS_INFO_SEPARATOR = "_";

  private SimpleJdbcInsert insertServiceCall;

  @Autowired
  public ServiceCallRepository(DataSource dataSource) {
    initServiceCallInsert(dataSource);
  }

  private void initServiceCallInsert(DataSource dataSource) {
    insertServiceCall = new SimpleJdbcInsert(dataSource)
      .withTableName(DatabaseConstants.SERVICE_CALLS_TABLE_NAME)
      .usingGeneratedKeyColumns("REQUEST_ID");
  }

  public void save(ServiceCall serviceCall, Transaction transaction) throws DataAccessException {
    insertServiceCall.execute(createServiceCallParameter(serviceCall, transaction));
  }

  private MapSqlParameterSource createServiceCallParameter(ServiceCall serviceCall, Transaction transaction) {
    final long overallTimeinMs = computeOverallTimeInMs(serviceCall);
    final long elapsedRequestObjSerialization = computeElapsedRequestObjSerialization(serviceCall);
    final long elapsedTimeServer = computeElapsedTimeServer(serviceCall);
    final long elapsedResponseObjDeserialization = computeElapsedResponseObjDeserialization(serviceCall);

    final TransactionProcessInformation transactionProcessInfo =
      new TransactionProcessInformation(transaction.getName(), TRANSACTION_PROCESS_INFO_SEPARATOR);

    return new MapSqlParameterSource()
//    @formatter:off
      .addValue("TRANSACTION_ID", transaction.getTransactionId())
      .addValue("TRANSACTION_NAME", transaction.getName())
      .addValue("SERVICE", serviceCall.getBusinessServiceName())
      .addValue("METHOD", serviceCall.getBusinessMethodName())
      .addValue("INVOCATION_DETAILS", serviceCall.getDescriptionSingleLine())
      .addValue("OVERALL_TIME_MS", overallTimeinMs)
      .addValue("REQUEST_SERIAL_TIME_MS", elapsedRequestObjSerialization)
      .addValue("SERVER_TIME_MS", elapsedTimeServer)
      .addValue("RESPONSE_DESERIAL_TIME_MS", elapsedResponseObjDeserialization)
      .addValue("URL", serviceCall.getHttpUrl())
      .addValue("HTTP_STATUS_CODE", serviceCall.getHttpStatusCode())
      .addValue("REQUEST_CONTENT_BYTE", serviceCall.getHttpRequestContentLength())
      .addValue("RESPONSE_CONTENT_BYTE", serviceCall.getHttpResponseContentLength())
      .addValue("OVERALL_START_TIMESTAMP", new Date(serviceCall.getTimestampOverallStart()))
      .addValue("OVERALL_END_TIMESTAMP", new Date(serviceCall.getTimestampOverallEnd()))
      .addValue("THREAD", serviceCall.getThreadName())
      .addValue("DOMAINE", transactionProcessInfo.getDomaine())
      .addValue("PROCESSUS", transactionProcessInfo.getProcess())
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
      .addValue("INJECTION_DATE", new Date(System.currentTimeMillis()))
      .addValue("DEPARTEMENT", transaction.getClientDepartement());
//    @formatter:off
  }

  private long computeElapsedResponseObjDeserialization(ServiceCall serviceCall) {
    return computeDifference(serviceCall.getTimestampResponseObjDeserializationStart(), serviceCall.getTimestampResponseObjDeserializationEnd());
  }

  private long computeElapsedTimeServer(ServiceCall serviceCall) {
    return computeDifference(serviceCall.getTimestampServerRoundtripStart(), serviceCall.getTimestampServerRoundtripEnd());
  }

  private long computeElapsedRequestObjSerialization(ServiceCall serviceCall) {
    return computeDifference(serviceCall.getTimestampRequestObjSerializationStart(), serviceCall.getTimestampRequestObjSerializationEnd());
  }

  private long computeOverallTimeInMs(ServiceCall serviceCall) {
    return computeDifference(serviceCall.getTimestampOverallStart(), serviceCall.getTimestampOverallEnd());
  }

  private long computeDifference(long start, long end) {
    if (start == 0L || end == 0L) {
      return 0L;
    }
    
    return end - start;
  }
}
