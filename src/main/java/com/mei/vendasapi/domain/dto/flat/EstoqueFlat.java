package com.mei.vendasapi.domain.dto.flat;

import com.mei.vendasapi.domain.Estoque;

import java.time.OffsetDateTime;

public class EstoqueFlat {
    private Integer id;
    private String nome;
    private Boolean status;
    private OffsetDateTime datagravacao;
    private String emailusuario;

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

    public OffsetDateTime getDatagravacao() {
        return datagravacao;
    }

    public void setDatagravacao(OffsetDateTime datagravacao) {
        this.datagravacao = datagravacao;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public EstoqueFlat(Integer id, String nome, Boolean status, OffsetDateTime datagravacao, String emailusuario) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.datagravacao = datagravacao;
        this.emailusuario = emailusuario;
    }

    public EstoqueFlat(Estoque est, String ok){
        this.id = est.getId();
        this.nome = est.getNome();
        this.status = est.getStatus();
        this.datagravacao = est.getLogs().getDatagravacao();
        this.emailusuario = est.getLogs().getEmailUsuario();
    }

    public EstoqueFlat(Estoque est){
        this.id = est.getId();
        this.nome = est.getNome();
        this.status = est.getStatus();
        this.datagravacao = est.getLogs().getDatagravacao();
        this.emailusuario = est.getLogs().getEmailUsuario();
    }
}
