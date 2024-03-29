package br.com.schumaker.jpa.modelo;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @OneToOne(mappedBy = "cliente")
    @JoinColumn(unique = true)
    private Conta conta;
    private String endereco;
    private String profissao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
