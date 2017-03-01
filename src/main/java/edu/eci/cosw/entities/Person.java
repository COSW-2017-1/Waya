package edu.eci.cosw.entities;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
@Entity
@Table(name = "Persons")
public class Person {

    private Long id;
    private String username;
    private String password;
    String authority;
    private PersonDetails details;

    protected Person(){}

    public Person(Long id, String username, String password, String authority, PersonDetails details) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.details = details;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "authority")
    public String getAuthority() { return authority; }
    public void setAuthority(String authority) { this.authority = authority; }

    @Embedded
    public PersonDetails getDetails() {
        return details;
    }
    public void setDetails(PersonDetails details) {
        this.details = details;
    }
}
