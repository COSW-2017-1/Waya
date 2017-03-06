package edu.eci.cosw.controllers;

import edu.eci.cosw.entities.Person;
import edu.eci.cosw.security.services.SecurityServices;
import edu.eci.cosw.services.PersonsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
@RestController
@RequestMapping("/app/user")
public class PersonsController {
    @Autowired
    PersonsServices personsServices;
    @Autowired
    private SecurityServices securityServices;

    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(path = "/registrer", method = RequestMethod.POST)
    public ResponseEntity<?> registrerUser(@RequestBody Person user) {
        System.out.println("username->>> " + user.getUsername());
        System.out.println("password->>> " + user.getPassword());
        personsServices.save(user);
        Person newUser = user;

        //securityServices.autologin(user.getUsername(), user.getPassword());

        return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
    }

}

