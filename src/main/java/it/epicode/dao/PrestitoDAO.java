package it.epicode.dao;



import it.epicode.entity.Prestito;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO extends BaseDAO<Prestito> {

    public List<Prestito> findPrestitiInCorsoByNumeroTessera(String numeroTessera) {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL",
                Prestito.class
        );
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> findPrestitiScaduti() {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :oggi AND p.dataRestituzioneEffettiva IS NULL",
                Prestito.class
        );
        query.setParameter("oggi", LocalDate.now());
        return query.getResultList();
    }


    public List<Prestito> findPrestitiByIsbn(String isbn) {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.elementoCatalogo.isbn = :isbn AND p.dataRestituzioneEffettiva IS NULL",
                Prestito.class
        );
        query.setParameter("isbn", isbn);
        return query.getResultList();
    }


    public List<Prestito> findPrestitiByDataInizio(LocalDate dataInizio) {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.dataInizioPrestito = :dataInizio AND p.dataRestituzioneEffettiva IS NULL",
                Prestito.class
        );
        query.setParameter("dataInizio", dataInizio);
        return query.getResultList();
    }


    public List<Prestito> findPrestitiRestituiti() {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NOT NULL",
                Prestito.class
        );
        return query.getResultList();
    }


    public void addPrestito(Prestito prestito) {
        em.getTransaction().begin();
        em.persist(prestito);
        em.getTransaction().commit();
    }


    public void removePrestito(Prestito prestito) {
        em.getTransaction().begin();
        em.remove(prestito);
        em.getTransaction().commit();
    }


}
