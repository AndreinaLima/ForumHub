package com.alura.ForumHub.Entityes.respostas;

import com.alura.ForumHub.Entityes.topicos.TopicoDTO;
import com.alura.ForumHub.Entityes.usuario.UsuarioDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public record RespostaDTO(
        Long id,
        String menssagen,
        String solucao,
        String dataCriacao,
        TopicoDTO topico,
        UsuarioDTO autor
) {}
