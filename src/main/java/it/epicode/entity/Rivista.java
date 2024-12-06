package it.epicode.entity;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Rivista extends ElementoCatalogo {

    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
