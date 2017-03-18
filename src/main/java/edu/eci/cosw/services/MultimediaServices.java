package edu.eci.cosw.services;

import edu.eci.cosw.entities.Multimedia;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by david on 17/03/2017.
 */
@Service
public interface MultimediaServices {
 List<Multimedia>getMultimedia();
 Multimedia getById(int bar);
 Date getFecha(int bar);

}
