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
        agregarEjemplo();
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

    public String getGeneroById(int id) {
        if(id>=bares.size())return null;
        return bares.get(id).getGenero();
    }

    public String getTipoById(int id) {
        if(id>=bares.size())return null;
        return bares.get(id).getTipo();
    }

    public String getDireccion(int id){
        if(id>=bares.size())return null;
        return bares.get(id).getDireccion();
    }

    public Coordenada getCoordenadas(int id) {
        if(id>=bares.size())return null;
        return new Coordenada(bares.get(id).getLatitud(),bares.get(id).getLongitud());
    }
    private void agregarEjemplo(){
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
