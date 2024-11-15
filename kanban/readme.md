# Projeto Kanban - Gerenciamento de Tarefas

Este projeto tem como objetivo implementar um sistema de gerenciamento de tarefas utilizando uma abordagem baseada em kanban, onde usuários podem cadastrar tarefas, visualizar suas tarefas divididas em colunas e realizar a alteração do status de cada tarefa.

## Funcionalidades

### Cadastro de Usuários
O sistema permite o cadastro de usuários, onde são inseridos os seguintes dados:
- **Nome**: Nome completo do usuário.
- **Email**: Endereço de email do usuário (com validação de formato).
  
Ao concluir o cadastro, o sistema garante que todos os dados sejam inseridos corretamente e exibe uma mensagem de sucesso.

### Cadastro de Tarefas
Os usuários podem criar tarefas, que são associadas ao seu perfil e podem ser divididas em três estados:
- **A fazer**: Tarefas que ainda não foram iniciadas.
- **Fazendo**: Tarefas que estão em andamento.
- **Pronto**: Tarefas concluídas.

Para cadastrar uma nova tarefa, são necessários os seguintes campos:
- **Descrição**: Texto descrevendo a tarefa a ser realizada.
- **Setor**: Setor ou área responsável pela tarefa.
- **Prioridade**: Nível de prioridade da tarefa (baixa, média, alta).
- **Data de Cadastro**: Data de criação da tarefa.

### Visualização de Tarefas
As tarefas cadastradas podem ser visualizadas em três colunas, de acordo com seu status atual:
1. **Tarefas a Fazer**: Exibe as tarefas que ainda precisam ser iniciadas.
2. **Tarefas Fazendo**: Exibe as tarefas em andamento.
3. **Tarefas Prontas**: Exibe as tarefas já concluídas.

Cada tarefa contém informações como descrição, setor, prioridade e o responsável (usuário que cadastrou).

## Diagrama de Entidade-Relacionamento (DER)

![Diagrama ER](path/to/diagrama_ER.jpg)

O diagrama abaixo foi gerado com o Mirmid, representando as entidades do sistema e suas relações:

### Entidades:
- **Usuário**: Contém as informações dos usuários cadastrados.
  - Campos: `id`, `nome`, `email`.
  
- **Tarefa**: Contém as informações das tarefas cadastradas.
  - Campos: `id`, `descricao`, `setor`, `prioridade`, `dataCadastro`, `status`, `usuarioId`.
  - Relacionamento: Cada tarefa é associada a um único usuário.

### Relacionamento:
- **Usuário ↔ Tarefa**: Cada usuário pode cadastrar múltiplas tarefas, enquanto cada tarefa está associada a um único usuário.

## Banco de Dados

### Estrutura do Banco de Dados

```sql
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Tarefa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao TEXT NOT NULL,
    setor VARCHAR(100) NOT NULL,
    prioridade ENUM('baixa', 'média', 'alta') NOT NULL,
    dataCadastro DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('a fazer', 'fazendo', 'pronto') NOT NULL,
    usuarioId INT,
    FOREIGN KEY (usuarioId) REFERENCES Usuario(id)
);
```