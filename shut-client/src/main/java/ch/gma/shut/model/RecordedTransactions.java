package ch.gma.shut.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecordedTransactions implements Serializable {
  private List<Transaction> transactions = new ArrayList<Transaction>();

  public List<Transaction> getTransactions () {
    return transactions;
  }

  public void setTransactions (List<Transaction> transactions) {
    this.transactions = transactions;
  }
}
