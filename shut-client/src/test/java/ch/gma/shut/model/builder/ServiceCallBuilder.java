package ch.gma.shut.model.builder;

import org.joda.time.DateTime;

import ch.gma.shut.model.ServiceCall;

public final class ServiceCallBuilder {

  private long requestId;

  private String businessServiceName;

  private String businessServiceMethod;

  private String descriptionSingleLine;

  private long timestampOverallStart;

  private long timestampOverallEnd;

  private long timestampRequestObjSerializationStart;

  private long timestampRequestObjSerializationEnd;

  private long timestampServerRoundtripStart;

  private long timestampServerRoundtripEnd;

  private long timestampResponseObjDeserializationStart;

  private long timestampResponseObjDeserializationEnd;

  private String httpUrl;

  private int httpStatusCode;

  private long httpRequestContentLength;

  private long httpResponseContentLength;

  private String threadName;

  private ServiceCallBuilder() {

  }

  public static ServiceCallBuilder aServiceCall() {
    return new ServiceCallBuilder();
  }

  public ServiceCallBuilder withRequestId(long requestId) {
    this.requestId = requestId;
    return this;
  }

  public ServiceCallBuilder withBusinessServiceName(String businessServiceName) {
    this.businessServiceName = businessServiceName;
    return this;
  }

  public ServiceCallBuilder withBusinessMethodName(String businessMethodName) {
    this.businessServiceMethod = businessMethodName;
    return this;
  }

  public ServiceCallBuilder withDescriptionSingleLine(String descriptionSingleLine) {
    this.descriptionSingleLine = descriptionSingleLine;
    return this;
  }

  public ServiceCallBuilder withTimestampOverallStart(DateTime timestampOverallStart) {
    this.timestampOverallStart = timestampOverallStart.getMillis();
    return this;
  }

  public ServiceCallBuilder withTimestampOverallEnd(DateTime timestampOverallEnd) {
    this.timestampOverallEnd = timestampOverallEnd.getMillis();
    return this;
  }

  public ServiceCallBuilder withTimestampRequestObjSerializationStart(long timestampRequestObjSerializationStart) {
    this.timestampRequestObjSerializationStart = timestampRequestObjSerializationStart;
    return this;
  }

  public ServiceCallBuilder withTimestampRequestObjSerializationEnd(long timestampRequestObjSerializationEnd) {
    this.timestampRequestObjSerializationEnd = timestampRequestObjSerializationEnd;
    return this;
  }

  public ServiceCallBuilder withTimestampServerRoundtripStart(long timestampServerRoundtripStart) {
    this.timestampServerRoundtripStart = timestampServerRoundtripStart;
    return this;
  }

  public ServiceCallBuilder withTimestampServerRoundtripEnd(long timestampServerRoundtripEnd) {
    this.timestampServerRoundtripEnd = timestampServerRoundtripEnd;
    return this;
  }

  public ServiceCallBuilder withTimestampResponseObjDeserializationStart(long timestampResponseObjDeserializationStart) {
    this.timestampResponseObjDeserializationStart = timestampResponseObjDeserializationStart;
    return this;
  }

  public ServiceCallBuilder withTimestampResponseObjDeserializationEnd(long timestampResponseObjDeserializationEnd) {
    this.timestampResponseObjDeserializationEnd = timestampResponseObjDeserializationEnd;
    return this;
  }

  public ServiceCallBuilder withHttpUrl(String httpUrl) {
    this.httpUrl = httpUrl;
    return this;
  }

  public ServiceCallBuilder withHttpStatusCode(int httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
    return this;
  }

  public ServiceCallBuilder withHttpRequestContentLength(long httpRequestContentLength) {
    this.httpRequestContentLength = httpRequestContentLength;
    return this;
  }

  public ServiceCallBuilder withHttpResponseContentLength(long httpResponseContentLength) {
    this.httpResponseContentLength = httpResponseContentLength;
    return this;
  }

  public ServiceCallBuilder withThreadName(String threadName) {
    this.threadName = threadName;
    return this;
  }

  public ServiceCall build() {

    final ServiceCall serviceCall = new ServiceCall();
    serviceCall.setRequestId(requestId);
    serviceCall.setBusinessServiceName(businessServiceName);
    serviceCall.setBusinessMethodName(businessServiceMethod);
    serviceCall.setDescriptionSingleLine(descriptionSingleLine);
    serviceCall.setTimestampOverallStart(timestampOverallStart);
    serviceCall.setTimestampOverallEnd(timestampOverallEnd);
    serviceCall.setTimestampRequestObjSerializationStart(timestampRequestObjSerializationStart);
    serviceCall.setTimestampRequestObjSerializationEnd(timestampRequestObjSerializationEnd);
    serviceCall.setTimestampServerRoundtripStart(timestampServerRoundtripStart);
    serviceCall.setTimestampServerRoundtripEnd(timestampServerRoundtripEnd);
    serviceCall.setTimestampResponseObjDeserializationStart(timestampResponseObjDeserializationStart);
    serviceCall.setTimestampResponseObjDeserializationEnd(timestampResponseObjDeserializationEnd);
    serviceCall.setHttpUrl(httpUrl);
    serviceCall.setHttpStatusCode(httpStatusCode);
    serviceCall.setHttpRequestContentLength(httpRequestContentLength);
    serviceCall.setHttpResponseContentLength(httpResponseContentLength);
    serviceCall.setThreadName(threadName);

    return serviceCall;
  }
}
