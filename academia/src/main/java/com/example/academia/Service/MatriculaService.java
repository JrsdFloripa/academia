package com.example.academia.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.academia.Dto.Response.MatriculaResponseDto;
import com.example.academia.Dto.request.MatriculaCreateDTO;
import com.example.academia.Entity.Aluno;
import com.example.academia.Entity.Matricula;
import com.example.academia.Repository.AlunoRep;
import com.example.academia.Repository.MatriculaRepository;
import java.time.LocalDateTime;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository repository;
    @Autowired
    private AlunoRep alunoRepository;

    public MatriculaService(MatriculaRepository repository, AlunoRep alunoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
    }

    public MatriculaResponseDto create(MatriculaCreateDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setDataMatricula(LocalDateTime.now());

        Matricula saved = repository.save(matricula);

        return new MatriculaResponseDto(
                saved.getId(),
                saved.getDataMatricula(),
                saved.getAluno().getId()
        );
    }
}