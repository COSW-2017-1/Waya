package edu.eci.cosw.entities;

/**
 * Created by david on 18/02/2017.
 */
public class Coordenada {
    float longitud;
    float latitud;

    public Coordenada(){}
	
	public Coordenada(float latitud, float longitud){
        this.longitud=longitud;
        this.latitud=latitud;
    }
    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }
}
