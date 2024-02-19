package com.mei.vendasapi.service;

import com.mei.vendasapi.domain.Categoria;
import com.mei.vendasapi.domain.Cliente;
import com.mei.vendasapi.domain.dto.CategoriaDTO;
import com.mei.vendasapi.domain.dto.CategoriaNewDTO;
import com.mei.vendasapi.domain.dto.ClienteDTO;
import com.mei.vendasapi.domain.dto.ClienteNewDTO;
import com.mei.vendasapi.repository.CategoriaRepository;
import com.mei.vendasapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Page<Cliente> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Cliente findPorId(Integer id) {
        Cliente cat = repo.findPorId(id);
        return cat;
    }

    public Cliente insert(ClienteNewDTO obj){
        Cliente resEst = new Cliente(obj);
        return repo.save(resEst);
    }

    public Cliente atualiza(ClienteDTO obj) {
        Cliente resEst =  repo.findPorId(obj.getId());
        resEst.setNome(obj.getNome());
        resEst.setEmail(obj.getEmail());
        resEst.setTelefone(obj.getTelefone());
        resEst.setStatus(obj.getStatus());
        return repo.save(resEst);
    }

    public void delete (Integer id) {
        repo.deleteById(id);
    }

    public List<Cliente> lista() {

        List<Cliente> buscarTodas = repo.findAllCat();
        return buscarTodas;
    }

}
