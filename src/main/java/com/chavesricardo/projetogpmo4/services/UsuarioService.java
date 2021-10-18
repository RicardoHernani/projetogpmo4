package com.chavesricardo.projetogpmo4.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.chavesricardo.projetogpmo4.domain.Usuario;
import com.chavesricardo.projetogpmo4.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Page<Usuario> search(Integer usuario, Date dataInicial, Date dataFinal,  Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return usuarioRepository.search(usuario, dataInicial, dataFinal,  pageRequest);
	}

}
