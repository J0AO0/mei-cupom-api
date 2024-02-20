package com.mei.vendasapi.resource;

import com.mei.vendasapi.domain.Empresa;
import com.mei.vendasapi.domain.dto.EmpresaDTO;
import com.mei.vendasapi.domain.dto.EmpresaNewDTO;
import com.mei.vendasapi.service.EmpresaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaResource {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> lista() {

        List<Empresa> lista =  empresaService.lista();

        return ResponseEntity.ok(lista);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Empresa obj = empresaService.findPorId(id);
        return ResponseEntity.ok(obj);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Empresa> criarEmpresa(@RequestBody EmpresaNewDTO objNewDTO) {
        Empresa novoObj = modelMapper.map(objNewDTO, Empresa.class);
        Empresa objNovo = empresaService.insert(objNewDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(objNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(novoObj);
    }


    @RequestMapping(value = "/{id} " , method = RequestMethod.PUT)
//	TODO
//	ERRO NO MÉTODO PUT, ATUALIZAR DE ACORDO COM O DTO
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Integer id,@RequestBody EmpresaDTO objDTO) {
        objDTO.setId(null);
        Empresa objNovo = new Empresa(objDTO);
        Empresa atividadeAtualizado =  empresaService.atualiza(objNovo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();

        return ResponseEntity.created(uri).body(atividadeAtualizado);
    }

    @RequestMapping(value="/{id}/status",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
        empresaService.status(obj,id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
