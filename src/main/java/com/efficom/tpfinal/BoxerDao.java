package com.efficom.tpfinal;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
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
        return entityManager.createQuery("" +
                "SELECT boxer " +
                "FROM Boxer boxer", Boxer.class).getResultList();
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

    public void deleteBoxer(UUID uuid){
        entityManager.createQuery("" +
                "DELETE FROM Boxer boxer " +
                "WHERE boxer.id = " + uuid).executeUpdate();
    }
}
