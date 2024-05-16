package org.santander.controller;

import java.net.URI;

import org.santander.domain.model.Usuario;
import org.santander.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		var user = usuarioService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		var user = usuarioService.create(usuario);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).body(usuario);
	}
}
