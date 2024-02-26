package com.mei.vendasapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.mei.vendasapi.domain.dto.flat.ProdutoFlat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mei.vendasapi.domain.Categoria;
import com.mei.vendasapi.domain.Cliente;
import com.mei.vendasapi.domain.Pedido;
import com.mei.vendasapi.domain.Produto;
import com.mei.vendasapi.domain.dto.ProdutoDTO;
import com.mei.vendasapi.domain.dto.ProdutoNewDTO;
import com.mei.vendasapi.repository.ProdutoRepository;
import com.mei.vendasapi.service.exception.EntidadeEmUsoException;
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
        try {
        	Produto resEst =  repo.findPorId(obj.getId());
    			
            BeanUtils.copyProperties(obj, resEst, "id");
            return repo.save(resEst);
    		} catch (DataIntegrityViolationException e) {
    			throw new EntidadeNaoEncontradaExcepition(String.format("Categoria não encontrado", obj.getId()));
    		}
        }

    public void delete (Integer id) {
    	try {
			if(!repo.existsById(id)) {
				throw new EntidadeNaoEncontradaExcepition(String.format("Produto não encontrado", id));
			}
			repo.deleteById(id);
    		
		} catch (DataIntegrityViolationException e) {
		throw new EntidadeEmUsoException(String.format("Produto não pode ser deletado", id));
		}
    }

    public List<Produto> lista() {

        List<Produto> buscarTodas = repo.findAllCat();
        return buscarTodas;
    }

    public Produto buscarOuFalhar(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Produto  não encontrado", id)));
    }

    @Transactional
    public void status(Boolean obj, int id) {
        Produto produto = buscarOuFalhar(id);
        produto.setStatus(obj);

    }

    public Page<ProdutoFlat> mudarProdutoParaFlat(Page<Produto> pacs) {
        List<ProdutoFlat> cFlats = new ArrayList<ProdutoFlat>();
        for (Produto p : pacs.getContent()) {
            ProdutoFlat cFlat = new ProdutoFlat(p);
            cFlats.add(cFlat);

        }
        Page<ProdutoFlat> page = new PageImpl<>(cFlats, pacs.getPageable(),
                pacs.getTotalElements());

        return page;
    }
}
