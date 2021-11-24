# microservice---saqueDeposito
Este projeto é um microservice simples desenvolvido com a tecnologia Spring Boot utilizando Maven e API Rest, onde o usuário consegue efetuar saques, depósitos e transferências através dessa API.

Obs: Este projeto só faz sentido executando juntamente com os outros 4 serviços
   - [Carteira](https://github.com/GustavoCSchmitz/microservice---carteira)
   - [Pagamentos](https://github.com/GustavoCSchmitz/microservice---pagamentos)
   - [Eureka Server](https://github.com/GustavoCSchmitz/microservice---eureka)
   - [Usuários]()


### Requisitos de API e instruções para execução
 - Java 8
 - Maven 3 para construir o aplicativo.
 - Abrir na pasta raíz do projeto e executar o comando:
 
      `mvn clean install`
 - Após a instalação, subir o projeto com o comando:
       
      `mvn spring-boot:run`
      
### API endpoint
  - Depósito
     - [http://localhost:8080/deposito]()
     - Deve ser inserido um json, semelhante ao exemplo abaixo:
     ```
     {
       "valor": 550.0,
       "carteira":{
           "titular": "Gustavo"
       }
     }
     ```
      - Todos os campos são obrigatórios
   
   - Saque
     - [http://localhost:8080/saque]()
     - Deve ser inserido um json, semelhante ao exemplo abaixo:
     ```
     {
       "valor": 550.0,
       "carteira":{
           "titular": "Gustavo"
       }
     }
     ```
      - Todos os campos são obrigatórios


   - Transferência
     - [http://localhost:8080/transferencia]()
     - Deve ser inserido um json, semelhante ao exemplo abaixo:
     ```
     {
       "valor": 400.0,
       "origem":{
           "titular": "Gustavo"
       },
       "destino":{
          "titular": "Larissa"
       }
     }
     ```
      - Todos os campos são obrigatórios


 

 
