package edu.eci.cosw.services;

import edu.eci.cosw.entities.Bar;
import edu.eci.cosw.entities.Coordenada;

import java.io.InputStream;
import java.util.List;

/**
 * Created by david on 11/02/2017.
 */
public interface BaresServices {

    List<Bar> getBares();

    boolean addBar(Bar bar);

    Bar getById(int id);

    InputStream getLogoById(int id);

    String getNameById(int id);

    String getHorarioById(int id);

    String getDescripcionById(int id);

    String getDireccion(int id);

    Coordenada getCoordenadas(int id);

    String getGeneroById(int id);

    String getTipoById(int id);
}
