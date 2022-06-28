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

    public List<Fight> getAllFight() {
        return entityManager.createQuery(
                "SELECT fight " +
                "FROM Fight fight ", Fight.class).getResultList();
    }

    public void addFight(Fight fight) {
        entityManager.persist(fight);
    }

    public void deleteFight(UUID uuid){
        entityManager.createQuery("" +
                "DELETE FROM Fight fight " +
                "WHERE fight.uuid_fight = " + uuid).executeUpdate();
    }
}
