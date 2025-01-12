# Sistema de Gerenciamento de Bebês

Este projeto é uma API RESTful desenvolvida em **Spring Boot** para gerenciar registros de bebês e suas informações associadas. A aplicação permite o cadastro, consulta, atualização e exclusão de dados, com suporte a filtros avançados e paginação.

## Funcionalidades

- **Cadastro de bebês** com informações detalhadas (nome, altura, peso, pais).
- **Consultas avançadas**:
  - Busca por nome do bebê.
  - Filtragem por peso maior que o valor informado.
  - Busca por intervalo de altura.
  - Contagem de bebês com peso específico.
  - Busca por nome da mãe com paginação.
- **Atualização de registros**.
- **Exclusão de registros**.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Hibernate** (JPA)
- **MySQL** (Banco de dados)
- **Jakarta Validation** (Validação de campos)
- **Maven** (Gerenciamento de dependências)

## Estrutura do Projeto

- **Model**: Representa as entidades do sistema e suas validações.
- **Repository**: Camada de persistência para manipulação do banco de dados.
- **Service**: Camada de negócios responsável pela lógica das funcionalidades.
- **Controller**: Camada de controle, gerencia as requisições e as respostas da API.

## Requisitos de Configuração

1. **Banco de Dados MySQL**: Configure um banco de dados com o nome `db_bebe`. As credenciais padrão estão definidas no arquivo `application.properties`:
    - `spring.datasource.username=****`
    - `spring.datasource.password=****`
2. Certifique-se de ter o **MySQL Driver** e configurado o **JDK 17** em sua máquina.

## Executando o Projeto

1. Clone o repositório:
   ```bash
   git clone 

