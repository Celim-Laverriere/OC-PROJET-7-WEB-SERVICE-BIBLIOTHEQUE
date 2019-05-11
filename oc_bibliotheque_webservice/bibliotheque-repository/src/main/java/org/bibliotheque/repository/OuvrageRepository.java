package org.bibliotheque.repository;

import org.bibliotheque.entity.OuvrageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OuvrageRepository extends CrudRepository<OuvrageEntity, Integer> {

}
