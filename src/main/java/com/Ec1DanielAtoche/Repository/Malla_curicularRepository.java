package com.Ec1DanielAtoche.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ec1DanielAtoche.Model.Malla_curicular;

@Repository
public interface Malla_curicularRepository extends JpaRepository<Malla_curicular, Integer> {

}
