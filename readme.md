# AmaStore Backend

Bem-vindo ao projeto **AmaStore**, o backend de um e-commerce desenvolvido para fornecer uma experiência robusta e escalável, utilizando uma arquitetura de microserviços.

## Visão Geral

**AmaStore** é uma API backend para um e-commerce, construída com **Java** e **Spring Framework**. Este projeto emprega **microserviços** para gerenciar diferentes partes do sistema, proporcionando flexibilidade, independência de desenvolvimento e facilidade de escalabilidade.

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

