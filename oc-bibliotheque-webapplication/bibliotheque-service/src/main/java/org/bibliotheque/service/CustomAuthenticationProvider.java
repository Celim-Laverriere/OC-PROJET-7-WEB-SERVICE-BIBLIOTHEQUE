package org.bibliotheque.service;

import org.bibliotheque.repository.LoginRepository;
import org.bibliotheque.wsdl.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Collection<SimpleGrantedAuthority> roles;
        roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));

        Optional<ServiceStatus> serviceStatus = loginRepository.loginCompte
                (authentication.getName(), authentication.getCredentials().toString());

        if (serviceStatus.get().getStatusCode().equals("SUCCESS")){
            return new UsernamePasswordAuthenticationToken
                    (authentication.getName(), authentication.getCredentials().toString(), roles);
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
