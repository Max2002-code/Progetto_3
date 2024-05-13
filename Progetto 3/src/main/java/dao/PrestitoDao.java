package dao;

import entities.ElementoCatalogo;
import entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDao {
    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestito);
        et.commit();
    }

    public Prestito getById(int id) {
        return em.find(Prestito.class, id);
    }

    public void delete(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Prestito prestito = getById(id);

        if (prestito != null) {
            em.remove(prestito);
        } else {
            System.out.println("Prestito non presente");
        }

        et.commit();
    }

    //Query varie

    //get elementi in prestito attualmente
    public List<ElementoCatalogo> getElementiInPrestitoByNumTessera(int tessera) {
        Query query = em.createQuery("select p.elementoPrestato from Prestito p where p.utente.numeroDiTessera = :tessera and p.dataRestituzioneEffettiva is null");
        query.setParameter("tessera", tessera);
        return query.getResultList();
    }


    //get prestiti scaduti, non ancora restituiti

    public List<Prestito> getPrestitiScaduti() {
        LocalDate dataOggi = LocalDate.now();
        Query query = em.createQuery("select p from Prestito p where p.dataRestituzioneEffettiva is null and :dataOggi > p.dataRestituzionePrevista");
        query.setParameter("dataOggi",dataOggi);
        return query.getResultList();
    }
}

