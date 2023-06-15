# Sistema de Empréstimo de Ferramentas para Amigos

Este é um sistema de empréstimo de ferramentas para amigos, desenvolvido em Java e utilizando o MySQL como banco de dados. O sistema permite cadastrar amigos, cadastrar ferramentas, realizar empréstimos, realizar a devolução das ferramentas emprestadas e oferece alguns relatórios e funcionalidades adicionais.

## 🛠 Pré-requisitos

Antes de executar o sistema, certifique-se de ter instalado os seguintes componentes:

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [NetBeans IDE](https://netbeans.apache.org/download/index.html)
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)

## Configuração do Banco de Dados

1. Clone o projeto para o seu ambiente local.
2. Abra o MySQL Workbench e execute o seguinte script para criar o banco de dados e as tabelas necessárias:

```sql
CREATE schema provaa3;
USE provaa3;

CREATE TABLE IF NOT EXISTS `provaa3`.`tb_ferramenta` (
  `idferramenta` INT NOT NULL auto_increment,
  `nomeFerramenta` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `custo` DOUBLE NOT NULL,
  PRIMARY KEY (`idferramenta`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `provaa3`.`tb_amigo` (
  `idamigo` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idamigo`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `provaa3`.`tb_emprestimo` (
  `idemprestimo` INT NOT NULL auto_increment,
  `dataEmprestimo` DATE NOT NULL,
  `dataEntregaPrevista` DATE NOT NULL,
  PRIMARY KEY (`idemprestimo`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `provaa3`.`tb_historico` (
  `idhistorico` INT NOT NULL auto_increment,
  `amigo_idamigo` INT NOT NULL,
  `ferramenta_idferramenta` INT NOT NULL,
  `emprestimo_idemprestimo` INT NOT NULL,
  `dataEntregaEfetiva` DATE NULL,
  PRIMARY KEY (`idhistorico`),
  INDEX `fk_historico_amigo_idx` (`amigo_idamigo` ASC) VISIBLE,
  INDEX `fk_historico_ferramenta1_idx` (`ferramenta_idferramenta` ASC) VISIBLE,
  INDEX `fk_historico_emprestimo1_idx` (`emprestimo_idemprestimo` ASC) VISIBLE,
  CONSTRAINT `fk_historico_amigo`
    FOREIGN KEY (`amigo_idamigo`)
    REFERENCES `provaa3`.`tb_amigo` (`idamigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historico_ferramenta1`
    FOREIGN KEY (`ferramenta_idferramenta`)
    REFERENCES `provaa3`.`tb_ferramenta` (`idferramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historico_emprest

imo1`
    FOREIGN KEY (`emprestimo_idemprestimo`)
    REFERENCES `provaa3`.`tb_emprestimo` (`idemprestimo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
```

3. Acesse os arquivos localizados na pasta DAO do projeto e substitua as informações de conexão com o banco de dados de acordo com o seu ambiente:

```java
// Configurar a conexão
String server = "localhost"; // Caminho do MySQL
String database = "provaa3";
String url = "jdbc:mysql://" + server
            + ":3306/" + database
            + "?useTimezone=true&serverTimezone=UTC";
String user = "root";
String password = "suaSenha";
```

Certifique-se de substituir `server`, `user` e `password` pelas configurações correspondentes ao seu ambiente.

4. Execute o script fornecido no banco de dados para popular a tabela com alguns dados de exemplo.

## ⚙️ Funcionalidades

O sistema possui as seguintes funcionalidades:

- Cadastrar amigo
- Cadastrar ferramenta
- Realizar empréstimo
- Realizar a devolução da ferramenta emprestada
- Relatório de empréstimos ativos
- Relatório de todos os empréstimos
- Relatório de ferramentas
- Agenda integrada do Google

## 🚀 Executando o Projeto

1. Abra o projeto no NetBeans IDE.
2. Certifique-se de que as dependências estão configuradas corretamente.
3. Execute o projeto.

## 👨‍💻 Contribuidores

- [Guilherme Severo](https://github.com/Kazyg)
- [Douglas Costa](https://github.com/DouglasCostaMMII)
- [Giovani](https://github.com/giovanigerci)
- [Camille](https://github.com/hillecammi)
- [Tatiane](https://github.com/Tatihub1)
- [Guilherme](https://github.com/Ignistec)
- [Gabriel]()

