package com.efficom.tpfinal;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BoxerBean {

    @Inject
    private BoxerDao boxerDao;

    public List<Boxer> getBoxers(){ return boxerDao.getAllBoxers(); }

    public Boxer getBoxerByFirstName(String firstName){ return boxerDao.getBoxerByName(firstName); }

    public void addNewBoxer(Boxer boxer){
        boxerDao.addBoxer(boxer);
    }

    public void deleteBoxer(UUID uuid){
        boxerDao.deleteBoxer(uuid);
    }

}
