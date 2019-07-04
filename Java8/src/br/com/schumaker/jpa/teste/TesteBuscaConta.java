package br.com.schumaker.jpa.teste;

import br.com.schumaker.jpa.modelo.Conta;
import br.com.schumaker.jpa.util.JPAUtil;

import javax.persistence.EntityManager;

/**
 * @author Hudson Schumaker
 */
public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);

        em.getTransaction().commit();
        em.close();
    }

}
