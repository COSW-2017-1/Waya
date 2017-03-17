package edu.eci.cosw.entities;

import java.util.Date;

/**
 * Created by david on 17/03/2017.
 */
public class Multimedia {

    public Multimedia() {
    }

    public Date getFechaYHora() {

        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    Date fechaYHora;
}
