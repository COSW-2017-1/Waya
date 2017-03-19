package edu.eci.cosw.repository;

import edu.eci.cosw.entities.Multimedia;
import edu.eci.cosw.entities.MultimediaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by User on 18/03/2017.
 */
@Service
public interface MultimediaRepository extends JpaRepository<Multimedia,MultimediaId> {

}

