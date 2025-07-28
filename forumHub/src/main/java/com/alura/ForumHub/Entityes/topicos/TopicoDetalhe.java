package com.alura.ForumHub.Entityes.topicos;

import com.alura.ForumHub.Entityes.cursos.Curso;
import com.alura.ForumHub.Entityes.respostas.Resposta;
import com.alura.ForumHub.Entityes.topicos.Topico;
import com.alura.ForumHub.Entityes.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;

public record TopicoDetalhe(
        Long id,
        @NotBlank()
        String titulo,
        @NotBlank()
        String mensagem,
        @NotBlank()
        String dataCriacao,
        @NotBlank()
        String status,

        @JsonProperty("autor")
        @Valid() Curso autor,

        @JsonProperty("curso")
        @Valid() Usuario curso,

        @Valid() List<Resposta> resposta
) {
    public TopicoDetalhe(Optional<Topico> topico) {
            this(
                    topico.get().getId(),
                    topico.get().getTitulo(),
                    topico.get().getMensagem(),
                    topico.get().getDataCriacao(),
                    topico.get().getStatus(),
                    topico.get().getCurso(),
                    topico.get().getAutor(),
                    topico.get().getRespostas()
            );
    }
}
