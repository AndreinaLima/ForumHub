package com.alura.ForumHub.Entityes.topicos;

import com.alura.ForumHub.Entityes.cursos.Curso;
import com.alura.ForumHub.Entityes.respostas.Resposta;
import com.alura.ForumHub.Entityes.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DadosAtualizacaoTopico(
        @NotBlank()
        String titulo,
        @NotBlank()
        String mensagem,
        @NotBlank()
        String dataCriacao,
        @NotBlank()
        String status,

        @Valid()
        @JsonProperty("autor")
        Usuario autor,

        @Valid()
        @JsonProperty("curso")
        Curso curso,

        @Valid()
        List<Resposta> resposta
) {
    public DadosAtualizacaoTopico(DadosAtualizacaoTopico topico) {
        this(topico.titulo(),topico.mensagem(),topico.dataCriacao(),topico.status(), topico.autor(), topico.curso(), topico.resposta());
    }
}
