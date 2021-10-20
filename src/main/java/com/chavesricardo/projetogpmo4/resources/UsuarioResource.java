package com.chavesricardo.projetogpmo4.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chavesricardo.projetogpmo4.domain.Usuario;
import com.chavesricardo.projetogpmo4.resources.util.URL;
import com.chavesricardo.projetogpmo4.services.UsuarioService;
	
	@RestController
	@RequestMapping(value="/usuarios")
	public class UsuarioResource {
		
		@Autowired
		private UsuarioService usuarioService;
			
		@RequestMapping(value="/datas", method=RequestMethod.GET)
		public ResponseEntity<Page<Usuario>> findPage(
				@RequestParam(value="usuario", defaultValue="") Integer usuario, //Parâmetros podem ser inteiros ou Strings nas requisições URL's	
				@RequestParam(value="dataInicial", defaultValue="") String dataInicial, //Parâmetros podem ser inteiros ou Strings nas requisições URL's
				@RequestParam(value="dataFinal", defaultValue="") String dataFinal,     //Parâmetros podem ser inteiros ou Strings nas requisições URL's
				@RequestParam(value="page", defaultValue="0") Integer page,
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
				@RequestParam(value="orderBy", defaultValue="nome") String orderBy,
				@RequestParam(value="direction", defaultValue="ASC") String direction) {
			
			Date inicio = URL.convertDate(dataInicial, new Date(0L));
			Date fim = URL.convertDate(dataFinal, new Date());
			
			Page<Usuario> list = usuarioService.search(usuario, inicio, fim, page, linesPerPage, orderBy, direction);
			return ResponseEntity.ok().body(list);
		}
}
