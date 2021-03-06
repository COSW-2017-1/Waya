package edu.eci.cosw.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by david on 11/02/2017.
 */
@Entity
@Table(name="BARES")
public class Bar implements Serializable{

    String logo;
    String name;
    int id;
    String descripcion;
    String horario;
    String direccion;
    String tipo;
    String genero;
    double longitud;
    double latitud;

    Set<Multimedia> multimedia=new HashSet<>();
    List<Evento> eventos;
    List<Cupon> cupones;

    public Bar(String logo, String name, int id, String descripcion, String horario, String direccion, String tipo, String genero, double longitud, double latitud, Set<Multimedia> multimedia) {
        this.logo = logo;
        this.name = name;
        this.id = id;
        this.descripcion = descripcion;
        this.horario = horario;
        this.direccion = direccion;
        this.tipo = tipo;
        this.genero = genero;
        this.longitud = longitud;
        this.latitud = latitud;
        this.multimedia = multimedia;
    }

    public Bar(String logo, String name, int id, String descripcion, String horario, String direccion, String tipo, String genero, double longitud, double latitud) {
        this.logo = logo;
        this.name = name;
        this.id = id;
        this.descripcion = descripcion;
        this.horario = horario;
        this.direccion = direccion;
        this.tipo = tipo;
        this.genero = genero;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Bar(String logo, String name, int id, String descripcion, String horario, String direccion, String tipo, String genero, double longitud, double latitud, Set<Multimedia> multimedia, List<Evento> eventos, List<Cupon> cupones) {
        this.logo = logo;
        this.name = name;
        this.id = id;
        this.descripcion = descripcion;
        this.horario = horario;
        this.direccion = direccion;
        this.tipo = tipo;
        this.genero = genero;
        this.longitud = longitud;
        this.latitud = latitud;
        this.multimedia = multimedia;
        this.eventos = eventos;
        this.cupones = cupones;
    }

    @OneToMany
    @JoinColumn(name = "bar", referencedColumnName = "bar", nullable = false, insertable = false, updatable = false)
    public Set<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Set<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    @Column(name = "genero")
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "longitud")
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Column(name = "latitud")
    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Bar(){}

    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "bar")
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "horario")
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @OneToMany
    @JoinColumn(name = "bar", referencedColumnName = "bar", nullable = false, insertable = false, updatable = false)
    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @OneToMany
    @JoinColumn(name = "bar", referencedColumnName = "bar", nullable = false, insertable = false, updatable = false)
    public List<Cupon> getCupones() {
        return cupones;
    }

    public void setCupones(List<Cupon> cupones) {
        this.cupones = cupones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        return name != null ? name.equals(bar.name) : bar.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
