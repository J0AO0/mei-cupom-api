package com.mei.vendasapi.resource;

import com.mei.vendasapi.domain.Pedido;
import com.mei.vendasapi.domain.dto.PedidoDTO;
import com.mei.vendasapi.domain.dto.PedidoNewDTO;
import com.mei.vendasapi.service.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> lista() {

        List<Pedido> lista =  pedidoService.lista();

        return ResponseEntity.ok(lista);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Pedido obj = pedidoService.findPorId(id);
        return ResponseEntity.ok(obj);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoNewDTO objNewDTO) {
        Pedido novoObj = modelMapper.map(objNewDTO, Pedido.class);
        Pedido objNovo = pedidoService.insert(objNewDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(objNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(novoObj);
    }


    @RequestMapping(value = "/{id} " , method = RequestMethod.PUT)
//	TODO
//	ERRO NO MÉTODO PUT, ATUALIZAR DE ACORDO COM O DTO
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Integer id,@RequestBody PedidoDTO objDTO) {
        objDTO.setId(null);
        Pedido objNovo = new Pedido(objDTO);
        Pedido atividadeAtualizado =  pedidoService.atualiza(objNovo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();

        return ResponseEntity.created(uri).body(atividadeAtualizado);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
