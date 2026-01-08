Aqui está uma versão **bonita, organizada e profissional** para usar direto no seu **README.md** 🚀

---

# 🧩 Microservices Architecture

**Java · Spring Boot · RabbitMQ · PostgreSQL**

Este projeto demonstra uma arquitetura de **microsserviços** utilizando **Java com Spring Boot**, comunicação assíncrona via **RabbitMQ** e persistência de dados com **PostgreSQL**.

---

## 🏗️ Arquitetura

O sistema é composto por dois microsserviços independentes:

* **Users Service** → Gerenciamento de usuários
* **Atendimento Service** → Gerenciamento de atendimentos

Cada serviço possui:

* Banco de dados próprio (PostgreSQL)
* Configuração independente
* Comunicação via RabbitMQ

---

## 🔧 Tecnologias Utilizadas

* ☕ **Java**
* 🌱 **Spring Boot**
* 🐘 **PostgreSQL**
* 🐇 **RabbitMQ**
* 🧰 **Spring Data JPA**
* 📜 **Spring AMQP**
* 📊 **Logging customizado**

---

## ⚙️ Configurações de Ambiente

### 📌 Users Service (`application.properties`)

```properties
spring.application.name=users
server.port=8081

spring.datasource.url=jdbc:postgresql://localhost:5432/users
spring.datasource.username=postgres
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

logging.level.root=INFO
logging.level.users.service.users=DEBUG
logging.pattern.console=%clr(%d{HH:mm:ss}){faint} %clr(%-5level) %clr(%logger{36}){cyan} - %msg%n

spring.rabbitmq.addresses=
spring.rabbitmq.virtual-host=
spring.rabbitmq.ssl.enabled=true
```

---

### 📌 Atendimento Service (`application.properties`)

```properties
spring.application.name=atendimento

spring.datasource.url=jdbc:postgresql://localhost:5432/atendimentos
spring.datasource.username=postgres
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

logging.level.root=INFO
logging.level.service.atendimento.atendimento=DEBUG
logging.pattern.console=%clr(%d{HH:mm:ss}){faint} %clr(%-5level) %clr(%logger{36}){cyan} - %msg%n

spring.rabbitmq.host=
spring.rabbitmq.port=
spring.rabbitmq.username=
spring.rabbitmq.password=
spring.rabbitmq.virtual-host=
spring.rabbitmq.ssl.enabled=true
```

---

## 📦 Observações Importantes

* 🔒 **Credenciais sensíveis** não devem ser versionadas
  → Utilize `.env`, `application-local.properties` ou variáveis de ambiente.
* 🗄️ Cada microsserviço possui seu **próprio banco de dados**, seguindo boas práticas de microsserviços.
* 📨 A comunicação entre serviços ocorre de forma **assíncrona via RabbitMQ**.

---

## ▶️ Como Executar

1. Suba o **PostgreSQL**
2. Suba o **RabbitMQ**
3. Execute cada microsserviço separadamente
4. Verifique os logs para garantir a comunicação entre eles

---

Só me falar 😄
