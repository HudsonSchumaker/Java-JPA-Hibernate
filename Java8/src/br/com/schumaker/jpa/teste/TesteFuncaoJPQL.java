package br.com.schumaker.jpa.teste;

import br.com.schumaker.jpa.modelo.Conta;
import br.com.schumaker.jpa.modelo.TipoMovimentacao;
import br.com.schumaker.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Hudson Schumaker
 */
public class TesteFuncaoJPQL {
    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(3);

        TypedQuery<Double> query = manager.createNamedQuery("MediasPorDiaETipo", Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> medias = query.getResultList();

        for (Double media : medias) {
            System.out.println("A média é: " + media);
        }

    }

}

