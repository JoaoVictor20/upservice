package com.projetointegrador.upservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.upservice.model.Usuario;
import com.projetointegrador.upservice.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping(value = "/cadastrar-usuario")
	public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PostMapping(value = "/atualizar-usuario")
	public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PostMapping(value = "/login")
	public Usuario logarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.logarUsuario(usuario.getEmail(), usuario.getSenha());
	}
}