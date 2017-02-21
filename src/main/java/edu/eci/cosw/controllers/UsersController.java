package edu.eci.cosw.controllers;

import edu.eci.cosw.entities.User;
import edu.eci.cosw.services.UsersServices;
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
public class UsersController {
    @Autowired
    UsersServices usersServices;

    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(path = "/registrer", method = RequestMethod.POST)
    public ResponseEntity<?> registrerUser(@RequestBody User user) {
        System.out.println("->>> " + user.getUsername());
        usersServices.save(user);
        User newUser = user;
        return new ResponseEntity<>(newUser,HttpStatus.ACCEPTED);
    }

}

