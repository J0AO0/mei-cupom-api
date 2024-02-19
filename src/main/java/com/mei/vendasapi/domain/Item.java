package com.mei.vendasapi.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
    public ProdutoPedidoPK id = new ProdutoPedidoPK();
    private Integer quantidade;
    private Boolean status;
    
    @ManyToOne 
    private Tenant tenant;
    
    public Item() {
        super();
    }
    public Item(ProdutoPedidoPK id, Integer quantidade, Boolean status) {
        super();
        this.id = id;
        this.quantidade = quantidade;
        this.status = status;
    }
    public ProdutoPedidoPK getId() {
        return id;
    }
    public void setId(ProdutoPedidoPK id) {
        this.id = id;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
    
    
}
