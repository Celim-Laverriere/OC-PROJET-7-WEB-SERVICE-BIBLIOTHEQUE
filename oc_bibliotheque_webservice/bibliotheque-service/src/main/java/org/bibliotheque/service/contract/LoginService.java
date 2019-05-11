package org.bibliotheque.service.contract;

import org.bibliotheque.entity.CompteEntity;

public interface LoginService {

    CompteEntity getCompteByMail(String mail);
}
