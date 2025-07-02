# Sistema Academia - Pipeline de Build e Testes

## Objetivo

Este repositório tem como objetivo principal demonstrar a criação de um pipeline automatizado para build e testes utilizando GitHub Actions, focando especialmente na execução de testes unitários para os requisitos do tópico **5) - Recepcionista da academia**.

## Cenário

O projeto é implementado em **Java** e utiliza o **Maven** como ferramenta de build e gerenciamento de dependências. A automação do build e execução dos testes é realizada através do **GitHub Actions**, permitindo integração contínua (CI) e verificações automáticas a cada alteração no código.


## Pipeline com GitHub Actions

- O pipeline é definido no arquivo [`maven.yml`](https://github.com/ArthurVenturi/Sistema-Academia/blob/main/.github/workflows/maven.yml), localizado em `.github/workflows/`.
- A cada push ou pull request na branch `main`, o GitHub Actions executa as etapas de:
  - Checkout do código
  - Configuração do ambiente Java
  - Build do projeto via Maven
  - Execução dos testes unitários
  - Geração dos relatórios de teste

## Workspace Utilizado

- **Build:** O build do projeto utiliza o template **Java with Maeven**.
- **Testes:** A execução dos testes unitários utiliza o [Test Reporter](https://github.com/marketplace/actions/test-reporter) para geração e visualização dos relatórios de teste.
## Testes Unitários

Os testes unitários estão voltados para garantir o correto funcionamento das funcionalidades relacionadas aos processos do recepcionista, descritos no requisito **5)** do documento de requisitos.

## Ferramentas utilizadas

## Links úteis

- [Arquivo de workflow do GitHub Actions (`maven.yml`)](https://github.com/ArthurVenturi/Sistema-Academia/blob/main/.github/workflows/maven.yml)
- [Documentação do GitHub Actions](https://docs.github.com/pt/actions)
- [Documentação do Maven](https://maven.apache.org/)

---
> Este repositório foca apenas na automação de build e testes, servindo como exemplo prático de integração de tecnologias de CI/CD para projetos Java.
