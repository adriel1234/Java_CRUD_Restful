# CRUD RESTFULL SPRING BOOT + POSTGRESQL

Este projeto é uma API RESTful desenvolvida com Spring Boot.

## Como executar o projeto

Antes de tudo, você precisa ter o Java 11 e o Maven instalados em sua máquina. Também é necessário ter instalado o Postgresql.
A versão do postgres usada nesse projeto é a versão 9.5;

Para executar o projeto, siga os seguintes passos:

1. Clone o repositório para sua máquina local
2. Criar o banco de dados com o nome mercadinho.
3. Navegue até o diretório do projeto
4. Execute o comando `mvn spring-boot:run`
5. Acesse a API através do endereço `http://localhost:8080`

## Dependências

Este projeto utiliza as seguintes dependências:

- Spring Boot 2.7.1
- Spring Boot Starter Web
- Spring Boot DevTools
- Spring Boot Starter Test
- Spring Boot: Framework para criação de aplicações em Java
- PostgreSQL: Banco de dados relacional open-source
- ModelMapper: Biblioteca para mapeamento de objetos em Java

### Instalação
1. Clone o repositório do projeto.
2. Certifique-se de ter o JDK 11 ou superior instalado.
3. Configure o arquivo de banco de dados conforme suas necessidades. Exemplo de configuração:

#Porta do servidor
server.port=8080

#caminho do bando de dados
spring.datasource.url=jdbc:postgresql://localhost:5433/mercadinho

#Usuario do banco de dados
spring.datasource.username=postgres

#senha do banco de dados
spring.datasource.password=admin

#Configuração para indicar o hibernate gerar atualizações automaticamente no Schema
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect

4. Execute o comando `mvn clean install` para compilar e empacotar o projeto.
5. Execute o comando `java -jar target/adriel_projeto04-0.0.1-SNAPSHOT.jar` para iniciar o servidor.

### Uso
1. Acesse o servidor em `http://localhost:8080`.
2. Utilize as funcionalidades disponíveis na aplicação.

## Como contribuir

Você pode contribuir com este projeto de várias formas, como:

- Reportando problemas
- Adicionando novas funcionalidades
- Corrigindo bugs
- Melhorando a documentação

Para contribuir, basta seguir os seguintes passos:

1. Faça um fork do projeto
2. Crie uma nova branch para sua feature (`git checkout -b feature/nome-da-sua-feature`)
3. Faça as alterações necessárias
4. Commite suas alterações (`git commit -m 'Adiciona nova feature'`)
5. Faça um push para a branch (`git push origin feature/nome-da-sua-feature`)
6. Abra um pull request


### Créditos
- Spring Boot: https://spring.io/projects/spring-boot
- PostgreSQL: https://www.postgresql.org/
- ModelMapper: http://modelmapper.org/