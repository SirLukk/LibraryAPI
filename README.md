# 📖 Library API

Uma API RESTful de gerenciamento de livros construída com Java 21, Spring Boot, arquitetura Hexagonal, JPA, Docker e Terraform para provisionamento em AWS.

---

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3**
* **Arquitetura Hexagonal (Ports and Adapters)**
* **JPA + Hibernate**
* **H2 (desenvolvimento) / RDS (produção)**
* **Lombok**
* **Maven**
* **Docker**
* **Terraform**
* **Git**

---

## ⚙️ Funcionalidades da API

* Cadastrar novo livro
* Listar todos os livros
* Buscar livro por ID
* Buscar livro por autor ou título
* Atualizar livro existente
* Deletar livro

---

## 🌐 Endpoints REST

| Verbo  | Endpoint                        | Descrição                  |
| ------ | ------------------------------- | -------------------------- |
| GET    | `/api/livros`                   | Lista todos os livros      |
| GET    | `/api/livros/{id}`              | Busca livro por ID         |
| GET    | `/api/livros/autor?value=nome`  | Busca livro por autor      |
| GET    | `/api/livros/titulo?value=nome` | Busca livro por título     |
| POST   | `/api/livros`                   | Cria um novo livro         |
| PUT    | `/api/livros/{id}`              | Atualiza dados de um livro |
| DELETE | `/api/livros/{id}`              | Remove um livro            |

---

## 💼 Arquitetura Hexagonal

**Camadas:**

* **Domain:** Regras de negócio (entidade `Livro`)
* **Application:** Interfaces e implementações dos casos de uso (`LivroService`)
* **Adapters:**

  * **Inbound:** Controllers REST
  * **Outbound:** Persistência via `LivroRepository`

---

## 🚫 ID como UUID

Para evitar dependência com frameworks na camada de `domain`, o ID é tratado como `String` e convertido para `UUID` apenas na camada de persistence.

---

## 🧱 Banco de Dados

* H2 usado em ambiente local.
* RDS (PostgreSQL) configurado via Terraform para produção.

---

## 🪨 Como Rodar Localmente

1. Clone o projeto:

```bash
git clone https://github.com/seu-usuario/library-api.git
cd library-api
```

2. Compile e gere o `.jar`:

```bash
./mvnw clean package
```

3. Rode com Java:

```bash
java -jar target/libraryAPI-0.0.1-SNAPSHOT.jar
```

4. Acesse: `http://localhost:8080/swagger-ui/index.html`

---

## 🛠️ Docker

1. Crie a imagem Docker:

```bash
docker build -t library-api .
```

2. Rode o container:

```bash
docker run -p 8080:8080 library-api
```

---

## 🌍 Terraform na AWS

* O projeto inclui infraestrutura para:

  * EC2 com a aplicação
  * RDS (PostgreSQL)
  * Variáveis de ambiente simuladas

1. Entre na pasta `infra/terraform`
2. Configure suas credenciais AWS
3. Rode:

```bash
terraform init
terraform plan
terraform apply
```

---

## 📊 Testes Unitários

* Os testes cobrem a camada de serviço
* Podem ser executados com:

```bash
./mvnw test
```

---

🔧 Melhorias Futuras

Algumas ideias e melhorias planejadas para evoluir o projeto:

✅ Validação de Regras de Negócio: Validações mais robustas no domínio, como ano de publicação não negativo ou maior que o atual.

🛡️ Cobertura de Testes: Aumentar cobertura com testes unitários e de integração usando JUnit e Testcontainers.

🔐 Autenticação e Autorização: Implementar segurança com Spring Security e JWT para proteger endpoints.

📦 Versionamento de API: Suporte a múltiplas versões da API (ex: /api/v1/livros).

🧪 Integração com ferramentas de CI/CD: Automatizar pipeline com GitHub Actions ou GitLab CI.

🧰 Interface Frontend (opcional): Criar uma interface web simples com React ou Angular para consumir a API.

Contribuições e sugestões são bem-vindas! 🚀

## ✅ Contribuições

Contribuições são bem-vindas! Sinta-se livre para abrir issues ou PRs.

---

## © Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
