package edu.eci.cosw.repository;

import edu.eci.cosw.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
@Service
public class UsersRepository implements  UsersRepositoryInterface{

    HashMap<String, User> users = new HashMap<>();
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User findByUsername(String username) {
        return users.get(username);
    }

    @Override
    public void save(User user) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        user.setAuthorities(authorities);

        UserDetails newUser = new org.springframework.security.core.userdetails.User(user.getUsername()
                , user.getPassword() //Agregar encriptador de passwords
                , user.getAuthorities());

        users.put(user.getUsername(), user);
    }
}
