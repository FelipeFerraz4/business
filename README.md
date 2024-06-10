# Api Business

## Uma API para uma plataforma de gestão empresarial, atualmente sendo um CRUD de usuários com algumas funções adicionais ( lista apenas os usuários ativos e para disabilitar usuário).

## Inicialização do programa, necessários instalação do docker

### Primeiramente é necessário fazer o clone do projeto
````Bash
    https://github.com/FelipeFerraz4/business.git
````

### Em Segundo, devemos criar a imagem do docker (ainda estou aprendendo), executando raiz do projeto os comandos abaixos
````Bash
    ./mvnw clean package -DskipTests
````
````Bash
    docker-compose build
````

### Após isso, devemos rodar o programa, sendo o arquivo de inicialização: 
- src\main\java\com\bluefox\business\BusinessApplication.java

### Para finalizar o projeto, execute esse comando:
````Bash
    docker-compose down
````