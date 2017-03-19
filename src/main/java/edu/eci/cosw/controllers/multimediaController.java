package edu.eci.cosw.controllers;

import edu.eci.cosw.entities.Multimedia;
import edu.eci.cosw.entities.MultimediaId;
import edu.eci.cosw.services.MultimediaServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by david on 17/03/2017.
 */
@RestController
@RequestMapping("/multimedia")
public class multimediaController {

    //@Autowired
    private MultimediaServices multimediaServices;
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Multimedia> getMultimedia(@PathVariable("numero") int numero,@PathVariable("bar")int bar) {
        MultimediaId a=new MultimediaId(bar,numero);

        return ResponseEntity.ok().body(multimediaServices.getById(a));

    }
}
