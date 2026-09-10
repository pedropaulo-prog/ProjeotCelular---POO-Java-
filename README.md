# Projeto Celular - POO
Atividade realizada em classe no dia **20/08/26**, na aula de Programação Orientada a Objetos, com atualização realizada no dia **10/09/26**.

## Sobre o projeto
Este projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), no qual o objeto escolhido foi um **celular**, representando o aparelho utilizado no mundo real para realizar diversas funções.

A classe criada (`Celular`) possui características como marca, modelo, nível de bateria e volume, além de comportamentos que permitem alterar seu estado.

## Atributos
A classe `Celular` possui os seguintes atributos:

* `marca`: representa a marca do celular.

  * Apple

* `modelo`: representa o modelo do celular.

  * iPhone 17 Pro Max

* `bateria`: representa a porcentagem de bateria do aparelho.

  * Inicia em 0%

* `volume`: representa o nível de volume do aparelho.

  * Inicia em 0

Os atributos são privados (`private`) para proteger o estado do objeto.

## Construtor
Na aula de **10/09/26**, foi criado um construtor para a classe `Celular` e foram escolhidos `marca` e `modelo` como os atributos essenciais para o nascimento do objeto.

```java
public Celular(String marca, String modelo) {
    this.setMarca(marca);
    this.setModelo(modelo);
}
```
O construtor recebe apenas os dois atributos considerados essenciais para a criação do objeto.

A bateria e o volume não são informados no construtor e, por serem atributos do tipo `int`, iniciam com o valor `0`.

## Métodos

### setMarca()

O método `setMarca(String marca)` atribui a marca ao objeto.

```java
public void setMarca(String marca) {
    this.marca = marca;
}
```

### setModelo()

O método `setModelo(String modelo)` atribui o modelo ao objeto.

```java
public void setModelo(String modelo) {
    this.modelo = modelo;
}
```

### aumentarVolume()

O método `aumentarVolume(int quantidade)` aumenta o volume do celular de acordo com a quantidade informada.

Regra de negócio:

* A quantidade deve ser maior que zero.
* O volume não pode ultrapassar 100.

Exemplo:

```java
celular.aumentarVolume(20);
```

### carregarBateria()

O método `carregarBateria(int quantidade)` aumenta a porcentagem de bateria do celular de acordo com a quantidade informada.

Regra de negócio:

* A quantidade deve ser maior que zero.
* A bateria não pode ultrapassar 100%.

Exemplo:

```java
celular.carregarBateria(30);
```

## Testes

O projeto possui testes com valores válidos e inválidos para verificar o funcionamento das regras de negócio. Atualmente, os testes realizados no `Main.java` apresentam os seguintes resultados:

```text
Volume inicial: 0
Volume após aumentar: 20
Volume após tentativa inválida: 70
Bateria inicial: 0
Bateria após carregar: 30
Bateria após tentativa inválida: 80
```
Os valores permanecem dentro do limite de 100 estabelecido pelas regras de negócio.

## Encapsulamento

Os atributos da classe `Celular` são privados (`private`) para proteger o estado do objeto, sendo que não foram criados getters e setters automaticamente para todos os atributos. A bateria, por exemplo, não possui um `setBateria()` público. Sua alteração ocorre por meio do método `carregarBateria()`, que possui condições para impedir valores inválidos.

Dessa forma, o próprio objeto controla como seu estado pode ser alterado.

## Projeto Celular - Pergunta de Reflexão "Clean Code" - Aula 10/09/26

**Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em "Gerar Getters e Setters para tudo" automaticamente na sua IDE? Como as nossas duas decisões acima protegem o sistema de fraudes e falhas de lógica?**

Pensando em um mundo real, apenas gerar "Getter" e "Setter" no código do sistema pode acarretar em um sério problema de informações não reais. Ou seja, nem toda informação do objeto deve ser alterada livremente. Se tivéssemos um setter público para a bateria, mesmo que o atributo fosse privado, uma pessoa poderia simplesmente adicionar 150% de bateria ao objeto, invalidando a lógica do sistema.

Por isso, é muito importante nos atentarmos para que, quando criarmos um atributo privado, não criemos automaticamente um setter público. Quando for necessário alterar um atributo, devemos criar métodos e condições que representem ações reais do objeto que possam ser validadas pelo sistema. Assim, protegemos o sistema contra fraudes e falhas de lógica.

Por exemplo:

```java
public void carregarBateria(int quantidade) {

    if (quantidade > 0 && bateria + quantidade <= 100) {
        bateria = bateria + quantidade;
    }

}
```
Aqui podemos observar que o usuário não pode simplesmente definir qualquer valor para a bateria. Ele informa uma quantidade que deseja adicionar, e o sistema verifica se ela é maior que zero e se a bateria, após o carregamento, não ultrapassará 100%.
 
## Evolução do projeto

### 20/08/26

* Criação da classe `Celular`.
* Definição dos atributos `marca`, `modelo`, `bateria` e `volume`.
* Utilização de atributos privados (`private`).
* Criação do método `aumentarVolume()`.
* Criação do método `carregarBateria()`.
* Implementação das regras para impedir valores inválidos.
* Criação do `Main.java` para testar o funcionamento do objeto.

### 10/09/26

* Criação do construtor da classe `Celular`.
* Definição de `marca` e `modelo` como atributos essenciais para a criação do objeto.
* Alteração do construtor para receber apenas os dois atributos essenciais.
* Utilização de `this.setMarca(marca)` e `this.setModelo(modelo)` no construtor.
* Criação dos métodos `setMarca()` e `setModelo()`.
* Alteração do `Main.java` para utilizar o novo construtor.
* Aplicação dos conceitos de encapsulamento e Clean Code.
* Adição da reflexão sobre getters, setters e proteção contra falhas de lógica.