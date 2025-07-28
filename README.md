# 🍻 Sistema de Vendas e Comandas para Bar

Sistema completo para controle de vendas, comandas e produtos em estabelecimentos como bares e restaurantes. Conta com autenticação por perfil, controle de estoque e geração de relatórios. Layout dark, moderno e responsivo.

---

## 🧰 Tecnologias

### 🔙 Backend
- Java 17
- Spring Boot
- Spring Security (JWT)
- JPA / Hibernate
- PostgreSQL

### 🔜 Frontend
- React
- TypeScript
- React Router
- Bootstrap (tema escuro)
- Axios
- React-PDF

---

## 👤 Perfis de Usuário

| Página       | ADMIN | SELLER | SUPER |
|--------------|:-----:|:------:|:-----:|
| /admin       | ✅    | ❌     | ❌    |
| /seller      | ✅    | ✅     | ❌    |
| /products    | ✅    | ❌     | ❌    |
| /register    | ❌    | ❌     | ✅    |
| /sales       | ✅    | ❌     | ❌    |
| /pdf/:id     | ✅    | ✅     | ❌    |

---

## 💡 Funcionalidades

- 🔐 Login com JWT
- 🧑‍💼 Redirecionamento automático por tipo de usuário
- 📦 Cadastro e gerenciamento de produtos
- 🧮 Controle de estoque (entrada e saída)
- 🛒 Comandas e registro de vendas
- 📊 Relatórios por período
- 🧾 Emissão de cupom fiscal (PDF)
- 🎨 Interface dark com layout responsivo

---

## 🚀 Como rodar o projeto

### ✅ Pré-requisitos

- Java 17
- Maven 3.8+
- Node.js 18+
- PostgreSQL

### 🐳 Execução com Docker (Recomendado)

```bash
# Construir e iniciar o container
docker compose up --build

# Parar os serviços
docker compose down

```

### 🖥️ Backend (Spring Boot)
```bash
cd backend
./mvnw clean install
./mvnw spring-boot:run

```

### 💻 Frontend (React)
```bash
cd frontend
npm install
npm run dev

```

### 📁 Estrutura de pastas
```bash
comandas-bar/
│
├── backend/
│   ├── src/
│   └── pom.xml
│
├── frontend/      
│   ├── src/
│   └── package.json
│
├── docs/          
│   └── Documentacao_Tecnica_Sistema_Vendas.pdf
│
└── README.md      

```

### 📄 Licença
Este projeto foi feito para fins de portfólio pessoal e não possui licença pública de uso.
Entre em contato com o autor para mais informações.

### 👨‍💻 Desenvolvedor
Feito com 💻 por João Neves

