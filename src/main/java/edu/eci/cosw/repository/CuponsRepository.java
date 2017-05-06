package edu.eci.cosw.repository;

import edu.eci.cosw.entities.Cupon;
import edu.eci.cosw.entities.CuponId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by David Useche on 5/05/2017.
 */
@Service
public interface CuponsRepository extends JpaRepository<Cupon, CuponId> {

    @Query("Select distinct cupon from Cupones where cupon.id.bar=?1")
    List<Cupon> getCuponesByBar(int bar);
}
