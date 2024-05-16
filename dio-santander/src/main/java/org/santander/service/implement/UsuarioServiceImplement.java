package org.santander.service.implement;

import java.util.NoSuchElementException;

import org.santander.domain.model.Usuario;
import org.santander.domain.repository.UsuarioRepository;
import org.santander.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImplement implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;

	public UsuarioServiceImplement(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Usuario create(Usuario usuario) {
		
		if (usuario.getId() != null && usuarioRepository.existsById(usuario.getId())) {
			throw new IllegalArgumentException("Ja existe um usuario com esse ID.");
		}
		/*
		if (usuarioRepository.existeNumeroConta(usuario.getConta().getNumero())) {
			throw new IllegalArgumentException("Ja existe um numero de conta.");
		}
		*/
		return usuarioRepository.save(usuario);
	}

}
