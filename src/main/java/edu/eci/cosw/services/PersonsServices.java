package edu.eci.cosw.services;

import edu.eci.cosw.entities.Person;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
public interface PersonsServices {
    void save(Person user);

    Person findByUsername(String username);
}
