package br.com.schumaker.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("financas");

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
