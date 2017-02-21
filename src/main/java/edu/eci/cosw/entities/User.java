package edu.eci.cosw.entities;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
public class User {
    private Long id;
    private String username;
    private String password;
    List<GrantedAuthority> authorities;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GrantedAuthority> getAuthorities() { return authorities; }

    public void setAuthorities(List<GrantedAuthority> authorities) { this.authorities = authorities; }

}
