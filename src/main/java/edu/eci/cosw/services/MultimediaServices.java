package edu.eci.cosw.services;

import edu.eci.cosw.entities.Multimedia;
import edu.eci.cosw.entities.MultimediaId;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by david on 17/03/2017.
 */
public interface MultimediaServices {

 List<Multimedia> getMultimediaByBar(int bar);
 Multimedia getById(MultimediaId multimediaId);
 Date getFecha(MultimediaId multimediaId);
 void SaveMultimedia(Multimedia multimedia);
 void deleteMultimedia(MultimediaId multimedia);
 InputStream getContentOfMultimedia(MultimediaId multimediaId);

}
