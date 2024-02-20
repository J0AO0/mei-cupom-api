package com.mei.vendasapi.resource;

import com.mei.vendasapi.domain.Cliente;
import com.mei.vendasapi.domain.dto.ClienteDTO;
import com.mei.vendasapi.domain.dto.ClienteNewDTO;
import com.mei.vendasapi.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> lista() {

        List<Cliente> lista =  clienteService.lista();

        return ResponseEntity.ok(lista);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Cliente obj = clienteService.findPorId(id);
        return ResponseEntity.ok(obj);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteNewDTO objNewDTO) {
        Cliente novoObj = modelMapper.map(objNewDTO, Cliente.class);
        Cliente objNovo = clienteService.insert(objNewDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(objNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(novoObj);
    }


    @RequestMapping(value = "/{id} " , method = RequestMethod.PUT)
//	TODO
//	ERRO NO MÉTODO PUT, ATUALIZAR DE ACORDO COM O DTO
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Integer id,@RequestBody ClienteDTO objDTO) {
        objDTO.setId(null);
        Cliente objNovo = new Cliente(objDTO);
        Cliente atividadeAtualizado =  clienteService.atualiza(objNovo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();

        return ResponseEntity.created(uri).body(atividadeAtualizado);
    }

    @RequestMapping(value="/{id}/status",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
        clienteService.status(obj,id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
