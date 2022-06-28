package com.efficom.tpfinal;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FightBean {

    @Inject
    private FightDao fightDao;

    @Transactional
    public List<Fight> getAllFight(){ return fightDao.getAllFight(); }

    @Transactional
    public void addNewFight(Fight fight){
        fightDao.addFight(fight);
    }

    @Transactional
    public void deleteFight(UUID uuid){
        fightDao.deleteFight(uuid);
    }

}
