package buildWeek.Entity;

import buildWeek.Enum.DurataAbbonamento;
import buildWeek.Enum.Stato;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "abbonamenti")
public class Abbonamento extends BigliettoEAbbonamento {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @Enumerated(EnumType.STRING)
    private DurataAbbonamento durataAbbonamento;

    @OneToMany(mappedBy = "abbonamento")
    private List<Viaggio> viaggi;

    public Abbonamento(Stato stato, DurataAbbonamento durataAbbonamento) {
        super();
        this.stato = stato;
        this.durataAbbonamento = durataAbbonamento;
    }

    public Abbonamento() {
        super();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public DurataAbbonamento getDurata() {
        return durataAbbonamento;
    }

    public void setDurata(DurataAbbonamento durataAbbonamento) {
        this.durataAbbonamento = durataAbbonamento;
    }
}
