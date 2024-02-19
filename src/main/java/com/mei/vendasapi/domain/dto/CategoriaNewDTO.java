package com.mei.vendasapi.domain.dto;

public class CategoriaNewDTO {
    private Integer id;
    private String nome;

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

    public CategoriaNewDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaNewDTO() {
    }
}
