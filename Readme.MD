
## Índice

- [Introdução](#introdução)
- [Pré-requisitos](#pré-requisitos)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Guia de Instalação do Docker](#guia-de-instalação-do-docker)
- [Instalação no Linux](#instalação-no-linux)
    - [Ubuntu](#ubuntu)
- [Instalação no Windows](#instalação-no-windows)
    - [Executar o Instalador](#executar-o-instalador)
- [Minikube](#Minikube)
- [Rodando a Aplicação](#rodando-a-aplicação)

- [Endpoints](#endpoints)
    - [POST /clientes](#post-clientes)
    - [POST /veiculos](#post-veiculos)
    - [GET /veiculos/status](#get-veiculosstatuse)
    - [POST /vendas](#post-vendas)
- [Acessando MySQL para recuperar ID de Clientes para efetuar Vendas](#acessando-mysql-para-recuperar-id-de-clientes-para-efetuar-vendas)
- [Collection do Insomnia](#collection-do-insomnia)
# Introdução

Este projeto consiste em uma plataforma para gerenciar a revenda de veículos automotores. A aplicação permite o cadastro, edição, listagem e venda de veículos, além de funcionalidades relacionadas ao gerenciamento do status de pagamento dos mesmos. A solução foi desenvolvida utilizando Spring Boot (versão 3.3.1), documentada com OpenAPI/Swagger, e implementada seguindo os princípios de SOLID e Clean Architecture.

## Pré-requisitos
Antes de começar, certifique-se de ter os seguintes itens instalados:
- JDK 17
- Maven
- Docker
- Kubernetes

Antes de instalar o Docker, certifique-se de que:

- Você tem privilégios administrativos no seu sistema.
- Para Windows, a versão 10 ou superior é recomendada.
- Para Linux, um sistema baseado em Debian (Ubuntu) ou Red Hat (CentOS) é recomendado.



## Estrutura do Projeto
O projeto segue os princípios de Clean Architecture, dividindo as responsabilidades em camadas bem definidas:

- Core (Domínio): Onde ficam as entidades e as regras de negócio.
- Use Cases (Aplicação): Contém a lógica de interação entre as camadas e implementa os casos de uso.
- Adapters (Interface): Contém os controladores e repositórios que fazem a integração com frameworks externos.
- Infrastructure: Implementações de serviços e repositórios, além das configurações de frameworks.


### Tecnologias Utilizadas

- JDK 17
- Maven (para gerenciar dependências do projeto)
- Docker
- Spring Boot 3.3.1
- OpenAPI/Swagger para documentação
- Kubernetes para orquestração de contêineres
- Docker e Docker Compose para automação de build e execução local
- SOLID e Clean Architecture
- MySQL para o banco de dados

# Guia de Instalação do Docker

Este guia fornece instruções para instalar o Docker em sistemas operacionais Linux e Windows. Docker é uma plataforma popular para criar, implantar e executar aplicativos em contêineres.


## Instalação no Linux

### Ubuntu

1. **Atualizar o Índice de Pacotes**

   ```bash
   sudo apt-get update
   sudo apt-get install apt-transport-https ca-certificates curl software-properties-common
   curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
   sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
   sudo apt-get update
   sudo apt-get install docker-ce
   sudo systemctl status docker

## Instalação no Windows
- Baixar o Docker Desktop
- Acesse a [página de download do Docker Desktop](https://www.docker.com/products/docker-desktop) no site oficial do Docker.
- Clique no botão **"Download for Windows"** para baixar o instalador mais recente do Docker Desktop para Windows.

### Executar o Instalador

1. Após o download, localize o arquivo `.exe` baixado e dê um duplo clique para iniciar o assistente de instalação.
2. Siga as instruções no assistente. Durante a instalação, você pode ser solicitado a instalar o WSL 2, caso ainda não esteja instalado.

## Minikube

Minikube é uma ferramenta que facilita o uso de Kubernetes localmente. Ele cria um cluster Kubernetes de nó único em uma máquina local e é ideal para desenvolvimento e testes.

## Linux Ubuntu
```bash
    $ curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
    $ chmod +x minikube-linux-amd64
    $ sudo mv minikube-linux-amd64 /usr/local/bin/minikube
    $ minikube version
    $ minikube start --driver=docker
    $ eval $(minikube -p minikube docker-env)
    $ minikube status
````


## Windows
1. Abra o powershell como administrador e rode os comandos:

```bash
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex "& { $(irm https://chocolatey.org/install.ps1 -UseBasicP) }"
choco install minikube
minikube version
minikube start --driver=docker
minikube docker-env
minikube -p minikube docker-env | Invoke-Expression
```


# Rodando a Aplicação
- Execute o comando na raíz da aplicação:<br>
  ``` docker build -t veiculos-teste-manager2 . ```<br>
-   ```Depois rode o comando minikube image load veiculos-teste-manager2```<br>
- No projeto de Auth rode o comando abaixo:
- ``` docker build -t auth44 . ```<br>
- ```Depois rode o comando minikube image load auth44```<br>
- Feito isso, vá até a pasta k8s e rode o comando:
  ``kubectl apply -f app-deployment.yaml``
- Verifique as pods com o comando
  ```kubectl get pods```
- Execute o comando:<br>
  ``kubectl port-forward svc/auth 9898:9898 ``<br>
  ``kubectl port-forward svc/app 9090:9090 ``<br>
- Acesse o Swagger/OpenAPI da applicação pelo endpoint:
  <br>```http://localhost:9090/swagger-ui/index.html``` Não esqueça do Bearer Token que será mencionado nos passos posteriores.
--http://localhost:9898/auth/register

## Endpoints

### POST /auth/register
Este endpoint salva um novo Cliente. O corpo da requisição deve conter os detalhes do Cliente a ser salvo.

**Request:**
```http
{
  "email": "anajulia@gmail.com",
  "password": "12345",
  "name": "anaju"
  "cpf": "32805040074"
}
```
**Response:**
```http
204 
```

### POST /auth/token
Este endpoint recupera um Token Bearer passando um Body.

**Request:**
```http
{
  "password": "12345",
  "username": "anaju"
}
```
**Response:**
```http
http: 200
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYW1lIiwiaWF0IjoxNzI5ODgzODYxLCJleHAiOjE3Mjk4ODU2NjF9.TS2KTNo2W0tubh-cQJF3WQ86gBITiWQMncViSntYxU0
```

========= ROTAS AUTENTICADAS, LEMBRAR DE PASSAR O BEARER TOKEN =========================
### POST /veiculos
Cadastra um novo veículo para venda.

**Request:**
```http
{
  "marca": "Renault",
  "modelo": "Sandero",
  "ano": "2024-09-02",
  "value": 32000,
  "status": "DISPONIVEL"
}
```
**Response:**
```http
204
```

### GET /veiculos/status
Este endpoint retorna uma lista de veículos com base no status fornecido. O status deve ser uma das opções válidas, como 'DISPONIVEL' ou 'VENDIDO'.
_Ordenada por preço, do mais barato para o mais caro_<br>

**Request:**
```http
DISPONIVEL OU VENDIDO
```
**Response:**
```http
[
  {
    "id": "2801bc32-adb4-4353-9a1d-a09c638f37a1",
    "marca": "Renault",
    "modelo": "Sandero",
    "ano": "2024-09-02",
    "value": 32000,
    "status": "VENDIDO"
  },
  {
    "id": "110b6b5f-1818-4fcf-9e93-1a3aa71b9c89",
    "marca": "honda",
    "modelo": "hrv-c",
    "ano": "2024-09-23",
    "value": 9000000,
    "status": "VENDIDO"
  }
]
```

### POST /vendas
Este endpoint registra uma nova venda de veículo. O corpo da requisição deve conter os detalhes do veículo e do cliente envolvidos na venda.

_**Para encontrar o id_cliente e id_veiculo ver diretamente na tabela.**_

**Request:**
```http
{
  "idVeiculo": "2801bc32-adb4-4353-9a1d-a09c638f37a1",
  "idCliente": "a9dd0a05-c9f2-44a0-9e05-efe5e452efca",
  "valorPago": 32000
}
```

**Response:**
```http
204
```


### PUT /veiculos
Este endpoint Edita um veículo. O corpo da requisição deve conter os detalhes do veículo a ser editado.

_**Para encontrar o id_cliente e id_veiculo ver diretamente na tabela.**_

**Request:**
```http
{
  "marca": "string",
  "modelo": "string",
  "ano": "2024-09-26",
  "value": 0,
  "id": "string"
}
```

**Response:**
```http
204 - Veículo Editado com sucesso
```


### GET /vendas/uuid_venda
Este endpoint permite consultar os detalhes de uma venda de veículo específica. O corpo da requisição deve conter o identificador da venda.

_**Para encontrar o id_cliente e id_veiculo ver diretamente na tabela.**_

**Request:**
```http
uuid da venda
```

**Response:**
```http
{
  "cliente": {
    "id": "33376179-956b-4112-b109-51971c3099c6",
    "cpf": "51690258829"
  },
  "veiculo": {
    "id": "97767981-f022-4dcb-890e-b1cba753e7e3",
    "marca": "Chevrolet",
    "modelo": "Onix",
    "ano": "2021-07-22",
    "value": 85000,
    "status": "VENDIDO"
  },
  "dataDaVenda": "2024-09-26"
}
```

### Acessando MySQL para recuperar ID de Clientes para efetuar Vendas
1. Execute o comando:
   ````kubectl get pods ````
2. Encontre o Pod do MySQL
3. Execute o comando:
   ````kubectl exec -it {POD} -- bash````<br>
   ````mysql -u root -p````<br>
   ````insira a senha: admin````<br>
4. Comandos para rodar: <br>
   ````show databases;````<br>
   ````use fiap;````<br>
   ````show tables;````<br>
   ````select * from tb_cliente;````<br>

# Collection do Insomnia
#### _A collection com todas as requisições se encontram na pasta  'collection' dentro do repositório._
#### _Não esquecer de alterar a variável base_url._

