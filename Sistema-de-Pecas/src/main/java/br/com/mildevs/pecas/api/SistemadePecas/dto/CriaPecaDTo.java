package br.com.mildevs.pecas.api.SistemadePecas.dto;

import br.com.mildevs.pecas.api.SistemadePecas.entity.Peca;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

public class CriaPecaDTo {

    @Id
    private Long codBarras;

    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;*/

    @NotBlank
    private String nome;

    @NotBlank
    private String modelo;

    @NotBlank
    private String fabricante;


    @NotNull(message = "Preço de custo não pode ser nulo")
    private Double precoDeCusto;

    @NotNull(message = "Preço de venda não pode ser nulo")
    private Double precoDeVenda;


    private int qtdeEstoque;


    @NotBlank
    private String categoria;


    public CriaPecaDTo(Long codBarras, String nome, String modelo,
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

    public Peca toEntity(){
        Peca peca = new Peca();
        BeanUtils.copyProperties(this, peca);
        return peca;
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
}
