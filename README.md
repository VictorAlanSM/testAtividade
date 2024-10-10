## Como rodar o projeto

### o projeto foi feito separado em microserviços.

- greenway-sd: microsserviço de descoberta de serviços
- greenway-gateway: microsserviço de gateway
- greenway-main: microsserviço principal, contendo os endpoints de CRUD para usuarios e coletas
- greenway-mail: microsserviço de envio de notificações ao usuario via email

### Para rodar o projeto, siga os passos abaixo:

- Na pasta raiz do projeto (greenway-app), terá um docker compose que irá subir todos as dependências e microsserviços necessários para o projeto, basta rodar o comando abaixo para iniciar os serviços:
    ```bash 
    docker-compose up -d
    ```
    
- Após subir os serviços, as aplicações irão iniciar e será criado um usuario admin no banco de dados, ele será utilizado para realizar o primeiro login na aplicação e para criar um novo usuario com a role user para testes.
  **importante criar o seu usuario informando um email válido para que possa verificar o envio do email de notificação**

    
- Na mesma pasta irei deixar o arquivo "**_insomnia-trabalho-fiap.json_**" com as rotas da aplicação, basta importar o arquivo no insomnia e utilizar as rotas para testar a aplicação.


- Verifique nas rotas os ids utilizados nas requisições para garantir que os dados estão sendo passados corretamente para evitar erros.

- Para conectar no banco de dados localmente basta cadastrar a conexão no DBeaver com as seguintes informações:
    - Host: localhost
    - Port: 5432
    - Database: greenway_db
    - User: postgres
    - Password: postgres