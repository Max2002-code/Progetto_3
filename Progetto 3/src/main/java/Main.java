import dao.ElementoCatalogoDao;
import dao.PrestitoDao;
import dao.UtenteDao;
import entities.Libro;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;
import enums.Periodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionecatalogo");
        EntityManager em = emf.createEntityManager();

        ElementoCatalogoDao elementoCatalogoDao = new ElementoCatalogoDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);

        //inserimento libri e riviste

        Libro libro1 = new Libro();

        libro1.setAutore("Carlos Ruiz Zafón");
        libro1.setGenere("Romanzo");
        libro1.setTitolo("L'ombra del vento");
        libro1.setAnnoPubblicazione(2001);
        libro1.setNumPagine(400);

        Libro libro2 = new Libro();
        libro2.setAutore("Dan Brown");
        libro2.setGenere("Thriller");
        libro2.setTitolo("Il codice Da Vinci");
        libro2.setAnnoPubblicazione(2003);
        libro2.setNumPagine(350);

        Rivista rivista1 = new Rivista();
        rivista1.setPeriodicita(Periodicita.SETTIMANALE);
        rivista1.setTitolo("Wired");
        rivista1.setAnnoPubblicazione(2024);
        rivista1.setNumPagine(50);

        Rivista rivistaEsistente = (Rivista) elementoCatalogoDao.getById("cf2fe695-41cd-43e4-bee6-0931a7c17c38");

        // parte relativa a utente e prestito

        Utente utente1 = new Utente();
        utente1.setNome("Giovanni");
        utente1.setCognome("Rossi");
        utente1.setDataDiNascita(LocalDate.of(1994, 4, 5));
        utente1.setNumeroDiTessera(56789);

        /*utenteDao.save(utente1);*/

        Utente utente2 = new Utente();
        utente2.setNome("Emanuele");
        utente2.setCognome("Bianchi");
        utente2.setDataDiNascita(LocalDate.of(2001, 5, 10));
        utente2.setNumeroDiTessera(98765);

        /* utenteDao.save(utente2);*/

        Prestito prestito1 = new Prestito();
        prestito1.setUtente(utente2);
        prestito1.setElementoPrestato(libro1);
        prestito1.setDataInizioPrestito(LocalDate.of(2024, 4, 20));


        /*prestitoDao.save(prestito1);
         */

        //elementi attualmente in prestito di un utente data tessera

        /*  System.out.println(prestitoDao.getElementiInPrestitoByNumTessera(12346));*/


        //cerco elementi in prestito attualmente, non ancora restituiti
        prestitoDao.getPrestitiScaduti().forEach(System.out::println
        );


    }
}
