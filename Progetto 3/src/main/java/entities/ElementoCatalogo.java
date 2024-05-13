package entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "elementi_catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ElementoCatalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID isbn;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "num_pagine")
    private Integer numPagine;

    public ElementoCatalogo(UUID isbn, String titolo, int annoPubblicazione, Integer numPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numPagine;
    }

    public ElementoCatalogo() {
    }

    public UUID getIsbn() {
        return this.isbn;
    }

    public int getAnnoPubblicazione() {
        return this.annoPubblicazione;
    }



    public String getTitolo() {
        return this.titolo;
    }

    public Integer getNumPagine() {
        return this.numPagine;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setNumPagine(Integer numPagine) {
        this.numPagine = numPagine;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", dataPubblicazione=" + annoPubblicazione +
                ", numPagine=" + numPagine +
                '}';
    }
}

