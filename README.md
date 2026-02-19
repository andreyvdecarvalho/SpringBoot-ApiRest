# SpringBoot-ApiRest (OakMed API)

API REST desenvolvida em **Java 17 + Spring Boot**, criada como projeto para demonstrar boas práticas de **back-end**, incluindo arquitetura em camadas, validações, persistência com JPA, testes automatizados e documentação Swagger, versionamento de banco com Flyway e autenticação com JWT.


## Objetivo do Projeto
Este projeto tem como objetivo demonstrar competências práticas em desenvolvimento **Back-end Java**, com foco em:
- Construção de APIs REST seguindo padrões de mercado
- Separação de responsabilidades (Controller, Service, Repository)
- Validação de dados de entrada
- Tratamento global de erros
- Persistência com Spring Data JPA
- Migrações de banco de dados versionadas
- Autenticação baseada em JWT


## Stack Tecnológica
- **Java:** 17  
- **Spring Boot**
- Spring Web
- Spring Data JPA (Hibernate)
- Spring Validation (Bean Validation)
- Spring Security
- JWT (Auth0 – java-jwt)
- Flyway
- MySQL
- Swagger (OpenAPI)
- JUnit 5
- Mockito
- Maven


## Funcionalidades

### Médicos
- Cadastro de médicos
- Listagem de médicos ativos com paginação
- Detalhamento por ID
- Atualização de dados
- Remoção lógica (soft delete via campo `ativo`)

### Pacientes
- Cadastro de pacientes
- Listagem de pacientes ativos com paginação
- Detalhamento por ID
- Atualização de dados
- Remoção lógica (soft delete via campo `ativo`)

### Autenticação
- Login de usuário com geração de **JWT**


## Arquitetura
O projeto segue uma arquitetura em camadas:

- `controller` — Endpoints REST e contratos HTTP
- `service` — Regras de negócio
- `repository` — Acesso a dados com JPA
- `domain` — Entidades e DTOs
- `exception` — Tratamento global de erros com `@RestControllerAdvice`
- `security` — Configurações de segurança e autenticação JWT

### Boas práticas aplicadas
- Uso de **DTOs** para entrada e saída de dados
- Validação de payload com **Bean Validation**
- Respostas HTTP padronizadas
- Tratamento centralizado de exceções
- Paginação com `Pageable`

### Testes Automatizados
O projeto possui testes unitários utilizando:
- JUnit 5
- Mockito
Cobertura aplicada em:
- Camada de Controller
- Camada de Repository

## Banco de Dados e Migrações
O controle de versão do banco é feito com **Flyway**

### Build do Projeto
Projeto empacotado via Maven no IntelliJ
1. Clonar o repositório:
2. Configurar banco de dados no application.properties
3. Executar.
