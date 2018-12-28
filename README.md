# criarClienteRestSpring
Documentação:

Como executar o projeto:
Na pasta onde foi feito o clone do repositorio:
Execute usando o comando maven: mvn spring-boot: run
Acessar a pagina: http://localhost:8080/hotels 

Como usar os serviços:

Para criar um novo cliente:
POST /rest/hotels – cria um novo cliente:
http://localhost:8080/rest/hotels/ 
{
    "nome": "Inserir nome do cliente",
    "idade": "inserir idade do cliente"
}

Para listar todos os clientes salvos
GET /rest/hotels

Para consultar um cliente por id
GET /rest/hotels/:id

Para alterar um cliente
PUT /rest/hotels/:id

{
    "id": inserir id cliente,
    "nome": "insira nome",
    "idade": "inserir idade",
    "cidade": " ",
    "temperaturaMax": "27.8",
    "temperaturaMin": "17.7"
}

Remover Cliente por id
DELETE /rest/hotels/:id


Ferramentas utilizadas:
Java, Spring Boot, angular.js, maven (ferramenta para automacao de compilacao).

Obs: para inicializar o projeto, ter o java instalado, maven.
