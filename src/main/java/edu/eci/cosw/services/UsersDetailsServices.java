package edu.eci.cosw.services;

import edu.eci.cosw.entities.User;
import edu.eci.cosw.repository.UsersRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
@Service
public class UsersDetailsServices implements UserDetailsService {
    @Autowired
    private UsersRepositoryInterface userRepository;



    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User newUser = userRepository.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(newUser.getUsername(), newUser.getPassword(), newUser.getAuthorities());
    }
}
