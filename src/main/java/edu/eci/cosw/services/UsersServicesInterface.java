package edu.eci.cosw.services;

import edu.eci.cosw.entities.User;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
public interface UsersServicesInterface {
    void save(User user);

    User findByUsername(String username);
}
