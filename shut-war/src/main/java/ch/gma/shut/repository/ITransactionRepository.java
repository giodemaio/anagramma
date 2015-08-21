package ch.gma.shut.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import ch.gma.shut.model.Transaction;

public interface ITransactionRepository {

  void save(List<Transaction> transaction) throws DataAccessException;

}
