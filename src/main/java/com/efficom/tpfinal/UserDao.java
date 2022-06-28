package com.efficom.tpfinal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public User getUser(String email, String password) {
        try {
            return (User) entityManager.createQuery(
                            "SELECT u FROM User u WHERE u.email = :email AND u.password = :password ")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    public User getFromToken(String token) {
        try {
            return (User) entityManager.createQuery(
                            "SELECT u FROM User u WHERE u.token = :token")
                    .setParameter("token", token)
                    .getSingleResult();
        } catch (Exception e){
            return null;
        }
    }
}
