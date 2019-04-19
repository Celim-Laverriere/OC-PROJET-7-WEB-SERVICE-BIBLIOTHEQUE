package org.service.consumer.contract.dao;

import org.service.model.bean.Livre;
import org.springframework.data.repository.CrudRepository;

public interface LivreDao extends CrudRepository<Livre, Integer> {
}
