package com.alura.ForumHub.Entityes.respostas;

import com.alura.ForumHub.Entityes.topicos.Topico;
import com.alura.ForumHub.Entityes.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "resposta")
@Entity(name = "resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private String solucao;
    private Date dataCriacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Topico topico;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Usuario autor;

    public Long getId() {
        return id;
    }

    public String getMensagen() {
        return mensagem;
    }

    public Topico getTopico() {
        return topico;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMenssagen(String menssagen) {
        this.mensagem = menssagen;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }
}



