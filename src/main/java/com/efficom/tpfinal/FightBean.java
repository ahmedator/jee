package com.efficom.tpfinal;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FightBean {

    @Inject
    private FightDao fightDao;

    public List<Fight> getAllFight(){ return fightDao.getAllFight(); }

    public void addNewFight(Fight fight){
        fightDao.addFight(fight);
    }

    public void deleteFight(UUID uuid){
        fightDao.deleteFight(uuid);
    }

}
