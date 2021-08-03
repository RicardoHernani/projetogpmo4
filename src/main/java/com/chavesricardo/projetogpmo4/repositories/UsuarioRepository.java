package com.chavesricardo.projetogpmo4.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chavesricardo.projetogpmo4.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "SELECT * FROM USUARIO, PACIENTE, CIRURGIA, PACIENTE_CIRURGIA, USUARIO_PACIENTE \r\n"
			+ "WHERE USUARIO.ID=USUARIO_ID AND PACIENTE.ID=PACIENTE_ID AND CIRURGIA.ID=CIRURGIA_ID AND PACIENTE_CIRURGIA_ID=PACIENTE_ID AND USUARIO.ID= :usuario AND (DATA BETWEEN :dataInicial AND :dataFinal)", nativeQuery = true)
	Page<Usuario> search(@Param("usuario") Integer usuario, @Param("dataInicial") String dataInicial, @Param("dataFinal") String dataFinal, Pageable pageRequest);

}
