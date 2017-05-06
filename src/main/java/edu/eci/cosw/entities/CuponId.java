package edu.eci.cosw.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by David Useche on 5/05/2017.
 */
@Embeddable
public class CuponId implements Serializable{

    int bar;
    int numero;

    public CuponId(int bar) {
        this.bar = bar;
    }

    public CuponId(int bar, int numero) {
        this.bar = bar;
        this.numero = numero;
    }

    public CuponId() {
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
        if (o == null || getClass() != o.getClass()) return false;

        CuponId cuponId = (CuponId) o;

        if (bar != cuponId.bar) return false;
        return numero == cuponId.numero;
    }

    @Override
    public int hashCode() {
        int result = bar;
        result = 31 * result + numero;
        return result;
    }

    @Override
    public String toString() {
        return "CuponId{" +
                "bar=" + bar +
                ", numero=" + numero +
                '}';
    }
}
