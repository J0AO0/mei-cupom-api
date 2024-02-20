package com.mei.vendasapi.domain.dto;

import com.mei.vendasapi.domain.Cliente;

import javax.persistence.ManyToOne;

public class PedidoDTO {
    private Integer id;
    private Cliente cliente;

    public Integer getId() {
        return id;
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

    public PedidoDTO(Integer id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public PedidoDTO() {
    }
}
