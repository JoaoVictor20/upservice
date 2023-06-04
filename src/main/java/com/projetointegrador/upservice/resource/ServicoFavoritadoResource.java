package com.projetointegrador.upservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.upservice.model.ServicoFavoritado;
import com.projetointegrador.upservice.model.Usuario;
import com.projetointegrador.upservice.repository.ServicoFavoritadoRepository;

@RestController
@RequestMapping(value = "/servico/favorito")
public class ServicoFavoritadoResource {

	@Autowired
	private ServicoFavoritadoRepository servicoFavoritadoRepository;
	
	@PostMapping(value = "/buscar-servicos-favoritos-do-usuario")
	public List<ServicoFavoritado> buscarServicosFavoritosDoUsuario(@RequestBody Usuario usuario) {
		return servicoFavoritadoRepository.buscarServicosFavoritosPeloUsuario(usuario.getId());
	}
	
	@PostMapping(value = "/favoritar-servico")
	public String favoritarServico(@RequestBody ServicoFavoritado servicoFavoritado) {
		
		List<ServicoFavoritado> servicos = servicoFavoritadoRepository.verificarSeJaServicoJaEstaComoFavorito(
				servicoFavoritado.getUsuario().getId(),
				servicoFavoritado.getServico().getId());
		
		if(servicos.isEmpty()) {
			servicoFavoritadoRepository.save(servicoFavoritado);
			return "Servico favoritado.";
		}
		return "Servico já favoritado anteriormente.";
	}
	
	@PostMapping(value = "/desfavoritar-servico")
	public void deletarServico(@RequestBody ServicoFavoritado servicoFavoritado) {
		servicoFavoritadoRepository.delete(servicoFavoritado);
	}
}