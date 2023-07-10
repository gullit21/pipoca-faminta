![postech](https://github.com/jacqueline-oliveira/fiap-techchallenge-fase01/assets/66698429/e9b22e19-503b-48ad-8500-18d0128b763b)


# Tech Challenge: Fase 01

Nesta primeira fase, o objetivo foi iniciar um projeto Web, com interfaces e APIs, para cadastro de Pessoas, Endereços e Eletrodomésticos. O objetivo futuro será concluir um projeto que permita que nossos clientes/usuários façam um monitoramento do consumo de energia de cada aparelho eletrônico de suas residências ou escritórios.

## 🔨 Ferramentas e tecnologias utilizadas

* Java 17
* Maven
* Spring Boot
* Spring Web
* Spring Data Postgresql
* Postman
* IntelliJ
* Git
* GitHub


##  🎯 Descrição das APIs

### [🔗](https://github.com/gullit21/pipoca-faminta/tree/main/techchallenge-api-enderecos) API de Pedido

CRUD completo de cliente. Aplicação executa localmente na porta 8081.

|Verbo| Endpoint        | Descrição                              
|---|-----------------|----------------------------------------|
|GET| /clientes       | Lista todos os clientes cadastrados    |
|GET| /clientes/{cpf} | Retorna um cliente com CPF específico  |	
|POST| /clientes      | Cadastra um novo clientes              |	

#### Exemplos de cadastro:

POST  http://localhost:8080/clientes


```
{
    "cpf": "35103307065",
    "nome": "Gullit Ferreira",
    "email": "gullit@gmail.com"
}
```


#### Exemplo de saída:

Ocorrendo o cadastro ou atualização corretamente, será retornado a representação do recurso já com o id preenchido. Exemplo:

```
{
    "id": 52,
    "cpf": "35103307065",
    "nome": "Gullit Ferreira",
    "email": "gullit@gmail.com"
}
```

CRUD completo de produtos.

|Verbo|Endpoint| Descrição                                           
|---|---|-----------------------------------------------------|
|GET|/produtos| Lista todos os produtos cadastrados                 |
|GET|/produtos/{id}| Retorna um produto com Id específico                |	
|GET|/produtos//categoria/{categoria}| Retorna os produtos com categoria específica        |	
|POST|/produtos| Cadastra um novo produto                            |	
|PUT|/produtos/{id}| Atualiza o cadastro de um produto com Id específico |
|DELETE|/produtos/{id}| Exclui um produto com Id específico                 |	


#### Exemplos de cadastro e/ou atualização:

POST  http://localhost:8080/produtos

PUT   http://localhost:8080/produtos/{id}

```
{
    "nome": "Sorvete de chocolate",
    "categoria": "SOBREMESA",
    "preco": 4.99,
    "descricao": "sorvete de chocolate",
    "urlImagem": "endereco_imagem"
}
```

#### Exemplo de saída:

Ocorrendo o cadastro ou atualização corretamente, será retornado a representação do recurso já com o id preenchido. Exemplo:

```
{
    "id": 162,
    "nome": "Sorvete de chocolate",
    "categoria": "SOBREMESA",
    "preco": 4.99,
    "descricao": "sorvete de chocolate",
    "urlImagem": "endereco_imagem"
}
```

Checkout de pagamento do pedido

|Verbo|Endpoint| Descrição                                    
|---|---|----------------------------------------------|
|POST|/checkout| Realiza o checkout do pedido                 |	


#### Exemplos de cadastro e/ou atualização:

POST  http://localhost:8080/checkout

```
{
    "pedidoId": 302
}
```

#### Exemplo de saída:

Ocorrendo o cadastro ou atualização corretamente, será retornado a representação do recurso já com o id preenchido. Exemplo:

```
{
    "id": 102,
    "pedido": {
        "id": 302,
        "cliente": null,
        "dataConfimacao": null,
        "dataEntrega": null,
        "status": "PAGO",
    },
    "valor": 152.85
}
```