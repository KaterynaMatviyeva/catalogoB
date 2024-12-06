package it.epicode.entity;


import javax.persistence.*;
import java.time.DayOfWeek;

@Entity
public class Periodicita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;






    @Enumerated(EnumType.STRING)
    private PeriodicitaTipo tipo; // Giornaliera, settimanale, mensile

    private int intervallo; // Ad esempio, "1" per ogni giorno, ogni settimana, o ogni mese, a seconda del tipo.

    @Enumerated(EnumType.STRING)
    private DayOfWeek giornoSettimana; // Utilizzato se il tipo è settimanale (es. ogni lunedì)

    // Getter e Setter
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
