Microsservices - Java + Spring + RabbitMQ + PostgreSQL

Example application.properties:

USERS

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


ATENDIMENTO

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
