package org.bibliotheque.service;

import org.bibliotheque.entity.CustomUserDetails;
import org.bibliotheque.repository.LoginRepository;
import org.bibliotheque.wsdl.CompteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<CompteType> optionalCompteType = loginRepository.loginCompte(mail);

        optionalCompteType.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalCompteType.map(CustomUserDetails::new).get();

    }
}
