package com.Ec1DanielAtoche.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ec1DanielAtoche.Model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
