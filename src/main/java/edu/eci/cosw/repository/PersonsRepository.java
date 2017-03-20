package edu.eci.cosw.repository;

import edu.eci.cosw.entities.Person;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by 2091412 on 3/1/17.
 */
@EnableJpaRepositories("edu.eci.cosw.repository")
@EntityScan("edu.eci.cosw.entities")
public interface PersonsRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
