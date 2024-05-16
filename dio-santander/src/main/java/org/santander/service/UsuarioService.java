package org.santander.service;

import org.santander.domain.model.Usuario;

public interface UsuarioService {
	
	Usuario findById(Long id);
	Usuario create(Usuario usuario);
}
