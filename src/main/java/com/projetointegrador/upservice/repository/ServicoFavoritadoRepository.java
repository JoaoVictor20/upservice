package com.projetointegrador.upservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetointegrador.upservice.model.ServicoFavoritado;

public interface ServicoFavoritadoRepository extends JpaRepository<ServicoFavoritado, Long>{

	@Query("SELECT s FROM ServicoFavoritado s WHERE s.usuario.id = ?1")
	List<ServicoFavoritado> buscarServicosFavoritosPeloUsuario(Long usuario_id);
	
	@Query("SELECT s FROM ServicoFavoritado s WHERE s.usuario.id = ?1 AND s.servico.id = ?2")
	List<ServicoFavoritado> verificarSeJaServicoJaEstaComoFavorito(Long usuario_id, Long servico_id);
}