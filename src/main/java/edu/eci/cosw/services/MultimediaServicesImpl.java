package edu.eci.cosw.services;

import edu.eci.cosw.entities.Multimedia;
import edu.eci.cosw.repository.MultimediaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 18/03/2017.
 */
public class MultimediaServicesImpl implements MultimediaServices {
    @Autowired
    MultimediaRepository multimediaRepository;
    @Override
    public List<Multimedia> getMultimedia() {
        return multimediaRepository.findAll();
    }

    @Override
    public Multimedia getById(int bar) {
        return multimediaRepository.findOne(bar);
    }

    @Override
    public Date getFecha(int bar) {

        return multimediaRepository.findOne(bar).getFechaYHora();
    }
}
