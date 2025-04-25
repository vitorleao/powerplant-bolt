# PowerPlant

## Descrição
O PowerPlant é uma aplicação Spring Boot desenvolvida para gerenciar dados de usinas elétricas. Ele realiza o download periódico de um arquivo CSV contendo informações sobre usinas, persiste os dados em um banco de dados PostgreSQL e fornece uma API REST para consulta.

## Objetivo
O objetivo deste projeto é automatizar o processo de coleta, armazenamento e consulta de dados de usinas elétricas, facilitando o acesso a informações relevantes para análise e tomada de decisão.

## Requisitos
- **Java 21** ou superior
- **Maven** 3.8 ou superior
- **PostgreSQL** 13 ou superior
- Conexão com a internet para baixar o arquivo CSV

## Como Começar
1. Clone o repositório:
   ```bash
   git clone https://github.com/vitorleao/powerplant-bolt.git
   cd powerplant-bolt
2. Configure o banco de dados no arquivo application.yml:
    ```yml
    spring:
      datasource:
        url: jdbc:postgresql://localhost:5432/usinas
        username: postgres
        password: sua_senha
      jpa:
        hibernate:
          ddl-auto: update
        show-sql: true
        properties:
          hibernate:
            format_sql: true
3. Compile e execute o projeto:
    ```bash
    mvn clean package
    java -jar target/PowerPlant-0.0.1-SNAPSHOT.jar
4. Acesse a API REST:
    * Endpoint para consultar as 5 usinas com maior potência: http://localhost:8080/api/usinas/top5
5. O job para baixar e persistir o CSV será executado automaticamente a cada 5 minutos.

## Autor
Trabalho em desenvolvimento por Vitor Leão. Sinta-se a vontade para conferir outros projetos dentro do meu repositório de código e sugerir melhorias.