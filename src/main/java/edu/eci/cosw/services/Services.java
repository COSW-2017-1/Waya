package edu.eci.cosw.services;

import edu.eci.cosw.entities.Bar;

import java.util.List;

/**
 * Created by david on 11/02/2017.
 */
public interface Services {

    List<Bar> getBares();

    boolean addBar(Bar bar);

    Bar getById(int id);
}
