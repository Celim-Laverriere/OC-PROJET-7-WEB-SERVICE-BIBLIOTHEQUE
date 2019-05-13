package org.bibliotheque.service;

import org.bibliotheque.repository.LoginRepository;
import org.bibliotheque.wsdl.CompteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Optional<CompteType> optionalCompteType = loginRepository.loginCompte(authentication.getName());

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

         Collection<SimpleGrantedAuthority> roles;
         roles = new ArrayList<>();
         roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        System.out.println(username);
        System.out.println(password);
        System.out.println(optionalCompteType.get().getMail());
        System.out.println(optionalCompteType.get().getMotDePasse());

        for (SimpleGrantedAuthority role : roles){
            System.out.println(role.getAuthority());
        }

        if (optionalCompteType.get().getMail().equals(username) && optionalCompteType.get().getMotDePasse().equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, roles);
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
