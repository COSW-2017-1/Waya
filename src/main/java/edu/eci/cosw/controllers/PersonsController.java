package edu.eci.cosw.controllers;

import edu.eci.cosw.entities.Person;
import edu.eci.cosw.services.PersonsServices;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private UserDetailsService userDetailsManager;

    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(path = "/registrer", method = RequestMethod.POST)
    public ResponseEntity<?> registrerUser(@RequestBody Person user, HttpServletRequest request) {
        personsServices.save(user);
        Person newUser = user;
        autoLogin(user.getUsername(), request);
        return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
    }

    private boolean autoLogin(String username, HttpServletRequest request){
        boolean result = false;

        try
        {
            request.getSession();
            UserDetails user = userDetailsManager.loadUserByUsername(username);
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            result = true;

        }catch (Exception e) { System.out.println(e.getMessage()); }

        return result;
    }

}

