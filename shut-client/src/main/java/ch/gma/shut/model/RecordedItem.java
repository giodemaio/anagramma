package ch.gma.shut.model;

import java.io.Serializable;

public abstract class RecordedItem implements Serializable {
  private String clientUsername;
  private String clientDepartement;
  private String environment;
  private String sessionName;

  public String getClientUsername() {
    return clientUsername;
  }

  public void setClientUsername(String clientUsername) {
    this.clientUsername = clientUsername;
  }

  public String getClientDepartement() {
    return clientDepartement;
  }

  public void setClientDepartement(String clientDepartement) {
    this.clientDepartement = clientDepartement;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public String getSessionName() {
    return sessionName;
  }

  public void setSessionName(String sessionName) {
    this.sessionName = sessionName;
  }
}
