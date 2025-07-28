package com.alura.ForumHub.Controllers;

import com.alura.ForumHub.Entityes.usuario.DadosAutenticacao;
import com.alura.ForumHub.Entityes.usuario.DadosCadastroUsuario;
import com.alura.ForumHub.Entityes.usuario.Usuario;
import com.alura.ForumHub.Entityes.usuario.UsuarioRepository;
import com.alura.ForumHub.infra.security.DadosTokenJWT;
import com.alura.ForumHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostMapping("/login")
    public ResponseEntity<String> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var authentication = manager.authenticate(authenticationToken);

            var usuario = (Usuario) authentication.getPrincipal();
            var tokenJWT = tokenService.gerarToken(usuario);

            return ResponseEntity.ok("Login realizado com sucesso. Token: " + tokenJWT);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Falha na autenticação: login ou senha inválidos.");
        }
    }


    @PostMapping("/registro")
    public ResponseEntity registrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados) {
        if (usuarioRepository.findByLogin(dados.login()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existente");
        }

        String senhaCriptografada = passwordEncoder.encode(dados.senha());
        Usuario novoUsuario = new Usuario(new DadosCadastroUsuario(
                dados.login(),
                senhaCriptografada,
                dados.email()
        ));

        usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok("Usuário registrado com sucesso");
    }


}
