package ch.gma.shut.model.builder;

import java.util.ArrayList;
import java.util.List;

import ch.gma.shut.model.RecordedTransactions;

public final class RecordedTransactionsBuilder {

  private List<TransactionBuilder> transactionBuilders = new ArrayList<TransactionBuilder>();

  private RecordedTransactionsBuilder() {
  }

  public static RecordedTransactionsBuilder aRecordedTransaction() {
    return new RecordedTransactionsBuilder();
  }

  public RecordedTransactionsBuilder with(TransactionBuilder... transactionBuilders) {
    for (TransactionBuilder transactionBuilder : transactionBuilders) {
      this.transactionBuilders.add(transactionBuilder);
    }

    return this;
  }

  public RecordedTransactions build() {
    final RecordedTransactions recordedTransactions = new RecordedTransactions();

    for (TransactionBuilder transactionBuilder : transactionBuilders) {
      recordedTransactions.getTransactions().add(transactionBuilder.build());
    }
    return recordedTransactions;
  }
}
