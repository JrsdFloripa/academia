package com.example.academia.Service;


import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.academia.Dto.Response.AvaliacaoFisicaResponseDTO;
import com.example.academia.Dto.request.AvaliacaoFisicaCreateDTO;
import com.example.academia.Entity.Aluno;
import com.example.academia.Entity.AvaliacaoFisica;
import com.example.academia.Repository.AlunoRep;
import com.example.academia.Repository.AvaliacaoFisicaRep;

   @Service
public class AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRep repository;
    @Autowired
    private AlunoRep alunoRepository;

    public AvaliacaoFisicaService(AvaliacaoFisicaRep repository,
                                  AlunoRep alunoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
    }

    public AvaliacaoFisicaResponseDTO create(AvaliacaoFisicaCreateDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        AvaliacaoFisica avaliacao = new AvaliacaoFisica();
        avaliacao.setAluno(aluno);
        avaliacao.setPesoAtual(dto.pesoAtual());
        avaliacao.setAlturaAtual(dto.alturaAtual());
        avaliacao.setDataAvaliacao(LocalDateTime.now());

        AvaliacaoFisica saved = repository.save(avaliacao);

        return new AvaliacaoFisicaResponseDTO(
                saved.getId(),
                saved.getDataAvaliacao(),
                saved.getPesoAtual(),
                saved.getAlturaAtual(),
                saved.getAluno().getId()
        );
    }
}