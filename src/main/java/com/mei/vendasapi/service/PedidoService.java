package com.mei.vendasapi.service;

import com.mei.vendasapi.domain.Item;
import com.mei.vendasapi.domain.Pedido;
import com.mei.vendasapi.domain.dto.ItemNewDTO;
import com.mei.vendasapi.domain.dto.PedidoDTO;
import com.mei.vendasapi.domain.dto.PedidoNewDTO;
import com.mei.vendasapi.repository.ItemRepository;
import com.mei.vendasapi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Pedido insert(PedidoNewDTO obj){
        Pedido resEst = new Pedido(obj);
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
}
