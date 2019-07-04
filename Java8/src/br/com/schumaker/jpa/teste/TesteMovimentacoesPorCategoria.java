package br.com.schumaker.jpa.teste;

import br.com.schumaker.jpa.modelo.Categoria;
import br.com.schumaker.jpa.modelo.Movimentacao;
import br.com.schumaker.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Hudson Schumaker
 */
public class TesteMovimentacoesPorCategoria {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        Query query = manager
                .createQuery("select m from Movimentacao m join m.categoria c where c = :pCategoria");

        query.setParameter("pCategoria", categoria);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }

    }
}
