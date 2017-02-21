package edu.eci.cosw.repository;

import edu.eci.cosw.entities.User;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
public interface UsersRepositoryInterface {
    User findByUsername(String username);

    void save(User user);
}