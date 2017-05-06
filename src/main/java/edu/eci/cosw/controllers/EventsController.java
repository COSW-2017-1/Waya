package edu.eci.cosw.controllers;

import edu.eci.cosw.entities.Evento;
import edu.eci.cosw.entities.EventoId;
import edu.eci.cosw.services.EventosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

/**
 * Created by David Useche on 5/05/2017.
 */
@RestController
@RequestMapping("/eventos")
public class EventsController {

    @Autowired
    EventosServices eventosServices;

    public void setEventosServices(EventosServices services){ eventosServices=services;}

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> getAllEvents(){
        return ResponseEntity.ok().body(eventosServices.getEventos());
    }

    @RequestMapping(path = "/{bar}", method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> getAllEventsFromBar(@PathVariable int bar){
        return ResponseEntity.ok().body(eventosServices.getEventosByBar(bar));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postEvent(@RequestBody Evento evento){
        try{
            eventosServices.saveEvento(evento);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{bar}/{evento}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEvent(@PathVariable int bar, @PathVariable int evento){
        try {
            eventosServices.deleteEvento(new EventoId(evento,bar));
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{bar}/{evento}", method = RequestMethod.GET)
    public ResponseEntity<Evento> getEventoById(@PathVariable int bar, @PathVariable int evento){
        try {
            Evento toReturn = eventosServices.getById(new EventoId(evento,bar));
            if(toReturn==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok().body(toReturn);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{bar}/{evento}/imagen", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getImagenFromEventoById(@PathVariable int bar, @PathVariable int evento){
        try {
            InputStream toReturn = eventosServices.getImagenOfEvento(new EventoId(evento,bar));
            if(toReturn==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg"))
                    .body(new InputStreamResource(toReturn));
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
