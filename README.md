# Biblioteca API

API REST simples para gerenciamento de livros, permitindo criar, consultar, editar e deletar livros, além de filtrar livros por autor.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok

## Documentação da API

### Salvar um livro

```
POST /books
```

```json
{
  "title": "Título do livro",
  "author": "Nome do autor",
  "year": 2020,
  "available": true
}
```

### Retorna dados de um livro

```
GET /books/{id}
```

| Parâmetro | Tipo     | Descrição                                 |
|-----------|----------|--------------------------------------------|
| `id`      | Integer  | **Obrigatório.** O ID do livro que você quer buscar. |

### Atualizar dados do livro

```
PUT /books/{id}
```

```json
{
  "title": "Título do livro",
  "author": "Nome do autor",
  "year": 2020,
  "available": true
}
```

### Deletar livro

```
DELETE /books/{id}
```

| Parâmetro | Tipo     | Descrição                                 |
|-----------|----------|--------------------------------------------|
| `id`      | Integer  | **Obrigatório.** O ID do livro que você quer deletar. |

### Buscar livros por autor

```
GET /books/by-author?author=NomeDoAutor
```

| Parâmetro | Tipo    | Descrição                                 |
|-----------|---------|--------------------------------------------|
| `author`  | String  | Opcional. Filtra livros pelo nome do autor. |

### Buscar todos os livros

```
GET /books/
