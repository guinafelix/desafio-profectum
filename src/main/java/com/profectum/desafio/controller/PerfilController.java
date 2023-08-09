package com.profectum.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.dto.Perfil.CriarPerfilDto;
import com.profectum.desafio.models.Perfil;
import com.profectum.desafio.services.perfis.CriarPerfil;
import com.profectum.desafio.services.perfis.ListarPerfilPorId;

@RestController
@RequestMapping(value="/api")
public class PerfilController {
	@Autowired
	CriarPerfil criarPerfilService;
	
	@Autowired 
	ListarPerfilPorId listarPerfilPorIdService;
	
	@Autowired
	ListarPerfis listarPerfisService;
	
	@GetMapping("/perfis")
	@public List<Perfil> findAll(){
		return listarPerfisService.execute();
	}
	
	@PostMapping("/perfil")
	public Perfil add(@RequestBody CriarPerfilDto dto) {
		return criarPerfilService.execute(dto);
	}
	
	@GetMapping("/perfil/{id}")
	public Perfil findById(@PathVariable(value = "id")	long id) {
		return listarPerfilPorIdService.execute(id);
	}
}
