package ch.gma.shut.service.impl;

import static ch.gma.shut.model.builder.RecordedTransactionsBuilder.aRecordedTransaction;
import static ch.gma.shut.model.builder.ServiceCallBuilder.aServiceCall;
import static ch.gma.shut.model.builder.TransactionBuilder.aTransaction;
import static org.dbunit.Assertion.assertEqualsIgnoreCols;

import java.io.InputStream;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.gma.shut.model.RecordedTransactions;
import ch.gma.shut.model.builder.ServiceCallBuilder;
import ch.gma.shut.model.builder.TransactionBuilder;
import ch.gma.shut.service.ITransactionsStatisticsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-test-datasource" 
  + ".xml"})
public class TransactionsStatisticsServiceTest {

  private static final String INJECTION_DATE_COLUMN = "INJECTION_DATE";

  private static final String[] IGNORED_COLUMNS = new String[] { INJECTION_DATE_COLUMN };

  private static final String SHUT_SERVICE_CALLS_CONSTANT = "SHUT_SERVICE_CALLS";

  private static final String SHUT_TRANSACTION_TABLE = "SHUT_TRANSACTION";

  @Autowired
  private ITransactionsStatisticsService service;

  private IDatabaseConnection dbConnection;

  @Autowired
  public void setDataSource(DataSource dataSource) throws SQLException {
    dbConnection = new DatabaseDataSourceConnection(dataSource);
  }

  @Test
  public void shouldSaveTransactionWhenNoErrors() throws Exception {

    final ServiceCallBuilder aFindPrestationNatureLightForCommonsCall = aServiceCall()
      .withBusinessServiceName("PrestationNatureSvc").withBusinessMethodName("findPrestationNatureLightForCommons")
      .withDescriptionSingleLine("PrestationNatureSvc.findPrestationNatureLightForCommons(ch.gma.sinistre.)")
      .withTimestampOverallStart(new DateTime(2015, 05, 12, 11, 10, 53, 738))
      .withTimestampOverallEnd(new DateTime(2015, 05, 12, 11, 10, 55, 238))
      .withTimestampRequestObjSerializationStart(16L).withTimestampRequestObjSerializationEnd(36L)
      .withTimestampServerRoundtripStart(7L).withTimestampServerRoundtripEnd(444L)
      .withTimestampResponseObjDeserializationStart(15L).withTimestampResponseObjDeserializationEnd(41L)
      .withHttpUrl("https://pwservices.groupemutuel.ch:40100/SinistreWar/remoting/PrestationNatureSvc")
      .withHttpStatusCode(200).withHttpRequestContentLength(1830L).withHttpResponseContentLength(7631L)
      .withThreadName("pool-3-thread-43-5212");

    final ServiceCallBuilder aFindAdresseByIdsCall = aServiceCall()
      .withBusinessServiceName("PartenaireSvc").withBusinessMethodName("findAdresseByIds")
      .withDescriptionSingleLine("PartenaireSvc.findAdresseByIds([1469899105,148)")
      .withTimestampOverallStart(new DateTime(2015, 05, 12, 11, 11, 54, 973))
      .withTimestampOverallEnd(new DateTime(2015, 05, 12, 11, 11, 55, 238))
      .withTimestampRequestObjSerializationStart(16L).withTimestampRequestObjSerializationEnd(0L)
      .withTimestampServerRoundtripStart(7L).withTimestampServerRoundtripEnd(272L)
      .withTimestampResponseObjDeserializationStart(0L).withTimestampResponseObjDeserializationEnd(41L)
      .withHttpUrl("https://pwservices.groupemutuel.ch:40100/PartenaireWar/remoting/PartenaireSvc")
      .withHttpStatusCode(200).withHttpRequestContentLength(565L).withHttpResponseContentLength(14373L)
      .withThreadName("pool-3-thread-24-1445");

    final TransactionBuilder aGlobalConsultationTransaction = aTransaction()
      .withName("Load_Consultation_GlobaleLoad_Consultation_Globale_Load_Data_SIN_init")
      .withDistributionTimeComputedClient(1329L).withDistributionTimeComputedServer(171L)
      .withDistributionTimeComputedEnduser(1500L).withContainAsyncServerRoundtrips(false)
      .withTimestampStart(new DateTime(2015, 05, 12, 11, 10, 53, 738))
      .withTimestampStop(new DateTime(2015, 05, 12, 11, 11, 55, 238)).withEnvironment("PRODUCTION")
      .withClientUsername("GM61285").withClientDepartment("INDEMNISATION_VS").withSessionId("20150512110016")
      .withGdiObjectsStart(587L).withGdiObjectsStop(587L).withUserObjectsStart(1829L).withUserObjectsStop(1938L)
      .withMemoryUsedStart(146L).withMemoryUsedStop(149L)
      .with(aFindPrestationNatureLightForCommonsCall, aFindAdresseByIdsCall);

    final RecordedTransactions recordedTransactions = aRecordedTransaction().with(aGlobalConsultationTransaction)
      .build();

    service.saveTransactionsStatistics(recordedTransactions);

    assertShutTablesData("dbunit/expectedTransactionsStatisticsServiceTest.xml");
  }

  public void assertShutTablesData(String expectedDataSetUrl) throws Exception {
    final IDataSet expectedDataSet = getExpectedDataSet(expectedDataSetUrl);
    final ITable expectedShutTransactionTable = expectedDataSet.getTable(SHUT_TRANSACTION_TABLE);
    final ITable expectedShutServiceCallsTable = expectedDataSet.getTable(SHUT_SERVICE_CALLS_CONSTANT);

    final IDataSet databaseDataSet = dbConnection.createDataSet();
    final ITable actualShutTransactionTable = databaseDataSet.getTable(SHUT_TRANSACTION_TABLE);
    final ITable actualShutServiceCallsTable = databaseDataSet.getTable(SHUT_SERVICE_CALLS_CONSTANT);

    assertEqualsIgnoreCols(expectedShutTransactionTable, actualShutTransactionTable, IGNORED_COLUMNS);
    assertEqualsIgnoreCols(expectedShutServiceCallsTable, actualShutServiceCallsTable, IGNORED_COLUMNS);
  }

  private IDataSet getExpectedDataSet(String expectedDataSetUrl) throws DataSetException {
    final InputStream xmlStream = this.getClass().getClassLoader()
      .getResourceAsStream("dbunit/expectedTransactionsStatisticsServiceTest.xml");
    final FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
    flatXmlDataSetBuilder.setColumnSensing(true);

    final ReplacementDataSet expectedDataSet = new ReplacementDataSet(flatXmlDataSetBuilder.build(xmlStream));
    expectedDataSet.addReplacementObject("[NULL]", null);

    return expectedDataSet;
  }
}
