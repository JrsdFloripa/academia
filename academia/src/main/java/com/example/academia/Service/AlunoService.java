package com.example.academia.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.academia.Dto.Response.AlunoResponseDTO;
import com.example.academia.Dto.request.AlunoCreateDTO;
import com.example.academia.Entity.Aluno;
import com.example.academia.Repository.AlunoRep;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private  AlunoRep repository;

    public AlunoService(AlunoRep repository) {
        this.repository = repository;
    }

    public AlunoResponseDTO create(AlunoCreateDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setCpf(dto.cpf());
        aluno.setBairro(dto.bairro());
        aluno.setDataNascimento(dto.dataNascimento());

        Aluno saved = repository.save(aluno);
        return toResponse(saved);
    }

    public List<AlunoResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public AlunoResponseDTO findById(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return toResponse(aluno);
    }

    private AlunoResponseDTO toResponse(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getBairro(),
                aluno.getDataNascimento()
        );
    }

    public AlunoResponseDTO findByNome(String nome) {
        Aluno aluno = repository.findByNome(nome);
        if (aluno == null) {
            throw new RuntimeException("Aluno não encontrado");
        }
        return toResponse(aluno);
    }


    public AlunoResponseDTO update(Long id, AlunoCreateDTO dto) {
        return repository.findById(id)
                .map(aluno -> {
                    aluno.setNome(dto.nome());
                    aluno.setCpf(dto.cpf());
                    aluno.setBairro(dto.bairro());
                    aluno.setDataNascimento(dto.dataNascimento());
                    Aluno updated = repository.save(aluno);
                    return toResponse(updated);
                })
                
        .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

}
