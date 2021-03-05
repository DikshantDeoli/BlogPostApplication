package com.upgrad.BlogPostApplication.repository;

import com.upgrad.BlogPostApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepository {
    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;


    public void registerUser(User newUser)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try
        {
            transaction.begin();
            em.persist(newUser);
            transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            transaction.rollback();
        }
        return;
    }

    public User checkCredentials(String username,String password)
    {
        try
        {
            EntityManager em = emf.createEntityManager();
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username= :username AND u.password = :password", User.class);

            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        }
        catch(NoResultException e)
        {
            return null;
        }
    }
}
