package com.mei.vendasapi.domain;

import com.mei.vendasapi.domain.dto.ItemDTO;
import com.mei.vendasapi.domain.dto.ItemNewDTO;
import com.mei.vendasapi.domain.dto.PedidoDTO;
import com.mei.vendasapi.domain.dto.PedidoNewDTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Tenant tenant;
    
    public Integer getId() {
        return id;
    }
    public Pedido() {
        super();
    }
    public Pedido(Integer id, Cliente cliente, Tenant tenant) {
        super();
        this.id = id;
        this.cliente = cliente;
        this.tenant = tenant;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

    public Pedido(PedidoDTO obj){
        this.id = obj.getId();
        this.cliente = obj.getCliente();
    }

    public Pedido(PedidoNewDTO obj){
        this.id = obj.getId();
        this.cliente = obj.getCliente();
    }
    
}
