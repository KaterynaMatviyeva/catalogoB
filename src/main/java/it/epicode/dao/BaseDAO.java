package it.epicode.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseDAO<T> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogoPU");
    protected EntityManager em;

    public BaseDAO() {
        this.em = emf.createEntityManager();
    }

    public void save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }






    public T find(Class<T> clazz, Object id) {
        return em.find(clazz, id);
    }

    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
}
