package com.mei.vendasapi.domain.dto;

import com.mei.vendasapi.domain.Produto;

public class EstoqueNewDTO {
	private Integer id;
	private String nome;
	private Double quantidadeEstoque;
	private Produto produto;
	private Boolean status;

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Double quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public EstoqueNewDTO(Integer id, String nome, Double quantidadeEstoque, Produto produto, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.quantidadeEstoque = quantidadeEstoque;
		this.produto = produto;
		this.status = status;
	}

	public EstoqueNewDTO() {
	}
}
