package com.efficom.tpfinal;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FightDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    public List<Fight> getAllFight() {
        return entityManager.createQuery(
                "SELECT fight " +
                "FROM Fight fight ", Fight.class).getResultList();
    }

    public void addFight(Fight fight) {
        try {
            userTransaction.begin();
            entityManager.persist(fight);
            userTransaction.commit();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "jpa error" + e.getMessage());
        }
    }

    public void deleteFight(UUID uuid){
        entityManager.createQuery("" +
                "DELETE FROM Fight fight " +
                "WHERE fight.uuid_fight = " + uuid).executeUpdate();
    }
}
