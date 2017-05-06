package edu.eci.cosw.services;

import edu.eci.cosw.entities.Evento;
import edu.eci.cosw.entities.EventoId;
import edu.eci.cosw.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by David Useche on 5/05/2017.
 */
@Service
public class EventosServicesImp implements EventosServices {

    @Autowired
    EventsRepository eventsRepository;

    @Override
    public List<Evento> getEventos() {
        return eventsRepository.findAll();
    }

    @Override
    public Evento getById(EventoId id) {
        return eventsRepository.findOne(id);
    }

    @Override
    public List<Evento> getEventosByBar(int bar) {
        return eventsRepository.getEventosByBar(bar);
    }

    @Override
    public void saveEvento(Evento evento) {
        evento.getId().setNumero(getEventosByBar(evento.getId().getBar()).size());
        eventsRepository.save(evento);
    }

    @Override
    public void deleteEvento(EventoId eventoId) {
        eventsRepository.delete(eventoId);
    }

    @Override
    public InputStream getImagenOfEvento(EventoId id) {
        if(eventsRepository.findOne(id)==null)return null;
        try{
            return eventsRepository.findOne(id).getImagenPromocional().getBinaryStream();
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
