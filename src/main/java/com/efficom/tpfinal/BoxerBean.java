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
public class BoxerBean {

    @Inject
    private BoxerDao boxerDao;

    @Transactional
    public List<Boxer> getBoxers(){ return boxerDao.getAllBoxers(); }

    @Transactional
    public Boxer getBoxerByFirstName(String firstName){ return boxerDao.getBoxerByName(firstName); }

    @Transactional
    public void addNewBoxer(Boxer boxer){
        boxerDao.addBoxer(boxer);
    }

    @Transactional
    public boolean deleteBoxer(UUID uuid){
        return boxerDao.deleteBoxer(uuid);
    }

}
