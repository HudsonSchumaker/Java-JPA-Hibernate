package br.com.schumaker.jpa.modelo.dao;

import br.com.schumaker.jpa.modelo.Conta;
import br.com.schumaker.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

 /**
 * @author Hudson Schumaker 
 */
public class MovimentacaoDao {

    private final EntityManager em;

    public MovimentacaoDao(EntityManager manager) {
        this.em = manager;
    }

    public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {

        String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo"
                + " group by m.data";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipoMovimentacao);

        return query.getResultList();
    }
}
