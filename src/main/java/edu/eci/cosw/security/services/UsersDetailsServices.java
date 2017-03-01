package edu.eci.cosw.security.services;

import edu.eci.cosw.entities.Person;
import edu.eci.cosw.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
@Service
public class UsersDetailsServices implements UserDetailsService {
    @Autowired
    private PersonsRepository personsRepository;



    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person newUser = personsRepository.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(newUser.getAuthority()));

        return new org.springframework.security.core.userdetails.User(newUser.getUsername(), newUser.getPassword()
                , grantedAuthorities);
    }
}
