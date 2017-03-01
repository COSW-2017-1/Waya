package edu.eci.cosw.security.services;

/**
 * Created by 2091412 on 3/1/17.
 */
public interface SecurityServices {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
