package edu.eci.cosw.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by david on 19/03/2017.
 */
@Embeddable
public class MultimediaId implements Serializable{

    int bar;
    int numero;

    public MultimediaId(int bar, int numero) {
        this.bar = bar;
        this.numero = numero;
    }

    public MultimediaId() {

    }

    @Column(name = "bar", nullable = false)
    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

    @Column(name = "numero", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultimediaId)) return false;

        MultimediaId that = (MultimediaId) o;

        if (bar != that.bar) return false;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {
        int result = bar;
        result = 31 * result + numero;
        return result;
    }
}
