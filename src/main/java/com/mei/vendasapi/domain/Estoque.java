package com.mei.vendasapi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import com.mei.vendasapi.domain.dto.EstoqueDTO;
import com.mei.vendasapi.domain.dto.EstoqueNewDTO;

@Entity
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double quantidadeEstoque = new Double(0);

	@ManyToOne
	private Produto produto;

	private Boolean status = Boolean.TRUE;

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

	public Estoque(Integer id, String nome, Double quantidadeEstoque, Produto produto, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.quantidadeEstoque = quantidadeEstoque;
		this.produto = produto;
		this.status = status;
	}

	public Estoque() {
	}

	public Estoque(@Valid EstoqueDTO obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.status = obj.getStatus();
		this.quantidadeEstoque = obj.getQuantidadeEstoque();
		this.produto = obj.getProduto();
	}

	public Estoque(@Valid EstoqueNewDTO obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.status = obj.getStatus();
		this.quantidadeEstoque = obj.getQuantidadeEstoque();
		this.produto = obj.getProduto();
	}

}
