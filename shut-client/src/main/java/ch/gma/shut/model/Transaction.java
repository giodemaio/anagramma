package ch.gma.shut.model;

import java.util.ArrayList;
import java.util.List;

public class Transaction extends RecordedItem {
  private String name;

  private long timestampStart;

  private long timestampStop;

  private int totalServerRoundtripCount = 0;

  private List<ServiceCall> serverRoundtripElements = new ArrayList<ServiceCall>();

  private long distributionTimeComputedClient;

  private long distributionTimeComputedServer;

  private long distributionTimeComputedEnduser;

  private double distributionTimeComputedServerPercent;

  private boolean mayContainAsyncServerRoundtrips;

  private long userObjectsStart;

  private long gdiObjectsStart;

  private long memoryUsedStart;

  private long userObjectsStop;

  private long gdiObjectsStop;

  private long memoryUsedStop;

  private long transactionId;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getTimestampStart() {
    return timestampStart;
  }

  public void setTimestampStart(long timestampStart) {
    this.timestampStart = timestampStart;
  }

  public long getTimestampStop() {
    return timestampStop;
  }

  public void setTimestampStop(long timestampStop) {
    this.timestampStop = timestampStop;
  }

  public int getTotalServerRoundtripCount() {
    return totalServerRoundtripCount;
  }

  public void setTotalServerRoundtripCount(int totalServerRoundtripCount) {
    this.totalServerRoundtripCount = totalServerRoundtripCount;
  }

  public List<ServiceCall> getServerRoundtripElements() {
    return serverRoundtripElements;
  }

  public void setServerRoundtripElements(List<ServiceCall> serverRoundtripElements) {
    this.serverRoundtripElements = serverRoundtripElements;
  }

  public long getDistributionTimeComputedClient() {
    return distributionTimeComputedClient;
  }

  public void setDistributionTimeComputedClient(long distributionTimeComputedClient) {
    this.distributionTimeComputedClient = distributionTimeComputedClient;
  }

  public long getDistributionTimeComputedServer() {
    return distributionTimeComputedServer;
  }

  public void setDistributionTimeComputedServer(long distributionTimeComputedServer) {
    this.distributionTimeComputedServer = distributionTimeComputedServer;
  }

  public long getDistributionTimeComputedEnduser() {
    return distributionTimeComputedEnduser;
  }

  public void setDistributionTimeComputedEnduser(long distributionTimeComputedEnduser) {
    this.distributionTimeComputedEnduser = distributionTimeComputedEnduser;
  }

  public double getDistributionTimeComputedServerPercent() {
    return distributionTimeComputedServerPercent;
  }

  public void setDistributionTimeComputedServerPercent(double distributionTimeComputedServerPercent) {
    this.distributionTimeComputedServerPercent = distributionTimeComputedServerPercent;
  }

  public boolean isMayContainAsyncServerRoundtrips() {
    return mayContainAsyncServerRoundtrips;
  }

  public void setMayContainAsyncServerRoundtrips(boolean mayContainAsyncServerRoundtrips) {
    this.mayContainAsyncServerRoundtrips = mayContainAsyncServerRoundtrips;
  }

  public long getUserObjectsStart() {
    return userObjectsStart;
  }

  public void setUserObjectsStart(long userObjectsStart) {
    this.userObjectsStart = userObjectsStart;
  }

  public long getGdiObjectsStart() {
    return gdiObjectsStart;
  }

  public void setGdiObjectsStart(long gdiObjectsStart) {
    this.gdiObjectsStart = gdiObjectsStart;
  }

  public long getMemoryUsedStart() {
    return memoryUsedStart;
  }

  public void setMemoryUsedStart(long memoryUsedStart) {
    this.memoryUsedStart = memoryUsedStart;
  }

  public long getUserObjectsStop() {
    return userObjectsStop;
  }

  public void setUserObjectsStop(long userObjectsStop) {
    this.userObjectsStop = userObjectsStop;
  }

  public long getGdiObjectsStop() {
    return gdiObjectsStop;
  }

  public void setGdiObjectsStop(long gdiObjectsStop) {
    this.gdiObjectsStop = gdiObjectsStop;
  }

  public long getMemoryUsedStop() {
    return memoryUsedStop;
  }

  public void setMemoryUsedStop(long memoryUsedStop) {
    this.memoryUsedStop = memoryUsedStop;
  }

  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }
}
