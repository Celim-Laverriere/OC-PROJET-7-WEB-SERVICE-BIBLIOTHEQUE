package org.bibliotheque.entity;

import org.bibliotheque.wsdl.CompteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class CustomUserDetails extends CompteType implements UserDetails {

    private CompteType compteType;

    @Autowired
    public CustomUserDetails(CompteType compteType) {
        this.compteType = compteType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<String> roles = new HashSet<>();
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_USER"))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return compteType.getMotDePasse();
    }

    @Override
    public String getUsername() {
        return compteType.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
