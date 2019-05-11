package org.bibliotheque.repository;

import org.bibliotheque.entity.CompteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<CompteEntity, Integer> {

    CompteEntity findByMail(String mail);
}
