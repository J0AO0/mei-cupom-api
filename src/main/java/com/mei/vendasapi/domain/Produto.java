package com.mei.vendasapi.domain;

import com.mei.vendasapi.domain.dto.PedidoDTO;
import com.mei.vendasapi.domain.dto.PedidoNewDTO;
import com.mei.vendasapi.domain.dto.ProdutoDTO;
import com.mei.vendasapi.domain.dto.ProdutoNewDTO;

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
    
    private Integer preco;
    
    private String descricao;
    
    private String status;
    
    @ManyToOne
    private Tenant tenant;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Produto(Integer id, String name, Categoria categoria, Integer preco, String descricao, String status, Tenant tenant) {
		super();
		this.id = id;
		this.name = name;
		this.categoria = categoria;
		this.preco = preco;
		this.descricao = descricao;
		this.status = status;
		this.tenant = tenant;
	}

	public Produto() {
		super();
	}

	public Produto(ProdutoDTO obj){
		this.id = obj.getId();
		this.name = obj.getName();
		this.categoria = obj.getCategoria();
		this.preco = obj.getPreco();
		this.descricao = obj.getDescricao();
		this.status = obj.getStatus();
	}

	public Produto(ProdutoNewDTO obj){
		this.id = obj.getId();
		this.name = obj.getName();
		this.categoria = obj.getCategoria();
		this.preco = obj.getPreco();
		this.descricao = obj.getDescricao();
		this.status = obj.getStatus();
	}
    

}
