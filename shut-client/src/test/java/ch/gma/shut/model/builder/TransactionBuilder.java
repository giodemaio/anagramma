package ch.gma.shut.model.builder;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import ch.gma.shut.model.Transaction;

public final class TransactionBuilder {

  private long transactionId;

  private String name;

  private Long distributionTimeComputedClient;

  private Long distributionTimeComputedServer;

  private Long distributionTimeComputedEnduser;

  private boolean containAsyncServerRoundtrips;

  private Long timestampStart;

  private Long timestampStop;

  private String environment;

  private String clientUsername;

  private String clientDepartement;

  private String sessionId;

  private Long gdiObjectsStart;

  private Long gdiObjectsStop;

  private Long userObjectsStart;

  private Long userObjectsStop;

  private Long memoryUsedStart;

  private Long memoryUsedStop;

  private List<ServiceCallBuilder> serviceCallBuilders = new ArrayList<ServiceCallBuilder>();

  private TransactionBuilder() {
  }

  public static TransactionBuilder aTransaction() {
    return new TransactionBuilder();
  }

  public TransactionBuilder withTransactiondId(long transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  public TransactionBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public TransactionBuilder withDistributionTimeComputedClient(Long distributionTimeComputedClient) {
    this.distributionTimeComputedClient = distributionTimeComputedClient;
    return this;
  }

  public TransactionBuilder withDistributionTimeComputedServer(Long distributionTimeComputedServer) {
    this.distributionTimeComputedServer = distributionTimeComputedServer;
    return this;
  }

  public TransactionBuilder withDistributionTimeComputedEnduser(Long distributionTimeComputedEnduser) {
    this.distributionTimeComputedEnduser = distributionTimeComputedEnduser;
    return this;
  }

  public TransactionBuilder withContainAsyncServerRoundtrips(boolean containAsyncServerRoundtrips) {
    this.containAsyncServerRoundtrips = containAsyncServerRoundtrips;
    return this;
  }

  public TransactionBuilder withTimestampStart(DateTime timestampStart) {
    this.timestampStart = timestampStart.getMillis();
    return this;
  }

  public TransactionBuilder withTimestampStop(DateTime timestampStop) {
    this.timestampStop = timestampStop.getMillis();
    return this;
  }

  public TransactionBuilder withEnvironment(String environment) {
    this.environment = environment;
    return this;
  }

  public TransactionBuilder withClientUsername(String clientUsername) {
    this.clientUsername = clientUsername;
    return this;
  }

  public TransactionBuilder withClientDepartment(String clientDepartment) {
    this.clientDepartement = clientDepartment;
    return this;
  }

  public TransactionBuilder withSessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  public TransactionBuilder withGdiObjectsStart(Long gdiObjectsStart) {
    this.gdiObjectsStart = gdiObjectsStart;
    return this;
  }

  public TransactionBuilder withGdiObjectsStop(Long gdiObjectsStop) {
    this.gdiObjectsStop = gdiObjectsStop;
    return this;
  }

  public TransactionBuilder withUserObjectsStart(Long userObjectsStart) {
    this.userObjectsStart = userObjectsStart;
    return this;
  }

  public TransactionBuilder withUserObjectsStop(Long userObjectsStop) {
    this.userObjectsStop = userObjectsStop;
    return this;
  }

  public TransactionBuilder withMemoryUsedStart(Long memoryUsedStart) {
    this.memoryUsedStart = memoryUsedStart;
    return this;
  }

  public TransactionBuilder withMemoryUsedStop(Long memoryUsedStop) {
    this.memoryUsedStop = memoryUsedStop;
    return this;
  }

  public TransactionBuilder with(ServiceCallBuilder... serviceCallBuilders) {
    for (ServiceCallBuilder serviceCallBuilder : serviceCallBuilders) {
      this.serviceCallBuilders.add(serviceCallBuilder);
    }
    return this;
  }

  public Transaction build() {

    final Transaction transaction = new Transaction();
    transaction.setTransactionId(transactionId);
    transaction.setName(name);
    transaction.setDistributionTimeComputedClient(distributionTimeComputedClient);
    transaction.setDistributionTimeComputedServer(distributionTimeComputedServer);
    transaction.setDistributionTimeComputedEnduser(distributionTimeComputedEnduser);
    transaction.setMayContainAsyncServerRoundtrips(containAsyncServerRoundtrips);
    transaction.setTimestampStart(timestampStart);
    transaction.setTimestampStop(timestampStop);
    transaction.setEnvironment(environment);
    transaction.setClientUsername(clientUsername);
    transaction.setClientDepartement(clientDepartement);
    transaction.setSessionName(sessionId);
    transaction.setGdiObjectsStart(gdiObjectsStart);
    transaction.setGdiObjectsStop(gdiObjectsStop);
    transaction.setUserObjectsStart(userObjectsStart);
    transaction.setUserObjectsStop(userObjectsStop);
    transaction.setMemoryUsedStart(memoryUsedStart);
    transaction.setMemoryUsedStop(memoryUsedStop);

    for (ServiceCallBuilder serviceCallBuilder : serviceCallBuilders) {
      transaction.getServerRoundtripElements().add(serviceCallBuilder.build());
    }

    return transaction;
  }
}
