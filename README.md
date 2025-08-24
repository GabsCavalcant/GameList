
<p align="center">
<img src="https://spring.io/img/og-spring.png" alt="Capa do Projeto DSList" width="400"/>
</p>

<h1 align="center">DSList - API para Organização de Games</h1>

<p align="center">
DSList é um projeto de API RESTful desenvolvido em Java com Spring Boot, projetado para criar e organizar listas de games. A aplicação permite a consulta de games, listas e o gerenciamento da posição dos games dentro de cada lista.
</p>

<p align="center">
<a href="#-tabela-de-conteúdos">Ver Conteúdo</a> •
<a href="https://www.google.com/search?q=%23-como-executar-o-projeto">Como Executar</a> •
<a href="https://www.google.com/search?q=%23-tecnologias-utilizadas">Tecnologias</a>
</p>

<p align="center">
<img src="https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java" alt="Java 17">
<img src="https://img.shields.io/badge/Spring_Boot-3.1.2-green?style=for-the-badge&logo=spring" alt="Spring Boot">
<img src="https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql" alt="PostgreSQL">
<img src="https://img.shields.io/badge/Docker-24-blue?style=for-the-badge&logo=docker" alt="Docker">
</p>

📋 Tabela de Conteúdos
Visão Geral

Tecnologias Utilizadas

Como Executar o Projeto

Pré-requisitos

Executando com Docker (Recomendado)

Executando Localmente

Estrutura do Banco de Dados

Configuração de CORS

Agradecimentos

📖 Visão Geral
A API DSList fornece endpoints para:

Listar todos os games cadastrados.

Buscar games por uma lista específica, ordenados por sua posição.

Mover a posição de um game dentro de uma lista.

Listar todas as listas de games.

A aplicação é construída seguindo as melhores práticas de desenvolvimento, com uma arquitetura em camadas (Controller, Service, Repository) e DTOs para transferência de dados.

🚀 Tecnologias Utilizadas
Abaixo estão as principais tecnologias e ferramentas utilizadas no desenvolvimento do DSList:

Backend	Banco de Dados	Ambiente

Exportar para as Planilhas
⚙️ Como Executar o Projeto
Siga os passos abaixo para configurar e executar a aplicação em seu ambiente.

Pré-requisitos
JDK 17 ou superior

Maven

Git

Docker e Docker Compose

Executando com Docker (Recomendado)
Clone o repositório:

Bash

git clone https://github.com/seu-usuario/dslist.git
cd dslist
Crie e execute o docker-compose.yml:

<details>
<summary>Clique para ver o código do docker-compose.yml</summary>

YAML

version: '3.8'
services:
  postgres:
    image: postgres:15.1
    container_name: dslist-postgres
    ports:
      - "5432:5432"
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=1234567
      - POSTGRES_DB=dscatalog
    volumes:
      - pgdata:/data/postgres

  pgadmin:
    image: dpage/pgadmin4:6.17
    container_name: dslist-pgadmin
    ports:
      - "80:80"
    environment:
      - PGADMIN_DEFAULT_EMAIL=admin@admin.com
      - PGADMIN_DEFAULT_PASSWORD=admin
    depends_on:
      - postgres

volumes:
  pgdata:
</details>

Com o arquivo salvo, suba os contêineres:

Bash

docker-compose up -d
Execute a aplicação Spring Boot:

Bash

mvn spring-boot:run
Executando Localmente
Clone o repositório e configure o PostgreSQL localmente com um banco de dados chamado dscatalog.

Ajuste as credenciais no arquivo src/main/resources/application-dev.properties se necessário.

Execute a aplicação:

Bash

mvn spring-boot:run -Dspring-boot.run.profiles=dev
🗃️ Estrutura do Banco de Dados
O modelo de domínio é composto por três entidades principais: tb_game, tb_game_list e tb_belonging.

<details>
<summary>Clique para ver o script de população inicial (import.sql)</summary>

SQL

INSERT INTO tb_game_list (name) VALUES ('Aventura e RPG');
INSERT INTO tb_game_list (name) VALUES ('Jogos de plataforma');

INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Mass Effect Trilogy', 4.8, 2012, 'Role-playing (RPG), Shooter', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png', 'Lorem ipsum dolor sit amet...', 'Lorem ipsum dolor sit amet...');
-- (restante dos inserts de games)

INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 1, 0);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 2, 1);
-- (restante dos inserts de belonging)
</details>

<img width="1041" height="436" alt="image" src="https://github.com/user-attachments/assets/2882b2ed-25cd-4d11-a579-735b786b5d47" />


🌐 Configuração de CORS
As origens permitidas para requisições front-end são configuradas via variável de ambiente CORS_ORIGINS ou no arquivo application.properties, permitindo por padrão http://localhost:5173 e http://localhost:3000.

🙏 Agradecimentos
Agradecimentos à equipe da DevSuperior pelo excelente material e didática no curso Intensivão Java Spring.
