package edu.eci.cosw.services;

import edu.eci.cosw.entities.Person;
import edu.eci.cosw.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
@Service
public class PersonsServicesImpl implements PersonsServices{

    HashMap<String, Person> persons = new HashMap<>();

    @Autowired
    private PersonsRepository personsRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Person person) {
        person.setAuthority("ROLE_USER");
        personsRepository.save(person);
    }

    @Override
    public Person findByUsername(String username) {
        return personsRepository.findByUsername(username);
    }
}
