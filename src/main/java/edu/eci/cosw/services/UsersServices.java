package edu.eci.cosw.services;

import edu.eci.cosw.entities.User;
import edu.eci.cosw.repository.UsersRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
@Service
public class UsersServices implements UsersServicesInterface {
    @Autowired
    private UsersRepositoryInterface usersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
