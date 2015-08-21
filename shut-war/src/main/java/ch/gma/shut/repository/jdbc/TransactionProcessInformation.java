package ch.gma.shut.repository.jdbc;

import java.util.Arrays;

class TransactionProcessInformation {
  private String[] info;

  public TransactionProcessInformation(String transactionName, String splitChar) {
    initializeFrom(transactionName, splitChar);
  }

  private void initializeFrom(String transactionName, String splitChar) {
    this.info = computeProcessInformation(transactionName, splitChar);
  }

  private String[] computeProcessInformation(String transactionName, String splitChar) {
    final String[] processInfos = transactionName.split(splitChar);
    return Arrays.copyOf(processInfos, 8);
  }

  public String getDomaine() {
    return info[0];
  }

  public String getProcess() {
    return info[1];
  }

  public String getProcessId() {
    return info[2];
  }

  public String getBusinessId() {
    return info[3];
  }

  public String getTaskType() {
    return info[4];
  }

  public String getTaskId() {
    return info[5];
  }

  public String getStep() {
    return info[6];
  }

  public String getAction() {
    return info[7];
  }
}
