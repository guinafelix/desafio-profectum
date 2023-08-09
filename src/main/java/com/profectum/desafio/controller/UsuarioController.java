package com.profectum.desafio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.dto.Usuarios.CriarUsuarioDto;
import com.profectum.desafio.models.Usuario;
import com.profectum.desafio.services.usuarios.ListarUsuarios; 
import com.profectum.desafio.services.usuarios.CriarUsuario; 


@RestController
@RequestMapping(value="/api")
public class UsuarioController {
	
	@Autowired
	ListarUsuarios listarUsuariosService;
	
	@Autowired 
	CriarUsuario criarUsuarioService;
	
	
	@GetMapping("/usuarios")
	public List<Usuario> findAll() {
		return listarUsuariosService.execute();
	}
	
	@PostMapping("/usuario")
	public void add(@RequestBody CriarUsuarioDto dto) {
		criarUsuarioService.execute(dto);
	}
	
}