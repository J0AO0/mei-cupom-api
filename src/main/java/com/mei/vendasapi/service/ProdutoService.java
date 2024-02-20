package com.mei.vendasapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mei.vendasapi.domain.Categoria;
import com.mei.vendasapi.domain.Produto;
import com.mei.vendasapi.domain.dto.ProdutoDTO;
import com.mei.vendasapi.domain.dto.ProdutoNewDTO;
import com.mei.vendasapi.repository.ProdutoRepository;
import com.mei.vendasapi.service.exception.EntidadeNaoEncontradaExcepition;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repo;

    public Page<Produto> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Produto findPorId(Integer id) {
        Produto cat = repo.findPorId(id);
        return cat;
    }
    
    @Transactional
    public Produto insert(ProdutoNewDTO obj){
    	obj.setId(null);
        Produto resEst = new Produto();
        resEst.setName(obj.getName());
        resEst.setDescricao(obj.getDescricao());
        resEst.setPreco(obj.getPreco());
        Categoria c = obj.getCategoria();
        resEst.setCategoria(c);
        resEst.setStatus(obj.getStatus());
        return repo.save(resEst);
    }

    public Produto atualiza(ProdutoDTO obj) {
        Produto resEst =  repo.findPorId(obj.getId());
        resEst.setCategoria(obj.getCategoria());
        resEst.setDescricao(obj.getDescricao());
        resEst.setName(obj.getName());
        resEst.setPreco(obj.getPreco());
        resEst.setQrCode(obj.getQrCode());
        return repo.save(resEst);
    }

    public void delete (Integer id) {
        repo.deleteById(id);
    }

    public List<Produto> lista() {

        List<Produto> buscarTodas = repo.findAllCat();
        return buscarTodas;
    }

    public Produto buscarOuFalhar(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Produto  não encontrada", id)));
    }

    @Transactional
    public void status(Boolean obj, int id) {
        Produto produto = buscarOuFalhar(id);
        produto.setStatus(obj);

    }
}
