package com.efficom.tpfinal;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserBean {

    private static final String BASIC = "Basic ";

    @Inject
    public UserDao userDao;

    @Transactional
    public void addNewUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void connectUser(String basicAuthorization) {
        String[] logins = new String(Base64.getDecoder().decode(basicAuthorization.replace(BASIC, ""))).split(":");

        Logins currentUserCredentials = new Logins(logins[0], logins[1]);

        User currentUser = userDao.getUser(currentUserCredentials.getEmail(), currentUserCredentials.getPassword());
        currentUser.setToken(generateToken());
        userDao.updateUser(currentUser);
    }

    @Transactional
    public String generateToken() {
        return UUID.randomUUID().toString();
    }
}
