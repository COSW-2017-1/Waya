package edu.eci.cosw.repository;

import edu.eci.cosw.entities.Evento;
import edu.eci.cosw.entities.EventoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by David Useche on 5/05/2017.
 */
@Service
public interface EventsRepository extends JpaRepository<Evento,EventoId>{

    @Query("Select distinct evento from Eventos as evento where evento.id.bar=?1")
    List<Evento> getEventosByBar(int bar);
}
