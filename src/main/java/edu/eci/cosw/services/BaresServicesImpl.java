package edu.eci.cosw.services;

import edu.eci.cosw.entities.Bar;
import edu.eci.cosw.entities.Coordenada;
import edu.eci.cosw.repository.BarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by estudiante on 3/15/17.
 */
@Service
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

    public void agregarEjemplo(){
        Bar a=new Bar();
        a.setLogo("https://upload.wikimedia.org/wikipedia/commons/b/b4/JPEG_example_JPG_RIP_100.jpg");
        a.setId(0);
        a.setName("Donde Gladys");
        a.setDescripcion("Este bar y restaurante es ideal para disfrutar de la rumba de los años 60 y 70 con música en vivo, perfecta para los nostálgicos.");
        a.setDireccion("cll falsa #123");
        a.setTipo("freebar");
        a.setGenero("Metal");
        a.setLatitud(4.669070);
        a.setLongitud(-74.055216);
        addBar(a);
        Bar b=new Bar();
        b.setLogo("https://upload.wikimedia.org/wikipedia/commons/b/b4/JPEG_example_JPG_RIP_100.jpg");
        b.setId(1);
        b.setName("Mondrian Bar");
        b.setDescripcion("Es una nueva propuesta para las noches bogotanas donde disfrutarás de la mejor música del momento, tanto anglo como latina en dos salas, una para cada momento de la noche.");
        b.setDireccion("Cra.14a No. 83 – 49");
        b.setTipo("normal");
        b.setGenero("Crossover");
        b.setLatitud(4.668912);
        b.setLongitud(-74.055302);
        addBar(b);
    }
}
