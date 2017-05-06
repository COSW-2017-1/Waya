package edu.eci.cosw.services;

import edu.eci.cosw.entities.Cupon;
import edu.eci.cosw.entities.CuponId;

import java.util.List;

/**
 * Created by David Useche on 5/05/2017.
 */
public interface CuponesServices {

    List<Cupon> getCupones();
    List<Cupon> getCuponesByBar(int bar);
    Cupon getById(CuponId id);
    void saveCupon(Cupon cupon);
    void deleteCupon(CuponId cuponId);

}
