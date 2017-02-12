package edu.eci.cosw.controllers;

import edu.eci.cosw.entities.Bar;
import edu.eci.cosw.services.ManejadorBares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by david on 11/02/2017.
 */
@RestController
@RequestMapping("/bares")
public class BaresController {

    @Autowired
    private ManejadorBares manejadorBares;

    public void setManejadorBares(ManejadorBares manejadorBares) {
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
        if (toReturn==null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(toReturn,HttpStatus.ACCEPTED);
    }


}
