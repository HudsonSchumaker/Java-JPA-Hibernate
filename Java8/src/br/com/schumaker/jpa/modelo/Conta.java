package br.com.schumaker.jpa.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * @author Hudson Schumaker
 */

@Entity
@NamedQuery(query="select distinct avg(m.valor) from Movimentacao m where m.conta=:pConta "
        + "and m.tipoMovimentacao=:pTipo" +
        " group by m.data", name="MediasPorDiaETipo")
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titular;
    private String banco;
    private String agencia;
    private String numero;

    @OneToOne
    @JoinColumn(unique=true)
    private Cliente cliente;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
