package com.projetointegrador.upservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.upservice.model.Servico;
import com.projetointegrador.upservice.model.Usuario;
import com.projetointegrador.upservice.repository.ServicoRepository;

@RestController
@RequestMapping(value = "/servico")
public class ServicoResource {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping(value = "/buscar-todos-servicos")
	public List<Servico> buscarTodosServicos() {
		return servicoRepository.findAll();
	}
	
	@PostMapping(value = "/cadastrar-servico")
	public Servico cadastrarServico(@RequestBody Servico servico) {
		return servicoRepository.save(servico);
	}
	
	@PostMapping(value = "/deletar-servico")
	public String deletarServico(@RequestBody Servico servico) {
		servicoRepository.delete(servico);
		return "Servico deletado.";
	}
	
	@PostMapping(value = "/atualizar-servico")
	public Servico atualizarServico(@RequestBody Servico servico) {
		return servicoRepository.save(servico);
	}
	
	@PostMapping(value = "/buscar-servicos-do-usuario")
	public List<Servico> buscarServicosDoUsuario(@RequestBody Usuario usuario) {
		return servicoRepository.buscarServicosDoUsuario(usuario.getId());
	}
}