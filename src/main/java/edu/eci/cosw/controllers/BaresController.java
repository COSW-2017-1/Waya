package edu.eci.cosw.controllers;

import edu.eci.cosw.entities.Bar;
import edu.eci.cosw.entities.Coordenada;
import edu.eci.cosw.entities.Cupon;
import edu.eci.cosw.services.BaresServices;
import edu.eci.cosw.services.CuponesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

/**
 * Created by david on 11/02/2017.
 */
@RestController
@RequestMapping("/bares")
public class BaresController {

    @Autowired
    private BaresServices manejadorBares;

    @Autowired
    private CuponesServices cuponesServices;

    public void setManejadorBares(BaresServices manejadorBares) {
        this.manejadorBares = manejadorBares;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> obtainBares(){
        return new ResponseEntity<>(manejadorBares.getBares(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postBar(@RequestBody Bar bar){
        if (manejadorBares.addBar(bar))return new ResponseEntity<>(HttpStatus.ACCEPTED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> barById(@PathVariable int id) {
        Bar toReturn = manejadorBares.getById(id);
        if (toReturn==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(toReturn,HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}/logo", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> logoById(@PathVariable int id){
        InputStream logo = manejadorBares.getLogoById(id);
        if(logo==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg"))
                .body(new InputStreamResource(logo));
    }

    @RequestMapping(path = "/{id}/name", method = RequestMethod.GET)
    public ResponseEntity<?> nameById(@PathVariable int id){
        String name = manejadorBares.getNameById(id);
        if(name==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(name,HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}/horario", method = RequestMethod.GET)
    public ResponseEntity<?> horarioById(@PathVariable int id){
        String horario = manejadorBares.getHorarioById(id);
        if(horario==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(horario,HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}/tipo", method = RequestMethod.GET)
    public ResponseEntity<?> tipoById(@PathVariable int id){
        String tipo = manejadorBares.getTipoById(id);
        if(tipo==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(tipo,HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}/descripcion", method = RequestMethod.GET)
    public ResponseEntity<?> descripcionById(@PathVariable int id){
        String descripcion = manejadorBares.getDescripcionById(id);
        if(descripcion==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(descripcion,HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}/direccion", method = RequestMethod.GET)
    public ResponseEntity<?> direccionById(@PathVariable int id){
        String direccion = manejadorBares.getDireccion(id);
        if(direccion==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(direccion,HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}/genero", method = RequestMethod.GET)
    public ResponseEntity<?> generoById(@PathVariable int id){
        String genero = manejadorBares.getGeneroById(id);
        if(genero==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(genero,HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}/coordenadas", method = RequestMethod.GET)
    public ResponseEntity<?> coordenadasById(@PathVariable int id){
        Coordenada coordenada = manejadorBares.getCoordenadas(id);
        if(coordenada==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(coordenada,HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{bar}/cupones", method = RequestMethod.GET)
    public ResponseEntity<List<Cupon>> getCuponesFromBar(@PathVariable int bar){
        List<Cupon> toReturn = cuponesServices.getCuponesByBar(bar);
        if(toReturn == null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().body(toReturn);
    }
}
