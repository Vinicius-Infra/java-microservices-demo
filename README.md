# Java Microservices Demo

Projeto de demonstração de microserviços em **Java Spring Boot** com integração ao **PostgreSQL** via Docker.  
Inclui tratamento de exceções customizadas, documentação da API com **Swagger/OpenAPI** e testes unitários e de integração.

---

## 🚀 Tecnologias
- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- PostgreSQL 15 (Docker)
- PgAdmin 4
- Maven
- JUnit 5
- Swagger/OpenAPI

---

## ⚙️ Configuração

### Pré-requisitos
- Docker e Docker Compose instalados
- Java 17
- Maven

### Subindo os containers
```bash
docker-compose up -d

Isso irá iniciar:

Postgres em localhost:5433

PgAdmin em http://localhost:8081

Configuração da aplicação
Arquivo application-postgres.properties:

spring.datasource.url=jdbc:postgresql://localhost:5433/microservicesdb?sslmode=disable
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.defer-datasource-initialization=true

Rodando a aplicação
mvn spring-boot:run


📚 Endpoints
Criar usuário

POST /users
Content-Type: application/json

{
  "name": "Vinicius",
  "email": "vinicius@email.com"
}


Listar usuários
GET /users


🛡️ Tratamento de Exceções
O projeto inclui uma camada de exceções customizadas para respostas mais claras da API:

UserNotFoundException → retorna 404 Not Found

InvalidUserException → retorna 400 Bad Request

GlobalExceptionHandler → captura exceções e retorna mensagens padronizadas em JSON

Exemplo de resposta de erro:

{
  "timestamp": "2026-04-05T18:02:07.221+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Email inválido",
  "path": "/users"
}


📖 Documentação com Swagger
A documentação da API é gerada automaticamente com Swagger/OpenAPI.
Após subir a aplicação, acesse:

http://localhost:8080/swagger-ui.html


🧪 Testes
Unitários
Implementados com JUnit 5, cobrindo:

Criação de usuários (POST /users)

Listagem de usuários (GET /users)

Validação de campos obrigatórios

Tratamento de exceções

Integração
Testes de integração garantem o funcionamento completo da aplicação com o banco de dados:

Verificação da criação automática da tabela users

Inserção e recuperação de registros reais

Testes de endpoints via MockMvc

Rodar testes:

mvn test


🗄️ Banco de Dados
Após subir a aplicação, a tabela users será criada automaticamente:

SELECT * FROM users;
