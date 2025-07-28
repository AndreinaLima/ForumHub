package com.alura.ForumHub.Entityes.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank String login,
        @NotBlank String senha,
        @Email @NotBlank String email
) {}
