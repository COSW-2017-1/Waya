package edu.eci.cosw.services;

import edu.eci.cosw.entities.Cupon;
import edu.eci.cosw.entities.CuponId;
import edu.eci.cosw.repository.CuponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by David Useche on 5/05/2017.
 */
@Service
public class CuponesServicesImp implements CuponesServices {

    @Autowired
    CuponsRepository cuponsRepository;

    @Override
    public List<Cupon> getCupones() {
        return cuponsRepository.findAll();
    }

    @Override
    public List<Cupon> getCuponesByBar(int bar) {
        return cuponsRepository.getCuponesByBar(bar);
    }

    @Override
    public Cupon getById(CuponId id) {
        return cuponsRepository.findOne(id);
    }

    @Override
    public void saveCupon(Cupon cupon) {
        cupon.getId().setNumero(getCuponesByBar(cupon.getId().getBar()).size());
        cuponsRepository.save(cupon);
    }

    @Override
    public void deleteCupon(CuponId cuponId) {
        cuponsRepository.delete(cuponId);
    }
}
