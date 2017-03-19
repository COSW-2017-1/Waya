package edu.eci.cosw.services;

import edu.eci.cosw.entities.Multimedia;
import edu.eci.cosw.entities.MultimediaId;
import edu.eci.cosw.repository.MultimediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 18/03/2017.
 */
//@Service
public class MultimediaServicesImpl implements MultimediaServices {

    @Autowired
    MultimediaRepository multimediaRepository;

    @Override
    public List<Multimedia> getMultimediaByBar(int bar) {
        return null;
    }

    @Override
    public Multimedia getById(MultimediaId multimediaId) {
        return null;
    }

    @Override
    public Date getFecha(MultimediaId multimediaId) {
        return null;
    }

    @Override
    public void SaveMultimedia(Multimedia multimedia) {

    }

    @Override
    public void deleteMultimedia(MultimediaId multimedia) {

    }
}
