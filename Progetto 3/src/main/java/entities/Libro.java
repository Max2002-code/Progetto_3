package entities;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;

    public Libro(UUID isbn, String titolo, int annoPubblicazione, Integer numPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro() {
    }

    public String getAutore() {
        return this.autore;
    }

    public String getGenere() {
        return this.genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
