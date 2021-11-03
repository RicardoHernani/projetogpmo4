package com.chavesricardo.projetogpmo4.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chavesricardo.projetogpmo4.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "select usuario from Usuario usuario join usuario.pacientes paciente join paciente.cirurgias cirurgia where usuario.id = :usuario and (cirurgia.data between :dataInicial and :dataFinal)")
	Page<Usuario> search(@Param("usuario") Integer usuario, @Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal, Pageable pageRequest);

}

//	@Query(value ="SELECT * FROM USUARIO, PACIENTE, CIRURGIA WHERE USUARIO.ID=PACIENTE.USUARIO_ID AND PACIENTE.ID=CIRURGIA.PACIENTE_ID AND USUARIO.ID= :usuario AND (DATA>= :dataInicial AND DATA<= :dataFinal)", nativeQuery = true)
//	@Query(value = "select u from Usuario u join u.pacientes pac join pac.cirurgias cir where u.id = :usuario and (cir.data between :dataInicial and :dataFinal)")
//	@Query(value = "select usuario from Usuario usuario join usuario.pacientes paciente join paciente.cirurgias cirurgia where usuario.id = :usuario and (cirurgia.data between :dataInicial and :dataFinal)")
