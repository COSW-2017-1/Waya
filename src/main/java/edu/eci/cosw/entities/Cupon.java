package edu.eci.cosw.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by David Useche on 5/05/2017.
 */
@Entity
@Table(name = "CUPONES")
public class Cupon implements Serializable{

    String tipo;
    float descuento;
    Date fechaExpiracion;
    String titulo;
    CuponId id;

    public Cupon() {
    }

    public Cupon(String tipo, float descuento, Date fechaExpiracion, String titulo, CuponId id) {
        this.tipo = tipo;
        this.descuento = descuento;
        this.fechaExpiracion = fechaExpiracion;
        this.titulo = titulo;
        this.id = id;
    }

    public Cupon(CuponId id) {
        this.id = id;
    }

    @Column(name = "titulo", nullable = false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @EmbeddedId
    public CuponId getId() {
        return id;
    }

    public void setId(CuponId id) {
        this.id = id;
    }

    @Column(name = "tipo", nullable = false)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "descuento", nullable = false)
    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    @Column(name = "fechaExpiracion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cupon cupon = (Cupon) o;

        return id.equals(cupon.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Cupon{" +
                "tipo='" + tipo + '\'' +
                ", descuento=" + descuento +
                ", fechaExpiracion=" + fechaExpiracion +
                ", titulo='" + titulo + '\'' +
                ", id=" + id +
                '}';
    }
}
