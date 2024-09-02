# Projeto To-Do List

## 1. O que Vamos Fazer
Desenvolver uma aplicação web de To-Do List que permitirá aos usuários criar, visualizar, editar e excluir tarefas. O projeto será desenvolvido utilizando Node.js no backend e React no frontend.

## 2. Escopo Funcional
### Funcionalidades Principais:
- **Criação de Tarefas:** O usuário poderá adicionar novas tarefas à lista.
- **Edição de Tarefas:** O usuário poderá editar as tarefas existentes.
- **Exclusão de Tarefas:** O usuário poderá remover tarefas da lista.
- **Marcar como Concluída:** O usuário poderá marcar as tarefas como concluídas.
- **Visualização de Tarefas:** O usuário poderá visualizar todas as tarefas em uma lista.
- **Filtro de Tarefas:** O usuário poderá filtrar tarefas por status (concluídas ou pendentes).

## 3. Escopo Não Funcional
### Qualidade e Desempenho:
- **Responsividade:** O sistema será responsivo e acessível em dispositivos móveis.
- **Performance:** O carregamento da aplicação deve ocorrer em menos de 3 segundos.
- **Segurança:** Implementação de boas práticas de segurança para proteger dados dos usuários.
- **Escalabilidade:** A arquitetura deve suportar a adição de novas funcionalidades no futuro sem grandes modificações na base existente.
- **Usabilidade:** Interface amigável e intuitiva, com foco na experiência do usuário.

## 4. Objetivos SMART
- **Específico:** Desenvolver uma To-Do List funcional com as funcionalidades básicas (criar, editar, excluir, visualizar e filtrar tarefas).
- **Mensurável:** A aplicação deve estar completamente funcional e acessível em até 3 meses.
- **Atingível:** O projeto será desenvolvido por uma equipe de 2 desenvolvedores usando Node.js e React.
- **Relevante:** A To-Do List é uma aplicação prática e amplamente utilizada, sendo útil tanto para usuários finais quanto como base para estudos e projetos maiores.
- **Temporal:** O projeto será concluído e entregue em 12 semanas a partir do início do desenvolvimento.

## 5. Cronograma
### Diagrama de Gantt

## 6. Análise de Risco
### Possíveis Riscos:
- **Atrasos no Cronograma:** A complexidade do frontend pode exigir mais tempo do que o planejado.
- **Problemas de Integração:** Incompatibilidades entre o frontend (React) e backend (Node.js).
- **Segurança:** Riscos de vulnerabilidades de segurança devido ao manuseio inadequado de dados.
- **Mudanças de Escopo:** Solicitações de novas funcionalidades que podem impactar o tempo de entrega.

### Mitigação:
- **Atrasos no Cronograma:** Realizar sprints semanais para monitoramento contínuo do progresso.
- **Problemas de Integração:** Testes contínuos de integração entre frontend e backend.
- **Segurança:** Implementar medidas de segurança desde o início, como validação de dados e uso de bibliotecas de segurança.
- **Mudanças de Escopo:** Definir claramente os requisitos desde o início e evitar mudanças durante o desenvolvimento.

## 7. Recursos
### Humanos:
- **Desenvolvedor Backend:** Focado no desenvolvimento do servidor e APIs em Node.js.
- **Desenvolvedor Frontend:** Responsável pela criação da interface em React.

### Tecnológicos:
- **Node.js:** Para o desenvolvimento do servidor.
- **React:** Para o desenvolvimento do frontend.
- **MongoDB:** Como banco de dados para armazenar as tarefas.
- **GitHub:** Para controle de versão e colaboração.
- **Heroku/AWS:** Para deploy da aplicação.

## 8. Observações
O escopo deste projeto deve ser mantido atualizado no repositório do GitHub, e qualquer alteração deve ser comunicada à equipe.

```mermaid
gantt
    title Cronograma do Projeto To-Do List
    dateFormat  YYYY-MM-DD
    section Planejamento
    Definição do Escopo           :done,    des1, 2024-09-01,2024-09-03
    Análise de Requisitos         :done,    req1, 2024-09-04,2024-09-06
    Prototipação                  :done,    prot, 2024-09-07,2024-09-10
    section Desenvolvimento Backend
    Configuração do Ambiente      :active,  conf, 2024-09-11,2024-09-12
    Criação das APIs              :active,  api,  2024-09-13,2024-09-20
    Integração com Banco de Dados :         db,   2024-09-21,2024-09-25
    Testes Backend                :         testb,2024-09-26,2024-09-28
    section Desenvolvimento Frontend
    Configuração do Ambiente      :         conf2,2024-09-11,2024-09-12
    Criação de Interfaces         :         ui,   2024-09-13,2024-09-20
    Integração com APIs           :         int,  2024-09-21,2024-09-25
    Testes Frontend               :         testf,2024-09-26,2024-09-28
    section Deploy e Finalização
    Deploy em Ambiente de Produção:         deploy,2024-09-29,2024-09-30
    Entrega Final                 :         entrega,2024-10-01,1d
```

```mermaid
classDiagram
    class Task {
        +String id
        +String title
        +String description
        +Boolean isCompleted
        +Date createdAt
        +Date updatedAt
        +markAsCompleted()
        +updateDetails(title, description)
    }
    
    class User {
        +String id
        +String name
        +String email
        +String password
        +Date createdAt
        +Date updatedAt
        +createTask(title, description)
        +editTask(taskId, title, description)
        +deleteTask(taskId)
        +getTasks()
    }
    
    class AuthService {
        +login(email, password)
        +register(name, email, password)
        +logout()
    }
    
    class TaskService {
        +createTask(userId, title, description)
        +updateTask(userId, taskId, title, description)
        +deleteTask(userId, taskId)
        +getTasks(userId)
        +getTaskById(userId, taskId)
    }
    
    User --> Task : manages
    TaskService --> Task : handles
    AuthService --> User : authenticates
```

```mermaid
flowchart TD
    A[Início] --> B[Login/Registro]
    B --> C{Usuário Autenticado?}
    C -- Sim --> D[Exibir Lista de Tarefas]
    C -- Não --> B[Login/Registro]
    
    D --> E[Criar Nova Tarefa]
    D --> F[Editar Tarefa]
    D --> G[Excluir Tarefa]
    D --> H[Marcar Tarefa como Concluída]
    
    E --> D
    F --> D
    G --> D
    H --> D
    
    D --> I[Logout]
    I --> A[Início]
```
