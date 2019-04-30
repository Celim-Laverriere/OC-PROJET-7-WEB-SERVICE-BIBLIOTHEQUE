package org.bibliotheque.repository;

import org.bibliotheque.entity.LivreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliothequeRepository extends CrudRepository<LivreEntity, Integer> {
}
