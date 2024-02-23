package com.mei.vendasapi.service;

import com.mei.vendasapi.domain.Estoque;
import com.mei.vendasapi.domain.Estoque;
import com.mei.vendasapi.domain.dto.EstoqueDTO;
import com.mei.vendasapi.domain.dto.EstoqueNewDTO;
import com.mei.vendasapi.repository.EstoqueRepository;
import com.mei.vendasapi.repository.EstoqueRepository;
import com.mei.vendasapi.service.exception.EntidadeNaoEncontradaExcepition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository repo;

    public Page<Estoque> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Estoque findPorId(Integer id) {
        Estoque cat = repo.findPorId(id);
        return cat;
    }

    @Transactional
    public Estoque insert(EstoqueNewDTO obj){
        obj.setId(null);
        Estoque resEst = new Estoque();
        resEst.setNome(obj.getNome());
        return repo.save(resEst);
    }

    public Estoque atualiza(EstoqueDTO obj) {
        Estoque resEst =  repo.findPorId(obj.getId());
        BeanUtils.copyProperties(obj, resEst, "id");
        return repo.save(resEst);
    }

    public void delete (Integer id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaExcepition(String.format("Estoque Nao Encontrado", id));
        }
    }

    public List<Estoque> lista() {

        List<Estoque> buscarTodas = repo.findAll();
        return buscarTodas;
    }

    public Estoque buscarOuFalhar(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Estoque não encontrado", id)));
    }

    @Transactional
    public void status(Boolean obj, int id) {
        Estoque cliente = buscarOuFalhar(id);
        cliente.setStatus(obj);

    }
}
