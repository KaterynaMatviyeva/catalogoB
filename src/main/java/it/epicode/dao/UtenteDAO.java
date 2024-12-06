package it.epicode.dao;



import it.epicode.entity.Utente;

import javax.persistence.TypedQuery;
import java.util.List;

public class UtenteDAO extends BaseDAO<Utente> {


    public Utente findByNumeroTesseraUnico(String numeroTessera) {
        TypedQuery<Utente> query = em.createQuery(
                "SELECT u FROM Utente u WHERE u.numeroTessera = :numeroTessera", Utente.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getSingleResult();
    }


    public List<Utente> findByNome(String nome) {
        TypedQuery<Utente> query = em.createQuery(
                "SELECT u FROM Utente u WHERE LOWER(u.nome) LIKE LOWER(:nome)", Utente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }


    public List<Utente> findByCognome(String cognome) {
        TypedQuery<Utente> query = em.createQuery(
                "SELECT u FROM Utente u WHERE LOWER(u.cognome) LIKE LOWER(:cognome)", Utente.class);
        query.setParameter("cognome", "%" + cognome + "%");
        return query.getResultList();
    }


    public Utente findByEmail(String email) {
        TypedQuery<Utente> query = em.createQuery(
                "SELECT u FROM Utente u WHERE u.email = :email", Utente.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }


    public boolean existsByNumeroTessera(String numeroTessera) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM Utente u WHERE u.numeroTessera = :numeroTessera", Long.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getSingleResult() > 0;
    }


    public List<Utente> findAllUtenti() {
        TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u", Utente.class);
        return query.getResultList();
    }


    public void deleteByNumeroTessera(String numeroTessera) {
        em.getTransaction().begin();
        Utente utente = findByNumeroTesseraUnico(numeroTessera);
        if (utente != null) {
            em.remove(utente);
        }
        em.getTransaction().commit();
    }
}
