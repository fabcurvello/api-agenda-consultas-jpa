# API de Agendamento de Consultas (Spring Boot + JPA)

> Repositório didático: API REST desenvolvida em sala de aula para ensinar back-end com Java e Spring Boot.

## Sobre o projeto

API REST para **agendar consultas médicas**. Permite listar, criar e excluir consultas, valida os dados recebidos e impede que um médico tenha duas consultas no mesmo dia e horário. Funciona junto com o front-end [agenda-consultas-frontend](https://github.com/fabcurvello/agenda-consultas-frontend).

## Contexto acadêmico

Exercício aplicado em sala de aula, usado como prática guiada com os alunos.

## Endpoints

- `GET /consultas`: lista todas as consultas
- `POST /consultas`: agenda uma nova consulta (paciente, especialidade, médico, data e horário)
- `DELETE /consultas/{id}`: exclui uma consulta

## Regras de negócio

- Todos os campos são obrigatórios (Bean Validation: `@NotBlank`, `@NotNull`).
- Não é permitido agendar dois pacientes para o mesmo médico no mesmo dia e horário.
- Erros são devolvidos em formato padronizado por um `@RestControllerAdvice` (`GlobalExceptionHandler`).

## Arquitetura (camadas)

- `controller`: recebe as requisições HTTP
- `service`: regras de negócio
- `repository`: acesso a dados com Spring Data JPA
- `entity`: mapeamento da tabela `Consulta`
- `dto`: objetos de entrada e saída (`ConsultaRequest` / `ConsultaResponse`)
- `exception`: exceções personalizadas e tratamento global
- `config`: liberação de CORS para o front-end local (porta 5500)

## Tecnologias

- **Java 21**
- **Spring Boot 4** (Web MVC, Data JPA, Validation)
- **Hibernate / JPA**
- **H2 Database** (banco em memória, com console web)
- **Maven** (wrapper incluído)

## Como executar

```bash
git clone https://github.com/fabcurvello/api-agenda-consultas-jpa.git
cd api-agenda-consultas-jpa
./mvnw spring-boot:run
```

- API: `http://localhost:8080/consultas`
- Console do H2: `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:agendamento`, usuário `sa`, sem senha)

## Veja também

- [agenda-consultas-frontend](https://github.com/fabcurvello/agenda-consultas-frontend): front-end que consome esta API.

## Autor

**Fabricio Curvello**: professor de desenvolvimento de software no SENAI-RJ (desde 1997) e em faculdades do grupo Ânima Educação (IBMR e UNA).

- GitHub: [github.com/fabcurvello](https://github.com/fabcurvello)
- LinkedIn: [linkedin.com/in/fabriciocurvello](https://www.linkedin.com/in/fabriciocurvello)
- YouTube: [@fabriciocurvello](https://www.youtube.com/@fabriciocurvello)
