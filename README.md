# Arquitetura de Micro serviços

> Features:
- API Gateway
- Docker composer
- Spring Boot, Spring Cloud e Python Flask
- Service Discovery Client (Spring Cloud Netflix Consul)
- Service Registry server (Consul)
- Balanceamento de carga ( Spring Cloud Feign e Ribbon)

## Requirements
- Docker 17 or newer
- docker-compose 1.17 or newer 

## Running
- docker-compose build
- docker-compose up -d

#### Acesse a página web do servidor de Registro, para visualizar os 2 micro serviços e o API Gateway (http://localhost:8500)

#### Faça algumas chamadas aos serviços disponíveis no API Gateway

- curl http://127.0.0.1:8080/hello/python01
 
- curl http://127.0.0.1:8080/hello/python02

#### Aumente o número de instâncias do micro serviço app2 (docker-compose up -d --scale app2=2)
- Faça várias requisições ao API Gateway ( ab -n20 http://127.0.0.1:8080/hello/python02)
- Verifique que os requests são distribuidos entre as instâncias do app2 (docker-compose logs app2)


