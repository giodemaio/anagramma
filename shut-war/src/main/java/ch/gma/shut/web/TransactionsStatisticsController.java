package ch.gma.shut.web;

import static java.lang.String.format;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.gma.shut.model.RecordedTransactions;
import ch.gma.shut.service.ITransactionsStatisticsService;

@RestController
@RequestMapping("/statistics")
public class TransactionsStatisticsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsStatisticsController.class);

  private ITransactionsStatisticsService transactionsStatisticsService;

  @Autowired
  public TransactionsStatisticsController(ITransactionsStatisticsService transactionsStatisticsService) {
    this.transactionsStatisticsService = transactionsStatisticsService;
  }

  @RequestMapping(value = "/transactions", method = RequestMethod.POST)
  @ResponseBody
  public int storeTransactions(@RequestBody RecordedTransactions recordedTransactions) {
    int transactionsCount = recordedTransactions.getTransactions().size();
    LOGGER.info(format("Received %d recorded transactions", transactionsCount));
    transactionsStatisticsService.saveTransactionsStatistics(recordedTransactions);
    return transactionsCount;
  }
}
