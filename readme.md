<p align="right"><img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/></p>

# AmaStore Backend

Bem-vindo ao projeto **AmaStore**, o backend de um e-commerce desenvolvido para fornecer uma experiência robusta e escalável, utilizando uma arquitetura de microsserviços.

## Visão Geral

**AmaStore** é uma API backend para um e-commerce, construída com **Java** e **Spring Framework**. Este projeto emprega **microsserviços** para gerenciar diferentes partes do sistema, proporcionando flexibilidade, independência de desenvolvimento e facilidade de escalabilidade.

## Tecnologias Utilizadas

- **Java**
- **Spring (Boot, WEB, Data JPA)**
- **Docker** (para containerização)
- **PostgreSQL** e **MySQL** (para persistência de dados)

## Estrutura de Microserviços

A arquitetura do AmaStore é dividida nos seguintes microserviços:

1. **Users**: Gerencia os dados e autenticação dos usuários.
2. **Products**: Lida com o catálogo de produtos, incluindo detalhes de cada item.
3. **Estoque**: Controla o inventário e monitora a disponibilidade dos produtos.
4. **Financeiro**: Gerencia o fluxo financeiro, incluindo pagamentos e faturas.

Cada microserviço é independente, o que permite o desenvolvimento, implantação e manutenção modular.

## Banco de Dados

- **PostgreSQL** e **MySQL**: Utilizados para armazenamento de dados, fornecendo robustez e confiabilidade para o backend do AmaStore.

## Containerização

O projeto utiliza **Docker** para a containerização, facilitando a execução e o ambiente de desenvolvimento. Cada microserviço possui seu próprio contêiner, permitindo uma escalabilidade e integração contínuas.

## Desenho de Arquitetura:





# Comandos Docker 

### Subir uma nova máquina com os bancos de dados configurados no docker-compose.yml
```
docker compose up
```

### Verificar o status e os ID dos containers
```
docker ps
```

### Matar um container específico
```
docker kill id-container
```

### Excluir resquícios de containers, volumes e redes parados
```
docker system prune --volumes
```

### Iniciar um container
```
docker start id-container
```

### Parar um container
```
docker stop id-container
```

### Reiniciar um container
```
docker restart id-container
```

### Remover um container parado
```
docker rm id-container
```

### Verificar logs de um container
```
docker logs id-container
```

### Acessar o terminal de um container em execução
```
docker exec -it id-container /bin/bash
```
