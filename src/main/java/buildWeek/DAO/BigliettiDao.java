package buildWeek.DAO;

import buildWeek.Entity.Biglietto;
import buildWeek.Entity.BigliettoEAbbonamento;
import buildWeek.Entity.DistributoreAutomatico;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class BigliettiDao {

    private EntityManager em;

    public BigliettiDao(EntityManager em) {
        this.em = em;
    }

    public void save(Biglietto biglietto) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(biglietto);
        et.commit();
    }

    public Biglietto getBigliettiById (int id) {
        return em.find(Biglietto.class, id);
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Biglietto biglietto = getBigliettiById(id);

        if (biglietto != null) {
            em.remove(biglietto);
        } else {
            System.out.println("Biglietto non presente");
        }

        et.commit();
    }

    public void update (DistributoreAutomatico biglietto) {
        EntityTransaction et = em.getTransaction();
        String queryUpdateString = "SELECT  ";
        Query queryUpdate = em.createQuery(queryUpdateString);
        et.begin();

        em.merge(biglietto);

        et.commit();
    }

}
