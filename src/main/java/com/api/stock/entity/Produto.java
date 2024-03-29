package com.api.stock.entity;

import com.api.stock.model.ProdutoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "ESTOQUE")
    private Integer estoque;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "TOTAL_ACESSOS")
    private Integer totalAcessos;

    @Column(name = "IMAGEM")
    private String imagem;

    @Column(name = "PRECO")
    private Integer preco;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;

    @OneToMany(mappedBy = "idProduto")
    private Set<Avaliacao> avaliacoes;

    @Transient
    private Boolean isFavorito;

    @Transient
    private Integer favoritoId;

    public Produto(ProdutoDTO produtoDto){
        this.id = produtoDto.getId();
        this.nome = produtoDto.getNome();
        this.descricao = produtoDto.getDescricao();
        this.estoque = produtoDto.getEstoque();
        this.totalAcessos = produtoDto.getTotalAcessos();
        this.imagem = produtoDto.getImagem();
        this.preco = produtoDto.getPreco();
        Departamento depart = new Departamento();
        depart.setId(produtoDto.getDepartamentoId());
        this.departamento = depart;
    }


}
