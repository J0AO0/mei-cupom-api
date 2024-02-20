package com.mei.vendasapi.resource;

import com.mei.vendasapi.domain.Produto;
import com.mei.vendasapi.domain.dto.ProdutoDTO;
import com.mei.vendasapi.domain.dto.ProdutoNewDTO;
import com.mei.vendasapi.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> lista() {

        List<Produto> lista =  produtoService.lista();

        return ResponseEntity.ok(lista);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Produto obj = produtoService.findPorId(id);
        return ResponseEntity.ok(obj);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Produto> criarProduto(@RequestBody ProdutoNewDTO objNewDTO) {
        Produto novoObj = modelMapper.map(objNewDTO, Produto.class);
        Produto objNovo = produtoService.insert(objNewDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(objNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(novoObj);
    }


    @RequestMapping(value = "/{id} " , method = RequestMethod.PUT)
//	TODO
//	ERRO NO MÉTODO PUT, ATUALIZAR DE ACORDO COM O DTO
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id,@RequestBody ProdutoDTO objDTO) {
        objDTO.setId(null);
        Produto objNovo = new Produto(objDTO);
        Produto atividadeAtualizado =  produtoService.atualiza(objNovo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();

        return ResponseEntity.created(uri).body(atividadeAtualizado);
    }

    @RequestMapping(value="/{id}/status",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
        produtoService.status(obj,id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
