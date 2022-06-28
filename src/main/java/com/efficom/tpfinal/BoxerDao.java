package com.efficom.tpfinal;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoxerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    public List<Boxer> getAllBoxers() {
        return entityManager.createQuery("SELECT boxer FROM Boxer boxer", Boxer.class).getResultList();
    }

    public Boxer getBoxerByName(String firstName){
        try {
            return (Boxer) entityManager.createQuery(
                            "SELECT b FROM Boxer b WHERE b.firstName = :bfirstName")
                    .setParameter("bfirstName", firstName)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public void addBoxer(Boxer boxer) {
        try {
            userTransaction.begin();
            entityManager.persist(boxer);
            userTransaction.commit();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "jpa error" + e.getMessage());
        }
    }

    public boolean deleteBoxer(UUID uuid) {
        try {
            entityManager.createQuery("DELETE FROM Boxer boxer WHERE boxer.id = " + uuid).executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
