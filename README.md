# Sistema Modular de Reservas de Salas

Bem-vindo ao repositório de um sistema distribuído para reservas de salas, baseado em microsserviços e tecnologias modernas de backend.

---

## 📦 Componentes do Sistema

- **User Service:** Gerencia usuários do sistema.
- **Sala Service:** Responsável pelo cadastro e consulta de salas.
- **Reserva Service:** Controla as reservas realizadas.
- **API Gateway:** Porta de entrada única para todas as requisições.
- **RabbitMQ:** Mensageria para comunicação assíncrona.
- **Adminer:** Interface web para administração dos bancos de dados.

---

## 🚀 Iniciando o Projeto

1. **Pré-requisitos:**  
   - Docker  
   - Docker Compose

2. **Clone o repositório e acesse a pasta:**
    ```bash
    git clone https://github.com/VitorParente/Reserva_Sala_Microsservices.git
    cd Reserva_Sala_Microsservices
    ```

3. **Suba todos os serviços:**
    ```bash
    docker-compose up --build -d
    ```

---

## 🌐 Endpoints e Portas

| Serviço      | Porta | URL de Acesso                        |
|--------------|-------|--------------------------------------|
| Gateway      | 8080  | http://localhost:8080                |
| User         | 8081  | http://localhost:8081                |
| Sala         | 8082  | http://localhost:8082                |
| Reserva      | 8083  | http://localhost:8083                |
| RabbitMQ     | 15672 | http://localhost:15672 (admin: guest/guest) |
| Adminer      | 8085  | http://localhost:8085                |

---

## 🗄️ Bancos de Dados

Cada microsserviço possui seu próprio banco PostgreSQL, isolado em containers distintos.  
Acesse via Adminer usando as credenciais abaixo:

| Serviço   | Banco         | Usuário   | Senha  | Porta  |
|-----------|--------------|-----------|--------|--------|
| user      | usersdb      | postgres  | admin  | 5433   |
| sala      | salasdb      | postgres  | admin  | 5434   |
| reserva   | reservasdb   | postgres  | admin  | 5435   |

---

## ⚙️ Tecnologias Utilizadas

- **Spring Boot**
- **PostgreSQL**
- **RabbitMQ**
- **Docker & Docker Compose**
- **Adminer**

---

## 📝 Observações

- O sistema utiliza redes Docker customizadas para isolar e conectar os serviços.
- Dados persistem em volumes Docker, mesmo após reinicializações.
- Para dúvidas, sugestões ou problemas, utilize as issues do repositório.

---

## 📁 Estrutura dos Diretórios

```
Reserva_Sala_Microsservices/
│
├── user/         # Microsserviço de usuários
├── sala/         # Microsserviço de salas
├── reserva/      # Microsserviço de reservas
├── gateway/      # API Gateway
├── docker-compose.yml
└── README.md
```

---

## 🔗 Exemplo de Roteamento no Gateway

```properties
spring.cloud.gateway.server.webflux.routes[0].id=user-service
spring.cloud.gateway.server.webflux.routes[0].uri=http://usuarioapp:8081
spring.cloud.gateway.server.webflux.routes[0].predicates[0]=Path=/users/**
spring.cloud.gateway.server.webflux.routes[0].filters[0]=RewritePath=/users/(?<segment>.*), /users/${segment}
```

---
