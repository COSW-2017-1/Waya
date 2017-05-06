package edu.eci.cosw.services;

import edu.eci.cosw.entities.Evento;
import edu.eci.cosw.entities.EventoId;

import java.io.InputStream;
import java.util.List;

/**
 * Created by David Useche on 5/05/2017.
 */
public interface EventosServices {

    List<Evento> getEventos();
    Evento getById(EventoId id);
    List<Evento> getEventosByBar(int bar);
    void saveEvento(Evento evento);
    void deleteEvento(EventoId eventoId);
    InputStream getImagenOfEvento(EventoId id);
}
