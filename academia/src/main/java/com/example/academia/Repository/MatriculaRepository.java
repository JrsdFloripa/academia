package com.example.academia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.academia.Entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {}
