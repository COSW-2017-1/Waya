package edu.eci.cosw.repository;

import edu.eci.cosw.entities.Multimedia;
import edu.eci.cosw.entities.MultimediaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 18/03/2017.
 */
@Service
public interface MultimediaRepository extends JpaRepository<Multimedia,MultimediaId> {

    @Query("Select distinct multimedia from Multimedia as multimedia where multimedia.id.bar = ?1")
    List<Multimedia> getMultimediaByBar(int bar);
}

