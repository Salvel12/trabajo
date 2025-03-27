package com.registro.usuarios.servicio;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

@Service
public class 	UsuarioServicioImpl implements UsuarioServicio {

	
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(
				registroDTO.getNombre(),
				registroDTO.getApellido(),
				registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getPassword()),
				registroDTO.getRol()
		);
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepositorio.findByEmail(username);
		if (usuario.isPresent()) {
			return new User(
					usuario.get().getEmail(),
					usuario.get().getPassword(),
					Collections.singletonList(new SimpleGrantedAuthority(usuario.get().getRol())) // Convertir String en GrantedAuthority
			);
		}
		throw new UsernameNotFoundException("Usuario o password inválidos");
	}
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}
}
