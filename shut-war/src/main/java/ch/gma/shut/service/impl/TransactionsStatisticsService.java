package ch.gma.shut.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.gma.shut.model.RecordedTransactions;
import ch.gma.shut.repository.ITransactionRepository;
import ch.gma.shut.service.ITransactionsStatisticsService;

@Service
public class TransactionsStatisticsService implements ITransactionsStatisticsService {

  private List<ITransactionRepository> repositories;

  private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsStatisticsService.class);

  @Autowired
  public TransactionsStatisticsService(List<ITransactionRepository> repositories) {
    LOGGER.info("Started");
    this.repositories = repositories;
  }

  public void saveTransactionsStatistics(RecordedTransactions recordedTransactions) {
    LOGGER.info("Going to store some stats in the DB");
    for (ITransactionRepository repository : repositories) {
      // TODO : catch any exception that can be thrown to allow to the loop to continue
      repository.save(recordedTransactions.getTransactions());
    }
  }
}
