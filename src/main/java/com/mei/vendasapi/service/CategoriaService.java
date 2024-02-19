package com.mei.vendasapi.service;

import com.mei.vendasapi.domain.Categoria;
import com.mei.vendasapi.domain.dto.CategoriaDTO;
import com.mei.vendasapi.domain.dto.CategoriaNewDTO;
import com.mei.vendasapi.repository.CategoriaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

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
         Categoria resEst = new Categoria(obj);
         return repo.save(resEst);
    }

    public Categoria atualiza(CategoriaDTO obj) {
        Categoria resEst =  repo.findPorId(obj.getId());
        resEst.setNome(obj.getNome());
        return repo.save(resEst);
    }

    public void delete (Integer id) {
        repo.deleteById(id);
    }

	public List<Categoria> lista() {
		
		List<Categoria> buscarTodas = repo.findAllCat();		
		return buscarTodas;
	}

}
