package ch.gma.shut.service;

import ch.gma.shut.model.RecordedTransactions;

public interface ITransactionsStatisticsService {
  /**
   * Dispatch the recorded transactions for further processing (e.g. persist them in the database)
   * 
   * @param recordedTransactions the list of SHUT transactions recorded by the calling client
   */
  void saveTransactionsStatistics(RecordedTransactions recordedTransactions);
}
