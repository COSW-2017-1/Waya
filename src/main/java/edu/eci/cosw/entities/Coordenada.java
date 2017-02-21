package edu.eci.cosw.entities;

/**
 * Created by david on 18/02/2017.
 */
public class Coordenada {
    double longitud;
    double latitud;

    public Coordenada(){}
	
	public Coordenada(double latitud, double longitud){
        this.longitud=longitud;
        this.latitud=latitud;
    }
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
}
