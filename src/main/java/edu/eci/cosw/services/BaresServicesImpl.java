package edu.eci.cosw.services;

import edu.eci.cosw.entities.Bar;
import edu.eci.cosw.entities.Coordenada;
import edu.eci.cosw.repository.BarsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by estudiante on 3/15/17.
 */
public class BaresServicesImpl implements BaresServices{

    @Autowired
    BarsRepository bars;

    @Override
    public List<Bar> getBares() {
        return bars.findAll();
    }

    @Override
    public boolean addBar(Bar bar) {
        if(bars.findOne(bar.getId())!=null)return false;
        bars.save(bar);
        return true;
    }

    @Override
    public Bar getById(int id) {
        return bars.findOne(id);
    }

    @Override
    public InputStream getLogoById(int id) {
        Bar toExtract = bars.findOne(id);
        if(toExtract==null)return null;
        try{
            InputStream ans = new URL(toExtract.getLogo()).openStream();
            return ans;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public String getNameById(int id) {
        if(bars.findOne(id)==null)return null;
        return bars.findOne(id).getName();
    }

    @Override
    public String getHorarioById(int id) {
        if(bars.findOne(id)==null)return null;
        return bars.findOne(id).getHorario();
    }

    @Override
    public String getDescripcionById(int id) {
        if(bars.findOne(id)==null)return null;
        return bars.findOne(id).getDescripcion();
    }

    @Override
    public String getDireccion(int id) {
        if(bars.findOne(id)==null)return null;
        return bars.findOne(id).getDireccion();
    }

    @Override
    public Coordenada getCoordenadas(int id) {
        if(bars.findOne(id)==null)return null;
        return new Coordenada(bars.findOne(id).getLatitud(), bars.findOne(id).getLongitud());
    }

    @Override
    public String getGeneroById(int id) {
        if(bars.findOne(id)==null)return null;
        return bars.findOne(id).getGenero();
    }

    @Override
    public String getTipoById(int id) {
        if(bars.findOne(id)==null)return null;
        return bars.findOne(id).getTipo();
    }
}
