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
@Table(name = "MULTIMEDIA")

public class Multimedia implements Serializable{

    Date fechaYHora;
    Blob multimedia;
    String tipo;
    MultimediaId id;

    @EmbeddedId
    public MultimediaId getId() {
        return id;
    }

    public void setId(MultimediaId id) {
        this.id = id;
    }

    public Multimedia(Date fechaYHora, String t, Blob multimedia, MultimediaId id) {
        this.fechaYHora = fechaYHora;
        this.multimedia = multimedia;
        this.id = id;
        this.tipo = t;

    }

    public Multimedia() {
    }

    @JsonIgnore
    @Column(name = "multimedia", nullable = false)
    public Blob getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Blob multimedia) {
        this.multimedia = multimedia;
    }

    @Column(name = "fechayhora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @GeneratedValue
    public Date getFechaYHora() {

        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Multimedia)) return false;

        Multimedia that = (Multimedia) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
