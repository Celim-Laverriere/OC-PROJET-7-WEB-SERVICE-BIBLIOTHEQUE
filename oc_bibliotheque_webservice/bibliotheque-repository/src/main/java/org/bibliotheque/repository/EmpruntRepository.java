package org.bibliotheque.repository;

import org.bibliotheque.entity.EmpruntEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends CrudRepository<EmpruntEntity, Integer> {
}
