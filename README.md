# 🏥 MyAPI - API REST para Gestão Hospitalar

Este projeto é uma **API RESTful** desenvolvida em **Java com Spring Boot**, como parte da formação **Java Backend** no programa [Oracle Next Education (ONE)](https://www.oracle.com/br/education/oracle-next-education/) — uma parceria entre a **Oracle** e a **Alura**.

A aplicação simula funcionalidades de um sistema hospitalar, permitindo operações de CRUD para médicos e pacientes.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Flyway (controle de versão do banco de dados)
- Maven
- Lombok
- H2 / PostgreSQL / MySQL (configurável)
- IntelliJ IDEA / VS Code

---

## 📁 Estrutura do Projeto

```

src/
└── main/
├── java/
│    └── com.mylocal.myhospital.myapi/
│         ├── controller/
│         ├── dto/
│         ├── model/
│         ├── repository/
│         └── MyHospitalApiApplication.java
└── resources/
├── application.properties
└── db/migration/ (scripts SQL via Flyway)

````

---

## ⚙️ Como Executar

1. **Clone o repositório**
   ```bash
   git clone https://github.com/MatheusNRusso/MyAPI.git
   cd MyAPI
````

2. **Configure o banco de dados**

   * Edite o arquivo `application.properties` com as credenciais corretas (ou use o H2 em memória).

3. **Execute a aplicação**

   * Via terminal:

     ```bash
     ./mvnw spring-boot:run
     ```
   * Ou diretamente pela sua IDE (IntelliJ, Eclipse, VS Code).

---

## 📚 Endpoints principais

| Método | Endpoint      | Descrição                   |
| ------ | ------------- | --------------------------- |
| GET    | /medicos      | Lista todos os médicos      |
| POST   | /medicos      | Cadastra um novo médico     |
| PUT    | /medicos/{id} | Atualiza os dados do médico |
| DELETE | /medicos/{id} | Remove um médico            |
| GET    | /pacientes    | Lista todos os pacientes    |
| POST   | /pacientes    | Cadastra um novo paciente   |

> ⚠️ Os endpoints estão sujeitos a alterações conforme o projeto evolui.

---

## 🛠️ Migrações com Flyway

Scripts versionados de banco de dados ficam na pasta:

```
src/main/resources/db/migration/
```

São executados automaticamente ao iniciar a aplicação.

---

## 👨‍💻 Autor

Desenvolvido por [Matheus N Russo](https://github.com/MatheusNRusso)
Projeto integrante do programa **Oracle Next Education (ONE) - Java Backend**

---


