package edu.eci.cosw.services;

import edu.eci.cosw.entities.Bar;
import edu.eci.cosw.entities.Coordenada;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by david on 11/02/2017.
 */
@Service
public class ManejadorBares implements Services {

    private List<Bar> bares;

    public ManejadorBares(){
        bares=new CopyOnWriteArrayList<>();
    }

    public List<Bar> getBares() {
        return bares;
    }

    public boolean addBar(Bar toAdd){
        if(bares.contains(toAdd))return false;
        toAdd.setId(bares.size());
        bares.add(toAdd);
        return true;
    }

    public Bar getById(int id){
        if(id>=bares.size())return null;
        return bares.get(id);
    }

    public InputStream getLogoById(int id) {
        if(id>=bares.size())return null;
        try{
            InputStream toReturn = new URL(bares.get(id).getLogo()).openStream();
            return toReturn;
        }catch (Exception e) {
            return null;
        }
    }

    public String getNameById(int id) {
        if(id>=bares.size())return null;
        return bares.get(id).getName();
    }

    public String getHorarioById(int id) {
        if(id>=bares.size())return null;
        return bares.get(id).getHorario();
    }

    public String getDescripcionById(int id) {
        if(id>=bares.size())return null;
        return bares.get(id).getDescripcion();
    }

    public String getDireccion(int id){
        if(id>=bares.size())return null;
        return bares.get(id).getDireccion();
    }

    public Coordenada getCoordenadas(int id) {
        if(id>=bares.size())return null;
        return new Coordenada(bares.get(id).getLatitud(),bares.get(id).getLongitud());
    }
}
