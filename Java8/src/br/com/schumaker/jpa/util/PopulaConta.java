package br.com.schumaker.jpa.util;

import javax.persistence.EntityManager;

import br.com.schumaker.jpa.modelo.Conta;

/**
 * @author Hudson Schumaker
 */
public class PopulaConta {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        Conta conta3 = new Conta();
        Conta conta4 = new Conta();
        Conta conta5 = new Conta();

        conta1.setBanco("001 - BANCO GERAL");
        conta1.setNumero("16987-8");
        conta1.setAgencia("6543");

        conta2.setBanco("237 - BANCO FRATESCO");
        conta2.setNumero("86759-1");
        conta2.setAgencia("1745");

        conta3.setBanco("341 - BANCO ITEU MULTBANCO");
        conta3.setNumero("46346-3");
        conta3.setAgencia("4606");

        conta4.setBanco("033 - BANCO SCALIONER");
        conta4.setNumero("12345-6");
        conta4.setAgencia("9876");

        conta5.setBanco("104 - CAIXA ECONOMICA FEDERAL");
        conta5.setNumero("98654-3");
        conta5.setAgencia("1234");

        // persistindo as contas
        manager.persist(conta1);
        manager.persist(conta2);
        manager.persist(conta3);
        manager.persist(conta4);
        manager.persist(conta5);

        manager.getTransaction().commit();
        manager.close();
    }
}
