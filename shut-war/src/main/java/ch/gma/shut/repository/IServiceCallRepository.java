package ch.gma.shut.repository;

import org.springframework.dao.DataAccessException;

import ch.gma.shut.model.ServiceCall;
import ch.gma.shut.model.Transaction;

public interface IServiceCallRepository {

  void save(ServiceCall serviceCall, Transaction transaction) throws DataAccessException;

}
