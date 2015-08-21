package ch.gma.shut.model;

public class ServiceCall extends RecordedItem {
  private long timestampOverallStart;

  private long timestampOverallEnd;

  private long timestampRequestObjSerializationStart;

  private long timestampRequestObjSerializationEnd;

  private long timestampServerRoundtripStart;

  private long timestampServerRoundtripEnd;

  private long timestampResponseObjDeserializationStart;

  private long timestampResponseObjDeserializationEnd;

  private String httpMethodName;

  private String httpUrl;

  private String httpMethodPath;

  private int httpStatusCode;

  private long httpRequestContentLength;

  private long httpResponseContentLength;

  private String businessServiceName;

  private String businessMethodName;

  private String threadName;

  private long threadId;

  private long requestId;

  private long transactionId;

  private String transactionName;

  private String descriptionSingleLine;

  public long getTimestampOverallStart() {
    return timestampOverallStart;
  }

  public void setTimestampOverallStart(long timestampOverallStart) {
    this.timestampOverallStart = timestampOverallStart;
  }

  public long getTimestampOverallEnd() {
    return timestampOverallEnd;
  }

  public void setTimestampOverallEnd(long timestampOverallEnd) {
    this.timestampOverallEnd = timestampOverallEnd;
  }

  public long getTimestampRequestObjSerializationStart() {
    return timestampRequestObjSerializationStart;
  }

  public void setTimestampRequestObjSerializationStart(long timestampRequestObjSerializationStart) {
    this.timestampRequestObjSerializationStart = timestampRequestObjSerializationStart;
  }

  public long getTimestampRequestObjSerializationEnd() {
    return timestampRequestObjSerializationEnd;
  }

  public void setTimestampRequestObjSerializationEnd(long timestampRequestObjSerializationEnd) {
    this.timestampRequestObjSerializationEnd = timestampRequestObjSerializationEnd;
  }

  public long getTimestampServerRoundtripStart() {
    return timestampServerRoundtripStart;
  }

  public void setTimestampServerRoundtripStart(long timestampServerRoundtripStart) {
    this.timestampServerRoundtripStart = timestampServerRoundtripStart;
  }

  public long getTimestampServerRoundtripEnd() {
    return timestampServerRoundtripEnd;
  }

  public void setTimestampServerRoundtripEnd(long timestampServerRoundtripEnd) {
    this.timestampServerRoundtripEnd = timestampServerRoundtripEnd;
  }

  public long getTimestampResponseObjDeserializationStart() {
    return timestampResponseObjDeserializationStart;
  }

  public void setTimestampResponseObjDeserializationStart(long timestampResponseObjDeserializationStart) {
    this.timestampResponseObjDeserializationStart = timestampResponseObjDeserializationStart;
  }

  public long getTimestampResponseObjDeserializationEnd() {
    return timestampResponseObjDeserializationEnd;
  }

  public void setTimestampResponseObjDeserializationEnd(long timestampResponseObjDeserializationEnd) {
    this.timestampResponseObjDeserializationEnd = timestampResponseObjDeserializationEnd;
  }

  public String getHttpMethodName() {
    return httpMethodName;
  }

  public void setHttpMethodName(String httpMethodName) {
    this.httpMethodName = httpMethodName;
  }

  public String getHttpUrl() {
    return httpUrl;
  }

  public void setHttpUrl(String httpUrl) {
    this.httpUrl = httpUrl;
  }

  public String getHttpMethodPath() {
    return httpMethodPath;
  }

  public void setHttpMethodPath(String httpMethodPath) {
    this.httpMethodPath = httpMethodPath;
  }

  public int getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(int httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

  public long getHttpRequestContentLength() {
    return httpRequestContentLength;
  }

  public void setHttpRequestContentLength(long httpRequestContentLength) {
    this.httpRequestContentLength = httpRequestContentLength;
  }

  public long getHttpResponseContentLength() {
    return httpResponseContentLength;
  }

  public void setHttpResponseContentLength(long httpResponseContentLength) {
    this.httpResponseContentLength = httpResponseContentLength;
  }

  public String getBusinessServiceName() {
    return businessServiceName;
  }

  public void setBusinessServiceName(String businessServiceName) {
    this.businessServiceName = businessServiceName;
  }

  public String getBusinessMethodName() {
    return businessMethodName;
  }

  public void setBusinessMethodName(String businessMethodName) {
    this.businessMethodName = businessMethodName;
  }

  public String getThreadName() {
    return threadName;
  }

  public void setThreadName(String threadName) {
    this.threadName = threadName;
  }

  public long getThreadId() {
    return threadId;
  }

  public void setThreadId(long threadId) {
    this.threadId = threadId;
  }

  public long getRequestId() {
    return requestId;
  }

  public void setRequestId(long requestId) {
    this.requestId = requestId;
  }

  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }

  public String getTransactionName() {
    return transactionName;
  }

  public void setTransactionName(String transactionName) {
    this.transactionName = transactionName;
  }

  public String getDescriptionSingleLine() {
    return descriptionSingleLine;
  }

  public void setDescriptionSingleLine(String descriptionSingleLine) {
    this.descriptionSingleLine = descriptionSingleLine;
  }
}
