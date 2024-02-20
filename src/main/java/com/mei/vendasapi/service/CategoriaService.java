package com.mei.vendasapi.service;

import java.util.List;

import javax.transaction.Transactional;

import com.mei.vendasapi.domain.dto.CategoriaDTO;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mei.vendasapi.domain.Categoria;
import com.mei.vendasapi.domain.dto.CategoriaNewDTO;
import com.mei.vendasapi.repository.CategoriaRepository;
import com.mei.vendasapi.service.exception.EntidadeNaoEncontradaExcepition;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Page<Categoria> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Categoria findPorId(Integer id) {
        Categoria cat = repo.findPorId(id);
        return cat;
    }

    public Categoria insert(CategoriaNewDTO obj){
//        TODO
//        ID NÃO ESTA COM AUTO IMPLEMENT NA HORA DE FAZER O POST
         Categoria resEst = new Categoria(obj);
         return repo.save(resEst);
    }

    public Categoria atualiza(CategoriaDTO obj) {
        Categoria resEst =  repo.findPorId(obj.getId());
        resEst.setNome(obj.getNome());
        resEst.setStatus(obj.getStatus());
        return repo.save(resEst);
    }

    public void delete (Integer id) {
        repo.deleteById(id);
    }

	public List<Categoria> lista() {
		
		List<Categoria> buscarTodas = repo.findAllCat();		
		return buscarTodas;
	}
	
	public Categoria buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Categoria  não encontrada", id)));
	}
	
	@Transactional
	public void status(Boolean obj, int id) {
	Categoria categoria = buscarOuFalhar(id);
	categoria.setStatus(obj);
		
	}
}
