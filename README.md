# App com Angular 5.0 e Spring Boot 2.0
 
Esse é uma aplicação simples onde está implementado um microservice construído com spring boot e um client
 construído com angular 5 consumindo essa API. 
 Este serviço carrega uma lista de usuários enquanto o client mostra os dados em uma tabela utilizando angular material.
 Os dados são carregados em um banco de dados em arquivo(h2) com instruções default de create-drop  

**Pre requisitos:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Node.js](https://nodejs.org/).

## Running

Para instalar e executar a aplicação de backend execute os seguintes comandos:

```bash
cd user-list-app/server
./mvnw install
./mvnw spring-boot:run
```
Para instalar e executar a aplicação de frontend execute os seguintes comandos:
  
```bash
cd user-list-app/client
npm install 
npm start
```

Depois disso a aplicação deverá estar rodando em 'http://localhost:4200'

As configurações de banco estão em um arquivo de configuração: server/src/resources/application.yml

```bash
spring:
  h2:
    console.enabled: true
    console.path: /h2

  datasource.url: jdbc:h2:file:/home/guilherme/dbh2teste
  datasource.username: sa
  datasource.password:
  datasource.driver-class-name: org.h2.Driver

  jpa.hibernate.ddl-auto: create-drop
```


## Built With

Esse app utiliza as seguintes tecnologias:

* [Spring (boot, rest, jpa, web)](https://spring.io/)
* [Angular 5 (TypeScript)](https://angular.io/)
* [Angular Material](https://material.angular.io/)
* [Maven](https://maven.apache.org/)
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Node.js](https://nodejs.org/)
* [H2](http://www.h2database.com/html/main.html)

## Author

Guilherme Nascimento
