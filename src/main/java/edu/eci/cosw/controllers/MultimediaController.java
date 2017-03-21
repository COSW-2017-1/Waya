package edu.eci.cosw.controllers;


import edu.eci.cosw.entities.Multimedia;
import edu.eci.cosw.entities.MultimediaId;
import edu.eci.cosw.services.MultimediaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by david on 17/03/2017.
 */
@RestController
@RequestMapping("/multimedia")
public class MultimediaController {

    @Autowired
    private MultimediaServices multimediaServices;

    public void setMultimediaServices(MultimediaServices multimediaServices) {
        this.multimediaServices = multimediaServices;
    }

    @RequestMapping(path = "/{bar}/{numero}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Multimedia> getMultimedia(@PathVariable int numero, @PathVariable int bar) {
        MultimediaId a=new MultimediaId(bar,numero);
        Multimedia toReturn = multimediaServices.getById(a);
        if(toReturn == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(toReturn);

    }

    @RequestMapping(path = "/{bar}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Multimedia>> getAllMultimediaBar(@PathVariable int bar){
        List<Multimedia> toReturn = multimediaServices.getMultimediaByBar(bar);
        if(toReturn == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(toReturn);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postMultimedia(@RequestBody Multimedia multimedia){
        if(multimediaServices.getById(multimedia.getId())!=null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        multimediaServices.SaveMultimedia(multimedia);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}