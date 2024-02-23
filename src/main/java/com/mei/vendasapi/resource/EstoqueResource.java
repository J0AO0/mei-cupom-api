package com.mei.vendasapi.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mei.vendasapi.domain.Estoque;
import com.mei.vendasapi.domain.dto.EstoqueDTO;
import com.mei.vendasapi.domain.dto.EstoqueNewDTO;
import com.mei.vendasapi.service.EstoqueService;

@RestController
@RequestMapping("/estoques")
public class EstoqueResource {
    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> lista() {

        List<Estoque> lista =  estoqueService.lista();

        return ResponseEntity.ok(lista);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Estoque obj = estoqueService.buscarOuFalhar(id);
        return ResponseEntity.ok(obj);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Estoque> criarEstoque(@Valid @RequestBody EstoqueNewDTO objNewDTO) {
        Estoque novoObj = modelMapper.map(objNewDTO, Estoque.class);
        Estoque objNovo = estoqueService.insert(objNewDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(objNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(novoObj);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Estoque> update(@Valid @RequestBody EstoqueDTO obj, @PathVariable Integer id) {
        obj.setId(id);
        
        Estoque novoobj = new Estoque(obj);
        Estoque obj1 = estoqueService.atualiza(novoobj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj1.getId()).toUri();
        return ResponseEntity.created(uri).body(obj1);

    }

    @RequestMapping(value ="/{id}/status",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
        estoqueService.status(obj,id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        estoqueService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
