# FórumHub API

Bem-vindo ao **FórumHub**, uma API REST desenvolvida com Spring Framework como parte de um desafio de back-end da Alura. A proposta é replicar funcionalidades básicas de um fórum como o utilizado pelos alunos da plataforma, incluindo autenticação, gerenciamento de tópicos e persistência de dados com banco relacional.

## 🔧 Tecnologias Utilizadas

- Java (JDK 17+ recomendado)
- Spring Boot
- Spring Security
- Spring Data JPA
- Banco de dados relacional (MySQL, PostgreSQL, H2, etc.)
- Swagger (OpenAPI 3.1)
- JWT para autenticação

## 📦 Funcionalidades da API

A API oferece operações básicas de CRUD (Create, Read, Update, Delete) para gerenciamento de tópicos em um fórum:

### 🔐 Autenticação

- `POST /auth/registro` – Cadastro de novo usuário
- `POST /auth/login` – Autenticação e geração de token JWT

### 🧵 Tópicos

- `GET /topicos` – Lista todos os tópicos
- `GET /topicos/{id}` – Retorna um tópico específico por ID
- `POST /topicos` – Cria um novo tópico
- `PUT /topicos/{id}` – Atualiza um tópico existente
- `DELETE /topicos/{id}` – Remove um tópico por ID

### Pré-requisitos

- Java 17+
- Maven
- Banco de dados relacional (ou H2 para testes)