package com.mei.vendasapi.domain;

import com.mei.vendasapi.domain.dto.EstoqueDTO;
import com.mei.vendasapi.domain.dto.EstoqueNewDTO;
import com.mei.vendasapi.domain.dto.ProdutoDTO;
import com.mei.vendasapi.domain.dto.ProdutoNewDTO;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Entity
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
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

    public Estoque(Integer id, String nome, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }
    public Estoque() {
    }

    public Estoque(@Valid EstoqueDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.status = obj.getStatus();
    }

    public Estoque(@Valid EstoqueNewDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.status = obj.getStatus();
    }

}


