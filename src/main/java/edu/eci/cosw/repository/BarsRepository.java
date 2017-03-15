package edu.eci.cosw.repository;

import edu.eci.cosw.entities.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by estudiante on 3/15/17.
 */
@Service
public interface BarsRepository extends JpaRepository<Bar,Integer>{

}
