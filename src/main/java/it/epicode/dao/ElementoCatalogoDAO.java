package it.epicode.dao;


import it.epicode.entity.ElementoCatalogo;

import javax.persistence.TypedQuery;
import java.util.List;

public class ElementoCatalogoDAO extends BaseDAO<ElementoCatalogo> {


    public List<ElementoCatalogo> findByAutore(String autore) {
        TypedQuery<ElementoCatalogo> query = em.createQuery(
                "SELECT e FROM Libro e WHERE e.autore = :autore", ElementoCatalogo.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }


    public List<ElementoCatalogo> findByTitolo(String titolo) {
        TypedQuery<ElementoCatalogo> query = em.createQuery(
                "SELECT e FROM ElementoCatalogo e WHERE LOWER(e.titolo) LIKE LOWER(:titolo)", ElementoCatalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }


    public ElementoCatalogo findByIsbn(String isbn) {
        TypedQuery<ElementoCatalogo> query = em.createQuery(
                "SELECT e FROM ElementoCatalogo e WHERE e.isbn = :isbn", ElementoCatalogo.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }


    public List<ElementoCatalogo> findPrestitiByNumeroTessera(String numeroTessera) {
        TypedQuery<ElementoCatalogo> query = em.createQuery(
                "SELECT p.elementoPrestato FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL",
                ElementoCatalogo.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }


    public List<ElementoCatalogo> findPrestitiScaduti() {
        TypedQuery<ElementoCatalogo> query = em.createQuery(
                "SELECT p.elementoPrestato FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL",
                ElementoCatalogo.class);
        return query.getResultList();
    }


    public void deleteByIsbn(String isbn) {
        em.getTransaction().begin();
        ElementoCatalogo elemento = findByIsbn(isbn);
        if (elemento != null) {
            em.remove(elemento);
        }
        em.getTransaction().commit();
    }
}
