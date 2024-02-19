package com.mei.vendasapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mei.vendasapi.domain.Categoria;
import com.mei.vendasapi.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService  categoriaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> lista() {
	
	List<Categoria> lista =  categoriaService.lista();
		
	return ResponseEntity.ok(lista);	
	}
	
	
	
}
