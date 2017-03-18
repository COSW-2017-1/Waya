package edu.eci.cosw.services;

import edu.eci.cosw.entities.Multimedia;

import java.util.Date;
import java.util.List;

/**
 * Created by david on 17/03/2017.
 */
public interface MultimediaServices {
 List<Multimedia>getMultimedia();
 Multimedia getById(int bar);
 Date getFecha(int bar);

}
