package com.example.academia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.academia.Entity.Aluno;

public interface AlunoRep extends JpaRepository<Aluno, Long> {

    Aluno findByNome(String nome);}
