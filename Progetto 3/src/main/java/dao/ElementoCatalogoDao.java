package dao;

import entities.ElementoCatalogo;
import entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class ElementoCatalogoDao {
    private EntityManager em;

    public ElementoCatalogoDao(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoCatalogo elemento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(elemento);
        et.commit();
    }

    public ElementoCatalogo getById(String isbn) {
        return em.find(ElementoCatalogo.class, UUID.fromString(isbn));
    }

    public void delete(UUID isbn) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        ElementoCatalogo elemento = getById(isbn.toString());

        if (elemento != null) {
            em.remove(elemento);
        } else {
            System.out.println("Elemento non presente nel catalogo");
        }

        et.commit();
    }

    //---------Query varie-----------\\

    //ricerca per anno
    public List<ElementoCatalogo> getElementoByAnnoPubblicazione(int anno){
        Query query = em.createQuery("select e from ElementoCatalogo e where e.annoPubblicazione = :anno");
        query.setParameter("anno",anno);
        return query.getResultList();
    }

    //ricerca per autore

    public List<ElementoCatalogo> getElementoByAutore(String autore){
        Query query = em.createQuery("select e from ElementoCatalogo e where e.autore=:autore");
        query.setParameter("autore", autore);
        return query.getResultList();
    }


    //ricerca per titolo o parte del titolo

    public List<ElementoCatalogo> getElementoByTitolo(String titolo){
        Query query = em.createQuery("select e from ElementoCatalogo e where e.titolo like :titolo");
        query.setParameter("titolo","%" + titolo + "%");
        return query.getResultList();
    }




}
