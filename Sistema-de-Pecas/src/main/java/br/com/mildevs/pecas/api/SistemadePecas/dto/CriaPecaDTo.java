package br.com.mildevs.pecas.api.SistemadePecas.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CriaPecaDTo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String fabricante;

    @NotNull(message = "Preco de custo não pode ser nulo")
    @Column(name = "preco_de_custo", nullable = false)
    private Double precoDeCusto;

    @NotNull(message = "Preco de venda não pode ser nulo")
    @Column(name = "preco_de_venda", nullable = false)
    private Double precoDeVenda;

    @Column(name = "qtde_estoque", nullable = false)
    private int qtdeEstoque;


    @Column(nullable = false)
    private String categoria;
}
