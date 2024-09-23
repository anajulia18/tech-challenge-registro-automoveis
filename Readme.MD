# Guia de Instalação do Docker

Este guia fornece instruções para instalar o Docker em sistemas operacionais Linux e Windows. Docker é uma plataforma popular para criar, implantar e executar aplicativos em contêineres.

## Índice

- [Introdução](#introdução)
- [Pré-requisitos](#pré-requisitos)
- [Instalação no Linux](#instalação-no-linux)
    - [Ubuntu](#ubuntu)
- [Instalação no Windows](#instalação-no-windows)
    - [Windows 10/11](#windows-1011)
- [Verificação da Instalação](#verificação-da-instalação)
- [Recursos Adicionais](#recursos-adicionais)

## Introdução

Docker é uma ferramenta que permite empacotar aplicativos e suas dependências em contêineres. Contêineres são leves, portáteis e garantem que o aplicativo funcione em qualquer ambiente.

## Pré-requisitos

Antes de instalar o Docker, certifique-se de que:

- Você tem privilégios administrativos no seu sistema.
- Para Windows, a versão 10 ou superior é recomendada.
- Para Linux, um sistema baseado em Debian (Ubuntu) ou Red Hat (CentOS) é recomendado.

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

### Windows
1. Baixar o Docker Desktop

1. Acesse a [página de download do Docker Desktop](https://www.docker.com/products/docker-desktop) no site oficial do Docker.
2. Clique no botão **"Download for Windows"** para baixar o instalador mais recente do Docker Desktop para Windows.

### 2. Executar o Instalador

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
1. Execute o comando na raíz da aplicação: 
``` docker build -t veiculos-container-teste . ```
```Depois rode o comando minikube image load veiculos-container-teste```
2. Feito isso, Rode o comando:
```docker-compose up -d```
3. Feito isso, vá até a pasta k8s e rode o comando: 
``kubectl apply -f app-deployment.yaml``
4. Verifique as pods com o comando
```kubectl get pods```
5. Execute o comando:
``minikube service app-service``
6. Esse comando te dará uma URL para você acessar a POD externamente via Postman
7. Acesse o Swagger/OpenAPI da applicação pelo endpoint: 
<br>```http://{Endereco-Retornado-Pelo-app-service}/swagger-ui/index.html```
    
# Acessando MySQL para recuperar ID de Clientes para efetuar Vendas
1. Execute o comando:
````kubectl get pods ````
2. Encontre o Pod do MySQL
3. Execute o comando:
````kubectl exec -it {POD} -- bash````<br>
````mysql -u root -p````<br>
````admin````<br>
````show databases;````<br>
````use fiap;````<br>
````show tables;````<br>
````select * from tb_cliente;````<br>
