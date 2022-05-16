package com.vampiro.springboot.backen.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.vampiro.springboot.backen.apirest.models.entity.Compra;
import com.vampiro.springboot.backen.apirest.models.services.ICompraService;

@CrossOrigin(origins = {"http://localhost:4200","*"})
@RestController
@RequestMapping("/api")
public class CompraRestController {
	
	@Autowired
	private ICompraService compraService;
	
	@GetMapping("/compras")
	public List<Compra> index(){
		return compraService.findAll();
	}
	
	@GetMapping("/compras/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Compra show(@PathVariable Long id) {
		return compraService.findCompraById(id);
	}
	
	@DeleteMapping("/compras/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		compraService.deleteCompraById(id);
	}	
	
	@PostMapping("/compras")
	@ResponseStatus(HttpStatus.CREATED)
	public Compra crear(@RequestBody Compra compra) {
		return compraService.saveCompra(compra);
	}
	
	
}
