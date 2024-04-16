# Programa de Linha de Comando Java com Spring Boot e API do Vagalume

Este projeto é um exemplo de um programa de linha de comando em Java com Spring Boot que consome a API do Vagalume para buscar informações sobre músicas, álbuns e artistas. Além disso, permite salvar esses dados em um banco de dados relacional e realizar operações de busca.

## Pré-requisitos

Antes de iniciar, você precisa ter instalado em sua máquina:

- JDK 17 (ou superior)
- Maven
- MySQL (ou outro banco de dados de sua preferência)

## Configuração do Banco de Dados

1. Crie um banco de dados MySQL com o nome `vagalumemusic`.
2. Abra o arquivo `application.properties` localizado em `src/main/resources` e atualize as configurações do banco de dados de acordo com o seu ambiente:
```
spring.datasource.url=jdbc:mysql://localhost:3306/vagalumemusic
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

```


## Executando o Programa

1. Clone este repositório para sua máquina:
```
git clone https://github.com/pedruuv/sound-app.git
```


2. Navegue até o diretório do projeto:


3. Compile o projeto usando o Maven:
```
mvn clean package
```
