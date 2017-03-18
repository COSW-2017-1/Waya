package edu.eci.cosw.controllers;

import edu.eci.cosw.services.MultimediaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by david on 17/03/2017.
 */
@RestController
@RequestMapping("/multimedia")
public class multimediaController {

    //@Autowired
    private MultimediaServices multimediaServices;
}
