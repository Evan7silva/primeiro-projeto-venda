# primeiro-projeto-venda

## 🛒 Sistema de Vendas e Controle de Estoque

# 1️⃣ Planejamento Inicial do Sistema

Antes de abrir o Eclipse ou o VS Code, vamos definir claramente o que o sistema vai fazer.

### 📌 Funcionalidades Principais
- **Cadastro de produtos**: nome, preço, quantidade em estoque, categoria.  
- **Cadastro de clientes**: nome, telefone, CPF.  
- **Registro de vendas**: data, produtos vendidos, valor total.  
- **Controle de estoque**: diminuir quando houver venda, alertar quando acabar.  
- **Listagem e busca**: pesquisar produtos e vendas.  
- **Relatórios simples**: total vendido por dia/mês.  

### 🎯 Público-alvo
- O mercadinho da minha mãe (usuário final provavelmente será apenas ela).

### 🎯 Objetivo
- Rapidez e simplicidade na operação.

---

## 2️⃣ Stack Tecnológica

### 🔹 Back-end
- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA** → comunicação com o banco de dados.  
- **Spring Web** → criação das APIs REST.  
- **Banco de dados**:  
  - H2 (memória, para testes)  
  - Futuramente migrar para MySQL.  
- **Lombok** → reduzir código boilerplate.

### 🔹 Front-end
- **HTML + CSS + JavaScript puro** (para começar simples)  
- **Bootstrap** → estilização rápida e responsiva.  
- **Fetch API** → comunicação com o back-end.
