<h4> Teste Dev Java e Reach </h4>

<hr>

<h3 align="center">
    Teste Técnico Desenvolvedor React Java (Spring Boot) 
    <br>
    API RESTful com Spring Boot
    <br><br>
    <p align="center">
      <a href="#-sobre">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
      <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
      <a href="#-funcionalidades">Funcionalidades da API</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
      <a href="#-endpoints">Endpoints</a>&nbsp;&nbsp;&nbsp;
  </p>
</h3>

<hr>

## 🔖 Sobre

O Objetivo será avaliar sua capacidade de criar uma aplicação web funcional, garantindo uma experiência de usuário e segurança no processo de autenticação. Desenvolva um sistema web de login que atenda aos seguintes requisitos:
- Cadastrar um usuário utilizando nome, e-mail, senha, CPF, (Perfil Usuário, Administrador) sem a necessidade de estar logado no sistema.
- Permitir que esse usuário criado faça o login no sistema e acesse a tela de HOME, contendo uma mensagem de “Hola Mundo”.
- Validação para não permitir a criação de usuários com dados duplicados ou inválidos.
- Tela para realizar a troca de minha própria senha, solicitando a confirmação de inserção dos dados.
- Os usuários que tiverem o perfil de Administrador poderão acessar uma lista contendo todos os usuários cadastrados no sistema, com a opção de exclusão dos usuários cadastrados na plataforma.

## 🚀 Tecnologias

- Frontend:
  - Náo conseguir implementar falta de conhecimento em react.

- Backend:
  - [Java 18]
  - [Spring Boot]
  - [Swagger Open API]
  - [Autenticação com JWT e Spring Security]
  - [Apache Maven]
  - [MySQL Server]

- Ferramenta
  - [IntelliJ]
  - [Postman]
  - [Git]
  - [Docker]


## Funcionalidades da API
- Requisitos / Usuários
  - O usuário deverá ter um e-mail, o qual será usado como username (deve ser único)
  - O usuário deverá ter uma senha de 8 caracteres no min e max 20 caracteres
  - O usuário deverá ter um perfil de administrador ou user. 
      - Obs: atuamente é padrao todos usuarios ser criandos como User porém vou deixar script sql para vc criar usuarios 
  - O usuário será criado sem a necessidade de autenticação.
  - O usuário poderá ser localizado pelo identificador gerado.
    - O administrador, quando autenticado, poderá recuperar qualquer usuário pelo id.
    - O cliente, quando autenticado, poderá somente recuperar seus próprios dados de usuário.
  - O usuário poderá alterar a senha
    - Apenas quando estiver autenticado e somente o próprio usuário terá essa autorização.
  - O administrador poderá listar todos os usuários quando estiver autenticado.
  - Todos os recursos criados estão documentados.
- Requisitos / Autenticação
  - Implementar um sistema de segurança e autenticação com JSON Web Token
  - O recurso criado está documentado..

## Endpoints

- Pesquisar todos Usuarios
  - GET http://localhost:8080/api/v1/users


  - Pesquisar por ID
    - GET http://localhost:8080/api/v1/users/{id}

  - Criar Novos Usuario 
    - POST http://localhost:8080/api/v1/users
    ```
      {
        "name": "julio",
        "cpf": "817.119.530-08",
        "username": "julio@gmail.com",
        "password": "123456789"
      }
    ```
  - Autenticação do usuário'
    - POST http://localhost:8080/api/v1/auth
    ```
        {
          "username": "julio@gmail.com",
          "password": "123456789"
        }
    ```
  - Atualizar senha
    - PATCH http://localhost:8080/api/v1/users/{id}
  ```
    {
      "currentPassword": "12345678910",
      "newPassword": "123456789",
      "confirmPassword": "123456789"
    }
  ```

  - Deletar um usuario 
    - DELETE http://localhost:8080/api/v1/users/{id}


- Mais informações dos endpoints está no Swagger
- Script SQL na pasta reources so projeto.
