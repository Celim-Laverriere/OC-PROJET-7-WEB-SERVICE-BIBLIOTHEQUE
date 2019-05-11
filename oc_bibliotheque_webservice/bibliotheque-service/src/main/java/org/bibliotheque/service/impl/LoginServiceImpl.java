package org.bibliotheque.service.impl;

import lombok.NoArgsConstructor;
import org.bibliotheque.entity.CompteEntity;
import org.bibliotheque.repository.LoginRepository;
import org.bibliotheque.service.contract.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@NoArgsConstructor
public class LoginServiceImpl implements LoginService {


    @Autowired
    private LoginRepository repository;

    @Override
    public CompteEntity getCompteByMail(String mail) {
        try{
            return repository.findByMail(mail);
        } catch (Exception pEX){
            pEX.printStackTrace();
            return null;
        }
    }
}
