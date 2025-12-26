# FireAlert 🌲🔥

O **FireAlert** é um sistema de monitorização e gestão de alertas de incêndio para áreas florestais. A aplicação permite o registo de áreas protegidas, a gestão de utilizadores e brigadistas, e o controlo centralizado de incidentes com diferentes níveis de prioridade e estados de resolução.

## 🚀 Tecnologias Utilizadas

### Backend & Core
* **Java 21**: Versão da linguagem utilizada.
* **Spring Boot 3.5.7**: Framework base para a construção da aplicação.
* **Spring Data JPA**: Abstração de persistência de dados.
* **Flyway**: Gestão de migrações e versionamento da base de dados.
* **Log4j2 + LMAX Disruptor**: Sistema de logging assíncrono de alta performance.

### Frontend & UI
* **Thymeleaf**: Motor de templates para renderização do lado do servidor.
* **HTMX**: Utilizado para criar interfaces dinâmicas com atualizações parciais sem recarregar a página.
* **Alpine.js**: Framework leve para comportamento reativo no cliente.
* **CSS Customizado**: Estilização baseada em ficheiros locais (`style.css` e `input.css`).

### Base de Dados
* **PostgreSQL**: Base de dados relacional utilizada para armazenamento persistente.

## 📋 Funcionalidades do Sistema

O sistema está organizado nos seguintes módulos principais:

* **Gestão de Florestas**: Registo de nome e localização das áreas florestais.
* **Cadastro de Pessoas**: Gestão de indivíduos (nome, CPF, telefone) vinculados a uma floresta específica, com distinção de tipo de utilizador.
* **Controlo de Alertas**: Registo de incidentes com descrição, nível de gravidade e status do alerta.
* **Relatórios**: Geração e visualização de relatórios baseados em filtros para impressão.

## ⚙️ Configuração do Ambiente

### Pré-requisitos
* **Java 21**
* **Maven**
* **PostgreSQL**

### Configuração da Base de Dados
A aplicação utiliza o Flyway para criar automaticamente o esquema. As credenciais padrão definidas em `application.properties` são:
* **URL**: `jdbc:postgresql://localhost:5432/firealert_db`
* **Username**: `postgres`
* **Password**: `admin`

### Como Executar
1. Certifique-se de que o PostgreSQL está a correr e que a base de dados `firealert_db` foi criada.
2. Na raiz do projeto, execute:
   ```bash
   mvn spring-boot:run
