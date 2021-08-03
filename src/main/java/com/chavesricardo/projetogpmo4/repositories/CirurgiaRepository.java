package com.chavesricardo.projetogpmo4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chavesricardo.projetogpmo4.domain.Cirurgia;

@Repository
public interface CirurgiaRepository extends JpaRepository<Cirurgia, Integer> {

}