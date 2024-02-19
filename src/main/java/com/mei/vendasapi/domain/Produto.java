package com.mei.vendasapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Produto implements Serializable {

    public static final Long seralVersionUID = 123456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    private String name;
    
    @ManyToOne
    private Categoria categoria;
    
    private Integer preço;
    
    private String descricao;
    
    private String status;
    
    //TODO
    //private Tenant tenant;

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

	public Integer getPreço() {
		return preço;
	}

	public void setPreço(Integer preço) {
		this.preço = preço;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Produto(Integer id, String name, Categoria categoria, Integer preço, String descricao, String status) {
		super();
		this.id = id;
		this.name = name;
		this.categoria = categoria;
		this.preço = preço;
		this.descricao = descricao;
		this.status = status;
	}

	public Produto() {
		super();
	}
    

}
