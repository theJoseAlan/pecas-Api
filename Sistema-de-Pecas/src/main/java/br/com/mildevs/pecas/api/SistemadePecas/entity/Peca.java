package br.com.mildevs.pecas.api.SistemadePecas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;

//Essa é a entidade com os atributos do objeto

@Entity
public class Peca {


    @Column
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false, unique = true)
    private Long codBarras;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String fabricante;

    @Column(name = "preco_de_custo", nullable = false)
    private Double precoDeCusto;

    @Column(name = "preco_de_venda", nullable = false)
    private Double precoDeVenda;

    @Column(name = "qtde_estoque", nullable = false)
    private int qtdeEstoque;


    @Column(nullable = false)
    private String categoria;

    public Peca(){

    }

    public Peca(int id, Long codBarras, String nome, String modelo,
                String fabricante, Double precoDeCusto,
                Double precoDeVenda, int qtdeEstoque,
                String categoria) {

        this.codBarras = codBarras;
        this.nome = nome;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.precoDeCusto = precoDeCusto;
        this.precoDeVenda = precoDeVenda;
        this.qtdeEstoque = qtdeEstoque;
        this.categoria = categoria;
    }

    public Long getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(Long codBarras) {
        this.codBarras = codBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Double getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(Double precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public Double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(Double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
