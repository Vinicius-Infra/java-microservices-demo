![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%232496ED.svg?style=for-the-badge&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23C1272D?style=for-the-badge&logo=swagger&logoColor=white)

🚀 Java Audit Service - Microservices
Esta é uma API REST robusta desenvolvida em Java 22 com Spring Boot 3, focada em auditoria de eventos e persistência de logs distribuídos. O projeto atua como o serviço de suporte para o ecossistema de microsserviços, garantindo o rastreamento de todas as operações de negócio.

🛠️ Tecnologias e Ferramentas
Linguagem: Java 22 (JVM)

Framework: Spring Boot 3.2.5

Persistência: Spring Data JPA & Hibernate

Banco de Dados: PostgreSQL 15

Documentação: SpringDoc OpenAPI (Swagger)

Build Tool: Maven

Infraestrutura: Docker & Docker Compose

🏗️ Arquitetura do Projeto
O projeto segue a estrutura padrão de camadas do Spring, garantindo separação de responsabilidades e alta manutenibilidade:

model: Entidades JPA que definem a estrutura dos logs de auditoria.

repository: Interfaces de comunicação com o banco de dados PostgreSQL.

service: Lógica para processamento e filtragem de eventos recebidos.

controller: Endpoints REST otimizados para recebimento de logs e consultas.

config: Configurações de infraestrutura, CORS e personalização do OpenAPI.

🚀 Como Rodar o Projeto
Pré-requisitos
JDK 17 ou 22

Docker & Docker Compose

1. Subir o Banco de Dados (PostgreSQL)
Certifique-se de que o Postgres está rodando na porta 5433 para evitar conflitos com outros serviços:

docker-compose up -d

O container criará automaticamente o banco audit_db.

2. Compilar e Executar

# Limpar e compilar
./mvnw clean install

# Executar a aplicação
./mvnw spring-boot:run

A aplicação estará disponível em http://localhost:8083.

📖 Documentação da API
Com a aplicação rodando, você pode acessar a interface interativa do Swagger para testar os endpoints e visualizar os schemas:

🔗 Swagger UI: http://localhost:8083/swagger-ui/index.html

📄 OpenAPI JSON: http://localhost:8083/v3/api-docs


🧪 Endpoints Principais

Método	                    Endpoint	                      Descrição

GET	                        /audit	                        Lista todos os eventos de auditoria registrados.
POST	                     /audit/log	                      Recebe e armazena um novo evento (UserId, Operação, etc).
GET	                      /hello	                          Endpoint de health check para teste de conectividade.


🛡️ Observabilidade e Integração
Este serviço foi desenhado para ser integrado via HTTP. Atualmente, recebe logs da Kotlin API Demo, registrando operações de:

CREATE: Quando um novo usuário é inserido.

UPDATE: Quando dados de usuários são alterados.

DELETE: Quando um rastro de remoção é necessário.


Autor: Marcos Vinícius da Silva Barreto

LinkedIn: vinicius-barreto-devops

GitHub: Vinicius-Infra

Developed with ❤️ and Java.