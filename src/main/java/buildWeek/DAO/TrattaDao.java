package buildWeek.DAO;

import buildWeek.Entity.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TrattaDao {

    private EntityManager em;

    public TrattaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(tratta);
        et.commit();
    }

    public Tratta getById(int id){
        return em.find(Tratta.class,id);
    }


    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Tratta tratta = getById(id);

        if(tratta!= null){
            em.remove(tratta);
        } else{
            System.out.println("Evento non presente");
        }
        et.commit();
    }
}
