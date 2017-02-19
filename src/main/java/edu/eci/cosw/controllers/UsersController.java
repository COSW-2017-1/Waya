package edu.eci.cosw.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
@RestController
public class UsersController {

    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }
}

