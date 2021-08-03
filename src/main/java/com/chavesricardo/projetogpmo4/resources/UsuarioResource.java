package com.chavesricardo.projetogpmo4.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chavesricardo.projetogpmo4.domain.Usuario;
import com.chavesricardo.projetogpmo4.services.UsuarioService;
	
	@RestController
	@RequestMapping(value="/usuarios")
	public class UsuarioResource {
		
		@Autowired
		private UsuarioService usuarioService;
			
		@RequestMapping(value="/datas", method=RequestMethod.GET)
		public ResponseEntity<Page<Usuario>> findPage(
				@RequestParam(value="usuario", defaultValue="") Integer usuario,		
				@RequestParam(value="dataInicial", defaultValue="") String dataInicial, //Parâmetros de URL são sempre Strings
				@RequestParam(value="dataFinal", defaultValue="") String dataFinal,     //Parâmetros de URL são sempre Strings
				@RequestParam(value="page", defaultValue="0") Integer page,
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
				@RequestParam(value="orderBy", defaultValue="data") String orderBy,
				@RequestParam(value="direction", defaultValue="ASC") String direction) {
			Page<Usuario> list = usuarioService.search(usuario, dataInicial, dataFinal, page, linesPerPage, orderBy, direction);
			return ResponseEntity.ok().body(list);
		}
	
	
}
