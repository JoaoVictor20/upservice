package com.projetointegrador.upservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetointegrador.upservice.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

	@Query("SELECT s FROM Servico s WHERE s.usuario.id = ?1")
	List<Servico> buscarServicosDoUsuario(Long usuario_id);
}