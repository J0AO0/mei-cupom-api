package com.mei.vendasapi.domain;

import com.mei.vendasapi.domain.dto.CategoriaDTO;
import com.mei.vendasapi.domain.dto.CategoriaNewDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Categoria  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    private String nome;
    
    @ManyToOne
    private Tenant tenant;

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

    public Categoria(Integer id, String nome, Tenant tenant) {
        this.id = id;
        this.nome = nome;
        this.tenant = tenant;
    }

    public Categoria() {
    }

    public Categoria(CategoriaDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Categoria(CategoriaNewDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
    }
}
