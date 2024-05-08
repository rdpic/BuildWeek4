package buildWeek.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table (name = "manutenzioni")
public class Manutenzione  {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate dataInizio;

    private LocalDate dataFine;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private List<Mezzo> mezzi;

    public Manutenzione(LocalDate dataInizio, LocalDate dataFine, List<Mezzo> mezzi) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.mezzi = mezzi;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public List<Mezzo> getMezzi() {
        return mezzi;
    }

    public void setMezzi(List<Mezzo> mezzi) {
        this.mezzi = mezzi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
