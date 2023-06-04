package com.projetointegrador.upservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetointegrador.upservice.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.email = ?1 AND u.senha = ?2")
	Usuario logarUsuario(String email, String senha);
}