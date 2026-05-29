<div align="center">

# 📧 Serviço de Notificação — Microsserviço de Emails e Alertas

Microsserviço desenvolvido com **Spring Boot** responsável pelo envio de notificações e emails automáticos dentro da arquitetura distribuída da plataforma Agenda.

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0-green?style=for-the-badge&logo=springboot)
![SMTP](https://img.shields.io/badge/SMTP-Email_Service-blue?style=for-the-badge)
![Scheduler](https://img.shields.io/badge/Scheduler-CRON-important?style=for-the-badge)
![Docker](https://img.shields.io/badge/Docker-Containerization-2496ED?style=for-the-badge&logo=docker&logoColor=white)

<p>
Microsserviço responsável pelo gerenciamento e envio automatizado de notificações via email para lembretes, alertas e comunicação entre os serviços da plataforma.
</p>

</div>

---

# 📑 Índice

1. [🌱 Sobre o Projeto](#-sobre-o-projeto)
2. [🏗 Arquitetura](#-arquitetura)
3. [💻 Tecnologias Utilizadas](#-tecnologias-utilizadas)
4. [⚡ Funcionalidades](#-funcionalidades)
5. [📨 Fluxo de Notificações](#-fluxo-de-notificações)
6. [🔗 Endpoints](#-endpoints)
7. [📂 Estrutura do Projeto](#-estrutura-do-projeto)
8. [🔐 Segurança & Configurações](#-segurança--configurações)
9. [🚀 Como Executar](#-como-executar)
10. [⚙️ Variáveis de Ambiente](#️-variáveis-de-ambiente)
11. [📘 Swagger](#-swagger)
12. [🐳 Docker](#-docker)
13. [🧠 Decisões Técnicas](#-decisões-técnicas)
14. [🚧 Melhorias Futuras](#-melhorias-futuras)

---

# 🌱 Sobre o Projeto

O **Serviço de Notificação** é um microsserviço dedicado ao envio de emails e alertas automáticos dentro da arquitetura da plataforma Agenda.

Seu principal objetivo é desacoplar o sistema de notificações dos demais serviços da aplicação, permitindo maior escalabilidade, organização e independência operacional.

O microsserviço é responsável por:
- envio de emails
- notificações automáticas
- lembretes agendados
- integração com outros microsserviços
- gerenciamento de comunicação do sistema

---

# 🏗 Arquitetura

O projeto segue arquitetura em camadas e foi desenvolvido para atuar como um serviço independente dentro da arquitetura distribuída da plataforma.

## 📐 Estrutura Arquitetural

```text
Controller
   ↓
Service
   ↓
Email Provider (SMTP)
```

---

## 🔹 Camadas da Aplicação

### 📡 Controller
Responsável pelos endpoints REST relacionados ao envio de notificações.

### 🧠 Service
Contém regras de negócio, envio de emails e agendamentos automáticos.

### 📧 SMTP Provider
Responsável pela comunicação com o servidor de email.

### ⚠️ Exceptions
Tratamento global de erros e falhas no envio.

---

# 💻 Tecnologias Utilizadas

## 🚀 Backend
- Java 17
- Spring Boot 4
- Spring Web
- Spring Mail
- Lombok

## ⏰ Agendamentos
- Spring Scheduler
- CRON Jobs

## 📘 Documentação
- Swagger / OpenAPI

## 🐳 DevOps
- Docker
- Docker Compose

---

# ⚡ Funcionalidades

## 📧 Envio de Emails
- Envio automático de notificações
- Envio de lembretes
- Comunicação entre serviços

---

## ⏰ Agendamento Automático
- Execução de tarefas programadas
- Notificações periódicas
- Processamento via CRON

---

## 🔄 Integração
- Comunicação com BFF
- Integração com microsserviços
- Padronização de respostas HTTP

---

# 📨 Fluxo de Notificações

```text
Usuário / Sistema
        ↓
BFF Agenda
        ↓
Serviço de Notificação
        ↓
Servidor SMTP
        ↓
Email enviado
```

---

# 🔗 Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/email` | Enviar email |
| POST | `/email/lembrete` | Enviar lembrete |
| GET | `/email/status` | Verificar status do serviço |

---

# 📂 Estrutura do Projeto

```bash
src/main/java/com/jefferson/notificacao
│
├── business
│   ├── dto
│   ├── services
│
├── controller
│
├── infrastructure
│   ├── exceptions
│   ├── config
│
└── NotificacaoApplication.java
```

---

# 🔐 Segurança & Configurações

A aplicação possui:
- Configuração SMTP segura
- Validação de payloads
- Tratamento global de exceções
- Separação de responsabilidades
- Configuração de variáveis sensíveis via environment variables

---

# 🚀 Como Executar

## ✅ Pré-requisitos

- Java 17
- Maven
- Docker
- Conta SMTP configurada

---

# 📥 Clonar o Projeto

```bash
git clone <URL_DO_REPOSITORIO>
```

---

# ▶️ Executar Localmente

```bash
./mvnw spring-boot:run
```

---

# 🐳 Executar com Docker

```bash
docker-compose up --build
```

---

# ⚙️ Variáveis de Ambiente

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=SEU_EMAIL
spring.mail.password=SUA_SENHA

server.port=8082
```

---

# 📘 Swagger

Após iniciar a aplicação:

```bash
http://localhost:8082/swagger-ui.html
```

ou

```bash
http://localhost:8082/swagger-ui/index.html
```

---

# 🐳 Docker

O projeto possui:
- Dockerfile
- Docker Compose
- Containerização do microsserviço
- Configuração isolada do ambiente

---

# 🧠 Decisões Técnicas

- Separação do envio de notificações em microsserviço dedicado
- Uso do Spring Mail para simplificar integração SMTP
- Scheduler para automações periódicas
- Arquitetura desacoplada para maior escalabilidade
- Estrutura preparada para comunicação distribuída

---

# 🚧 Melhorias Futuras

- Integração com filas RabbitMQ
- Retry automático de envio
- Templates HTML dinâmicos
- Logs centralizados
- Observabilidade com Prometheus
- Notificações push
- Integração com SMS
- Deploy em cloud

---

# 👨‍💻 Autor

Desenvolvido por Jefferson Gomes.

[![GitHub](https://img.shields.io/badge/GitHub-24292e?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Jeffergs)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)
