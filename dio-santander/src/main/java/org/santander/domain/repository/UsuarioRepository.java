package org.santander.domain.repository;

import org.santander.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//boolean existeNumeroConta(String numeroConta);

}
