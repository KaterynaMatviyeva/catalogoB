package it.epicode.entity;


import javax.persistence.*;
import java.time.DayOfWeek;

@Entity
public class Periodicita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PeriodicitaTipo tipo;

    private int intervallo;

    @Enumerated(EnumType.STRING)
    private DayOfWeek giornoSettimana;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PeriodicitaTipo getTipo() {
        return tipo;
    }

    public void setTipo(PeriodicitaTipo tipo) {
        this.tipo = tipo;
    }

    public int getIntervallo() {
        return intervallo;
    }

    public void setIntervallo(int intervallo) {
        this.intervallo = intervallo;
    }

    public DayOfWeek getGiornoSettimana() {
        return giornoSettimana;
    }

    public void setGiornoSettimana(DayOfWeek giornoSettimana) {
        this.giornoSettimana = giornoSettimana;
    }
}
