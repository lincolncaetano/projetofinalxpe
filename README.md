
---

# Projeto Final: API de Gerenciamento de Produtos

Este projeto é uma API RESTful desenvolvida em **Spring Boot** para gerenciamento de produtos. Ele implementa operações CRUD, busca por nome, contagem de registros e integração com **Swagger** para documentação interativa. Utiliza **MySQL** como banco de dados relacional.

## 📋 Descrição do Projeto

A aplicação permite:
- Cadastrar novos produtos.
- Listar todos os produtos.
- Buscar um produto por ID.
- Buscar produtos por nome.
- Contar o número total de registros.
- Atualizar os dados de um produto.
- Excluir um produto.

### Tecnologias Utilizadas
- **Spring Boot**: Para criação da aplicação.
- **Spring Data JPA**: Para persistência de dados.
- **MySQL**: Banco de dados relacional.
- **Lombok**: Para reduzir a verbosidade do código.
- **SpringDoc OpenAPI**: Para documentação da API via Swagger.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **Java 17** (ou superior) instalado.
- **Maven** instalado.
- Cliente HTTP como **Postman**, **Insomnia** ou **cURL**.

### Configuração do Banco de Dados
O banco de dados MySQL já está configurado no arquivo `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://sql10.freesqldatabase.com:3306/sql10761415
    driverClassName: com.mysql.cj.jdbc.Driver
    username: sql10761415
    password: KlLzkGRWHR
  jpa:
    hibernate:
      ddl-auto: update
```

### Passos para Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd nome-do-repositorio
   ```

3. Compile e execute o projeto com Maven:
   ```bash
   mvn spring-boot:run
   ```

4. A aplicação estará disponível em:
   ```
   http://localhost:8080
   ```

5. Acesse a documentação Swagger em:
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 📚 Endpoints da API

### 1. Listar Todos os Produtos
- **Método**: `GET`
- **Endpoint**: `/produtos`
- **Exemplo de Resposta**:
  ```json
  [
    {
      "id": 1,
      "nome": "Anel de Diamante",
      "descricao": "Anel em ouro 18k com diamante central",
      "preco": 5000.00
    }
  ]
  ```

### 2. Buscar Produto por ID
- **Método**: `GET`
- **Endpoint**: `/produtos/{id}`
- **Exemplo de Resposta**:
  ```json
  {
    "id": 1,
    "nome": "Anel de Diamante",
    "descricao": "Anel em ouro 18k com diamante central",
    "preco": 5000.00
  }
  ```

### 3. Buscar Produtos por Nome
- **Método**: `GET`
- **Endpoint**: `/produtos/buscar?nome={nome}`
- **Exemplo de Resposta**:
  ```json
  [
    {
      "id": 1,
      "nome": "Anel de Diamante",
      "descricao": "Anel em ouro 18k com diamante central",
      "preco": 5000.00
    }
  ]
  ```

### 4. Contar Total de Produtos
- **Método**: `GET`
- **Endpoint**: `/produtos/contar`
- **Exemplo de Resposta**:
  ```json
  5
  ```

### 5. Cadastrar Novo Produto
- **Método**: `POST`
- **Endpoint**: `/produtos`
- **Corpo da Requisição**:
  ```json
  {
    "nome": "Pulseira de Prata",
    "descricao": "Pulseira de prata 925 com detalhes em zircônia",
    "preco": 800.00
  }
  ```

### 6. Atualizar Produto
- **Método**: `PUT`
- **Endpoint**: `/produtos/{id}`
- **Corpo da Requisição**:
  ```json
  {
    "nome": "Pulseira de Prata Atualizada",
    "descricao": "Pulseira de prata 925 com novos detalhes",
    "preco": 850.00
  }
  ```

### 7. Excluir Produto
- **Método**: `DELETE`
- **Endpoint**: `/produtos/{id}`
- **Resposta**: Status `204 No Content`.

---

## 📖 Documentação com Swagger

A API está documentada usando **Swagger (OpenAPI 3.0)**. Para acessar a interface interativa:

1. Execute a aplicação.
2. Acesse:
   ```
   http://localhost:8080/swagger-ui.html
   ```

### Recursos do Swagger:
- Visualize todos os endpoints.
- Teste as requisições diretamente na interface.
- Acesse a especificação OpenAPI em:
  ```
  http://localhost:8080/v3/api-docs
  ```

---

## 🛠️ Estrutura do Projeto

```
src/main/java/br.com.lincolncaetano/projetofinal
├── controller
│   └── ProdutoController.java       # Endpoints da API
├── model
│   └── Produto.java                 # Entidade JPA
├── repository
│   └── ProdutoRepository.java       # Interface de persistência
├── service
│   └── ProdutoService.java          # Lógica de negócio
└── ProdutoApiApplication.java       # Classe principal
```

---

## 🧪 Testes

### Via Swagger
- Acesse `http://localhost:8080/swagger-ui.html` para testar os endpoints interativamente.

### Via Banco de Dados
- Use um cliente MySQL (como MySQL Workbench) para verificar os dados inseridos:
  ```sql
  SELECT * FROM produto;
  ```

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👏 Créditos

Desenvolvido por [Lincoln Caetano Dias](https://github.com/lincolncaetano).

---