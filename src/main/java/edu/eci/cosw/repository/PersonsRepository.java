package edu.eci.cosw.repository;

import edu.eci.cosw.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by 2091412 on 3/1/17.
 */
@Service
public interface PersonsRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
