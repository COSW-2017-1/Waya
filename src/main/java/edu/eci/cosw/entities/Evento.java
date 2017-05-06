package edu.eci.cosw.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by David Useche on 5/05/2017.
 */
@Entity
@Table(name = "EVENTOS")
public class Evento implements Serializable {

    Blob imagenPromocional;
    String name;
    EventoId id;
    Date fecha;

    public Evento(Blob imagenPromocional, String name, EventoId id) {
        this.imagenPromocional = imagenPromocional;
        this.name = name;
        this.id = id;
    }

    public Evento() {
    }

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @JsonIgnore
    @Column(name = "imagenPromocional")
    public Blob getImagenPromocional() {
        return imagenPromocional;
    }

    public void setImagenPromocional(Blob imagenPromocional) {
        this.imagenPromocional = imagenPromocional;
    }

    @Column(name = "nombre")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @EmbeddedId
    public EventoId getId() {
        return id;
    }

    public void setId(EventoId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evento evento = (Evento) o;

        return id != null ? id.equals(evento.id) : evento.id == null;
    }

    @Override
    public int hashCode() {
        int result = imagenPromocional.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + fecha.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "imagenPromocional=" + imagenPromocional +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", fecha=" + fecha +
                '}';
    }
}
