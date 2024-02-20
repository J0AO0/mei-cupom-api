package com.mei.vendasapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mei.vendasapi.domain.Cliente;
import com.mei.vendasapi.domain.Pedido;
import com.mei.vendasapi.domain.dto.PedidoDTO;
import com.mei.vendasapi.domain.dto.PedidoNewDTO;
import com.mei.vendasapi.repository.PedidoRepository;
import com.mei.vendasapi.service.exception.EntidadeNaoEncontradaExcepition;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Page<Pedido> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Pedido findPorId(Integer id) {
        Pedido cat = repo.findPorId(id);
        return cat;
    }
    
    @Transactional
    public Pedido insert(PedidoNewDTO obj){
    	obj.setId(null);
        Pedido resEst = new Pedido();
        Cliente c = obj.getCliente();
        resEst.setCliente(c);
        return repo.save(resEst);
    }

    public Pedido atualiza(PedidoDTO obj) {
        Pedido resEst =  repo.findPorId(obj.getId());
        resEst.setCliente(obj.getCliente());
        return repo.save(resEst);
    }

    public void delete (Integer id) {
        repo.deleteById(id);
    }

    public List<Pedido> lista() {

        List<Pedido> buscarTodas = repo.findAllCat();
        return buscarTodas;
    }

    public Pedido buscarOuFalhar(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Pedido  não encontrado", id)));
    }
}
