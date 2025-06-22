
# Pet

Este é um projeto Java que implementa um sistema CRUD (Create, Read, Update, Delete) para gerenciar informações de pets. O código utiliza conceitos avançados de programação orientada a objetos (POO), tratamento de erros, leitura e gravação em arquivos, listas, iterações em listas sem loops tradicionais (usando Streams), e enums para definir as operações do CRUD.

## Funcionalidades

- **Cadastrar novo pet**: Adiciona um novo pet com informações como nome, idade e raça.
- **Alterar os dados do pet cadastrado**: Permite modificar os dados de um pet existente.
- **Deletar um pet cadastrado**: Remove um pet da lista com base em um critério.
- **Listar todos os pets cadastrados**: Exibe todos os pets armazenados.
- **Listar pets por algum critério**: Filtra e exibe pets com base em critérios como idade, nome ou raça.
- **Sair**: Encerra o programa.

## Tecnologias e Conceitos Utilizados

- **Programação Orientada a Objetos (POO)**: Uso de classes como `Pet`, `Pets`, e `MenuOptions` para encapsular dados e comportamentos.
- **Tratamento de Erros**: Implementação de exceções personalizadas em `MenuExceptions` para lidar com erros como entradas inválidas ou acesso a dados nulos.
- **Leitura e Gravação em Arquivos**: Persistência dos dados de pets em arquivos para manter as informações entre execuções.
- **Listas e Streams**: Utilização de `List` para armazenar pets e iterações com Streams para processar a lista sem loops tradicionais.
- **Enums**: Definição de `MenuOptions` para representar as operações do CRUD, garantindo um controle robusto das ações disponíveis.

## Estrutura do Projeto

- `java/application/Program`: Classe principal que inicia o programa.
- `java/entities/`: Pacote com entidades do sistema.
  - `Pet`: Classe que representa um pet com atributos como nome, idade e raça.
  - `Pets`: Classe para gerenciar a coleção de pets.
- `java/enums/`: Pacote com enums.
  - `MenuOptions`: Enum que define as opções do menu (1 a 6).
  - `Sex`: Enum para representar o sexo do pet (se aplicável).
  - `Type`: Enum para representar o tipo de pet (ex.: cachorro, gato).
- `java/exceptions/MenuExceptions`: Pacote com exceções personalizadas para tratamento de erros no menu.
- `java/utils/`: Pacote com utilitários, (não utilizado)
## Como Utilizar o Código

1. **Pré-requisitos**:
   - Instale o [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) versão 8 ou superior.
   - Configure um ambiente de desenvolvimento como IntelliJ IDEA, Eclipse ou use o terminal com `javac` e `java`.

2. **Clonagem do Repositório**:
   - Clone este repositório para o seu ambiente local:
     ```bash
     git clone https://github.com/rhuanbrasil/VetProject
     ```
   - Acesse o diretório do projeto:
     ```bash
     cd VetProject
     ```

3. **Compilação e Execução**:
   - Compile os arquivos Java:
     ```bash
     javac java/application/Program.java
     ```
   - Execute o programa:
     ```bash
     java java.application.Program
     ```

4. **Uso Interativo**:
   - Ao iniciar, o programa exibirá um menu com as opções:
     ```
     1. Cadastrar novo pet
     2. Alterar os dados do pet cadastrado
     3. Deletar um pet cadastrado
     4. Listar todos os pets cadastrados
     5. Listar pets por algum critério (idade, nome, raça)
     6. Sair
     ```
   - Digite o número correspondente à ação desejada e siga as instruções na tela.
   - Os dados serão salvos em arquivo e carregados automaticamente nas próximas execuções.

5. **Exemplo de Uso**:
   - Escolha "1" para cadastrar um pet
   - Escolha "2" para Alterar os dados do pet cadastrado
   - Escolha "3" para Deletar um pet cadastrado
   - Escolha "4" para listar todos os pets cadastrados.
   - Escolha "5" para filtrar e listar com base no filtro
   - Escolha "6" para sair e salvar os dados.

## Considerações

- O programa utiliza tratamento de erros para entradas inválidas, como valores nulos ou opções fora do menu.
- Os dados são persistidos em arquivo, garantindo que as informações não se percam ao encerrar o programa.
- A estrutura baseada em enums e Streams proporciona um código limpo e escalável.

Contribuições são bem-vindas! Abra uma issue ou envie um pull request para melhorias ou correções.
