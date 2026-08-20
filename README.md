# Projeto Celular - POO
Atividade realizada em classe no dia 20/08/26, na aula de Programação de objeto orientado

## Sobre o projeto

Este projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), no qual o objeto escolhido foi um **celular**. Ele representa o aparelho utilizado no mundo real para realizar diversas funções. 

A classe criada (`Celular`) possui características como marca, modelo, nível de bateria e volume, além de comportamentos que permitem alterar seu estado.

## Atributos

A classe `Celular` possui os seguintes atributos:

* `marca`: representa a marca do celular.
 - Apple
* `modelo`: representa o modelo do celular.
 - Iphone 17 Pro Max
* `bateria`: representa a porcentagem de bateria do aparelho.
 - Porcentagem de bateria em 50%
* `volume`: representa o nível de volume do aparelho.
 - Nível de volume em 40%

Os atributos são privados (`private`) para proteger o estado do objeto.

## Métodos

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

O projeto possui testes com valores válidos e inválidos para verificar o funcionamento das regras de negócio. Portanto, foram testadas situações em que o volume e a bateria podem ser aumentados normalmente, assim como situações em que o valor ultrapassaria 100. Assim, quando um valor inválido é informado, o estado do objeto não é alterado, pois foi utilizada a estrutura `if` para impedir valores que deixariam o objeto inconsistente.

## Como executar

Para executar o projeto, basta executar o arquivo `Main.java`. Após, o arquivo `Main.java` instancia um objeto da classe `Celular` e realiza os testes dos métodos `aumentarVolume()` e `carregarBateria()`.
