package edu.eci.cosw.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by David Useche on 5/05/2017.
 */
@Embeddable
public class EventoId implements Serializable{

    int numero;
    Integer bar;

    public EventoId(int numero, Integer bar) {
        this.bar = bar;
        this.numero = numero;
    }

    public EventoId() {
    }

    @Column(name = "numero", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name = "bar", nullable = false)
    public Integer getBar() {
        return bar;
    }

    public void setBar(Integer bar) {
        this.bar = bar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventoId eventoId = (EventoId) o;

        if (numero != eventoId.numero) return false;
        return bar.equals(eventoId.bar);
    }

    @Override
    public int hashCode() {
        int result = numero;
        result = 31 * result + bar.hashCode();
        return result;
    }
}
