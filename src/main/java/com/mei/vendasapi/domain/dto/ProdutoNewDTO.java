package com.mei.vendasapi.domain.dto;

import com.mei.vendasapi.domain.Categoria;

import java.math.BigDecimal;

public class ProdutoNewDTO {
<<<<<<< HEAD
	private Integer id;
	private String name;
	private Categoria categoria;
	private Integer preco;
	private String descricao;
	private Boolean status = Boolean.TRUE;
=======
    private Integer id;
    private String name;
    private Categoria categoria;
    private BigDecimal preco;
    private String descricao;
    private Boolean status;
    private String qrCode;
>>>>>>> 5e00e9e533fcd69dcf3a70420558d3632bfc4f19

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

<<<<<<< HEAD
	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}
=======
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
>>>>>>> 5e00e9e533fcd69dcf3a70420558d3632bfc4f19

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

<<<<<<< HEAD
	public ProdutoNewDTO(Integer id, String name, Categoria categoria, Integer preco, String descricao,
			Boolean status) {
		this.id = id;
		this.name = name;
		this.categoria = categoria;
		this.preco = preco;
		this.descricao = descricao;
		this.status = status;
	}
=======
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public ProdutoNewDTO(Integer id, String name, Categoria categoria, BigDecimal preco, String descricao, Boolean status, String qrCode) {
        this.id = id;
        this.name = name;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.status = status;
        this.qrCode = qrCode;
    }
>>>>>>> 5e00e9e533fcd69dcf3a70420558d3632bfc4f19

	public ProdutoNewDTO() {
	}
}
