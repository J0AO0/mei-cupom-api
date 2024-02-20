package com.mei.vendasapi.domain.dto;

import com.mei.vendasapi.domain.Categoria;

public class ProdutoNewDTO {
	private Integer id;
	private String name;
	private Categoria categoria;
	private Integer preco;
	private String descricao;
	private Boolean status = Boolean.TRUE;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ProdutoNewDTO(Integer id, String name, Categoria categoria, Integer preco, String descricao,
			Boolean status) {
		this.id = id;
		this.name = name;
		this.categoria = categoria;
		this.preco = preco;
		this.descricao = descricao;
		this.status = status;
	}

	public ProdutoNewDTO() {
	}
}
