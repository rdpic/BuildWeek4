package buildWeek.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rivenditori")
public class Rivenditore  {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String indirizzo;

    @ManyToMany(mappedBy = "rivenditori")
    private List<BigliettoEAbbonamento> bigliettiEAbbonamenti;

    public Rivenditore( String nome, String indirizzo, List<BigliettoEAbbonamento> bigliettiEAbbonamenti) {

        this.nome = nome;
        this.indirizzo = indirizzo;
        this.bigliettiEAbbonamenti = bigliettiEAbbonamenti;
    }
    public Rivenditore (){

    }



}
