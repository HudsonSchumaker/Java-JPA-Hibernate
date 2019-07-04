package br.com.schumaker.jpa.teste;

import br.com.schumaker.jpa.modelo.Conta;
import br.com.schumaker.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Hudson Schumaker
 */
public class TesteMovimentacaoConta {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();
        Query query = manager.createQuery("select distinct c from Conta c left join fetch c.movimentacoes");

        List<Conta> contas = query.getResultList();

        for (Conta conta : contas) {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
        }
    }

}
