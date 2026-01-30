# Board CLI (DIO)

Aplicação Java de linha de comando para gerenciar boards e cards (estilo Kanban), com persistência em MySQL e migrações via Liquibase.

## Requisitos
- Java (JDK) 17 ou superior
- MySQL 8+
- Gradle (wrapper incluído)

## Configuração do banco
As credenciais padrão estão em `src/main/java/br/com/dio/persistence/config/ConnectionConfig.java` e `src/main/resources/liquibase.properties`:

- URL: `jdbc:mysql://localhost/board`
- Usuário: `board`
- Senha: `board`

Crie o banco e ajuste usuário/senha se necessário:

```sql
CREATE DATABASE board;
CREATE USER 'board'@'localhost' IDENTIFIED BY 'board';
GRANT ALL PRIVILEGES ON board.* TO 'board'@'localhost';
FLUSH PRIVILEGES;
```

## Como rodar
No Windows (PowerShell):

```powershell
.\gradlew run
```

No Linux/macOS:

```bash
./gradlew run
```

Ao iniciar, o app executa as migrations do Liquibase automaticamente e abre o menu principal.

## Estrutura do projeto
- `src/main/java/br/com/dio/ui`: menus e interação com o usuário
- `src/main/java/br/com/dio/service`: regras de negócio
- `src/main/java/br/com/dio/persistence`: DAOs, entidades e configuração
- `src/main/resources/db/changelog`: migrations do Liquibase

## Observações
- O log do Liquibase é gravado em `liquibase.log` na raiz do projeto.
- Caso altere as credenciais do MySQL, ajuste em **ambos** os arquivos:
  - `src/main/java/br/com/dio/persistence/config/ConnectionConfig.java`
  - `src/main/resources/liquibase.properties`

