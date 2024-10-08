# 💻 Register Clients - API para cadastro de clientes

#### 🤓 Este projeto é um sistema para registro de clientes, construído com Spring Boot e PostgreSQL. Ele permite que os usuários cadastrem e gerenciem informações de clientes.

## 👨‍💻 Pré-requisitos

### 🔎 Antes de executar o projeto, você precisará ter as seguintes ferramentas instaladas:

- [Docker](https://www.docker.com/get-started) (versão 20.10 ou superior)
- [Docker Compose](https://docs.docker.com/compose/) (versão 1.25 ou superior)

## ⚙️ Configuração do Projeto

* **Clone o repositório:**

   ```
   git clone https://github.com/matheusaugusto98521/register-clients.git
   ```

* **Vá para a raíz do projeto**

```
    cd register-clients
```

* **Inicie os containers**

```
    docker-compose up --build
```

### ↘️ Rotas disponíveis da API

* **Mostrar clientes cadastrados:**
```
    http://localhost:8090/client/
```

* **Cadastrar cliente:**
```
    http://localhost:8090/client/register
```

* **Atualizar informações de um cliente:**
```
    http://localhost:8090/client/update?idClient=
```

* **Deletar cliente**
```
    http://localhost:8090/client/delete?idClient=
```

* **Procurar cliente pelo id:**
```
    http://localhost:8090/client/find-by-id?idClient=
```

## 👨‍💻 Contribuições

### 📚 Contribuições são bem-vindas! Se você deseja contribuir para este projeto, siga estas etapas:

* **Fork o repositório**: *clique no botão "Fork" no canto superior direito da página do repositório.*

* **Clone o repositório**: 
   ```
    git clone https://github.com/matheusaugusto98521/register-clients.git
   ```

* **Crie um nova branch:**
```
    git checkout -b nome-da-branch-contribuicao
```

* **Faça suas alterações e as adicione:**
```
    git add .
```

* **Commit das alterações:**
```
    git commit -m "Descrição da minha contribuição"
```

* **Envie ao repositório:**
```
    git push origin nome-da-branch-contribuicao
```

* **Abra um Pull Request:** *Vá para a página do repositório original e clique em "New Pull Request"*



## 📙 Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](https://github.com/matheusaugusto98521/register-clients/blob/main/LICENSE) para detalhes.

#### 🤓 Para qualquer outra observação, ficarei feliz em resolver, deixe sua observação na aba ***Issues***


