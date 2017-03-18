package edu.eci.cosw.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by david on 17/03/2017.
 */
@Entity
@IdClass(Multimedia.class)
@Table(name = "MULTIMEDIA")

public class Multimedia implements Serializable{

    Date fechaYHora;
    Blob multimedia;
    int bar;

    @Column(name = "bar")
    @Id
    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

    public Multimedia() {
    }

    @JsonIgnore
    @Column(name = "multimedia")
    @Id
    public Blob getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Blob multimedia) {
        this.multimedia = multimedia;
    }

    @Column(name = "fechayhora")
    @Temporal(TemporalType.TIMESTAMP)
    @GeneratedValue
    @Id
    public Date getFechaYHora() {

        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

}
