# API de peças de veículo

- API desenvolvida em Java para entrega da academia 1000Devs.
* Instrutor: João Almeida

## ✒️ Autor

* José Alan Vieira Sales
 - E-mail: salesalan854@gmail.com

## 🛠️ Construído com

* P.O.O
* [Hibernate](https://hibernate.org) 
* [Maven](https://maven.apache.org/) 
* [Postgresql](https://www.postgresql.org)
* [Spring](https://spring.io)
* [Postman](https://www.postman.com/product/what-is-postman/)

## ⭐ Breve descrição
* O sistema possui uma entidade com os seguintes atributos:
- 🗜 Peça -> id (int / generatedValue); codBarras (Long, id); nome (String); modelo (do veiculo) (String);
            fabricante (String); precoDeCusto (Double); precoDeVenda (Double); qtdeEstoque (int); categoria (String);


## ⚙️ Operações
* Criar, Listar todos os cadastros, Colsultar, Remover.

* Observações: 
1. Não insira letras no código de barras, (ainda) não há tratativa de erro para isso
2. Não é possível prosseguir com dados nulos (para numericos) ou em branco (para strings)
3. Não é possível criar duas peças com códigos de barra iguais
4. É possível consultar ou remover um registro usando o código de barras
