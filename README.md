
# Desafio Desenvolvedor Back-End

Esse repositório contém o back end do desafio proposto para a vaga de desenvolvedor.




## Autores

- [@guinafelix](https://www.github.com/guinafelix)


## Stack utilizada

**Back-end:** Java, Spring Boot 3, Maven, Postgres

**Bibliotecas:** Spring-Security, OpenAPI
## Documentação da API

Essa api foi desenvolvida utilizando Swagger (OpenAPI)

#### Para acessar a documentação completa basta rodar a aplicação e acessar a rota http://localhost:8080/docs.html

#### Também é possível acessar o diagrama de classes utilizado acessando o arquivo "diagrama.pdf" na pasta "static".

## Funcionalidades

- Administrador (CRUD Completo de Disciplinas, Cursos, Perfis e Usuários)
- Alunos e professores (Visualizar matriz curricular)


## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu .env

`JWT_SECRET`  - Representa o segredo utilizado para gerar o hash do token de usuário.




## Rodando localmente

Clone o projeto

```bash
  git clone git@github.com:guinafelix/desafio-profectum.git
```

Entre no diretório do projeto

```bash
  cd my-project
```

Subindo o banco postgres

```bash
  cd composers
```

```bash
  docker compose -f composer-postgres.yml up -d
```

Instale as dependências

```bash
  mvn clean install
```

Inicie o servidor

```bash
  mvn spring-boot:run
```


## FAQ

#### Qual arquitetura foi desenvolvida na execução deste projeto?

Este projeto foi desenvolvido implementando noções em conjunto dos modelos MVC, Clean Archictecure e SOLID. Por uma questão de praticidade, o projeto não implementa todas as camadas de abstração existentes no padrão Clean Architecture mas utiliza sua base no que se refere a injeção de dependência para abstração dos componentes como também se utiliza de princípios do SOLID como "Single Principle Responsability" para a criação dos serviços.

#### Quais entidades foram desenvolvidas para solucionar as questões propostas no desafio?

O sistema é composto basicamente por cinco entidades (Usuario, Perfil, Disciplina, Curso e Oferta). O diagrama de classes completo mostrando as relações entre as entidades está presente na pasta Static do projeto.

Os usuários possuem um perfil que representa o seu conjunto de permissões de acessos aos recursos do sistema. Os usuários com perfil "Admin" possuem acesso a todas as rotas disponíveis, enquanto os usuários do tipo aluno e professor conseguem acessar apenas a rota de visualização da matriz curricular.

#### Quais pontos do projeto podem ser melhorados?

- Por ser apenas um projeto de demonstração, optei por não utilizar todas as práticas geralmentes indicadas com o intuito de agilizar o processo de desenvolvimento, em um cenário real o mais indicado seria aumentar as camadas de abstração da aplicação e também separar completamente os componentes de acordo com os princípios do SOLID. 

- Os id's dos usuários atualmente estão sendo gerados como inteiros, o que pode facilmente ser alterado para o formato uuid.

- A gestão de acesso as rotas também foi feita de maneira a simplificar o desenvolvimento e atender de maneira prática as questões propostas.


## 🚀 Sobre mim
Eu sou um Desenvolvedor FullStack que possui conhecimento nas Stacks Spring Boot, Node.js, Nest.js, React.js, Angular, Flask e FastAPI.
## Licença

[MIT](https://choosealicense.com/licenses/mit/)
