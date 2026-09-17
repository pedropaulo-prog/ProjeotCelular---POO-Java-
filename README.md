# Projeto Celular - POO

Atividade realizada em classe no dia ****20/08/26****, na aula de Programação Orientada a Objetos, o qual será dado continuidade a cada aula até o fim do semestre. Portanto, esse Readme.md irá ser atualizado conforme a evolução do projeto, podendo haver alterações no seu contéudo, bem como remoção de antigas informações que não fazem mais sentido e adição de novas.

## Sobre o projeto

Este projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), no qual o objeto escolhido foi um ****celular****, representando o aparelho utilizado no mundo real para realizar diversas funções.

A classe criada (`Celular`) possui características como marca, modelo, nível de bateria e volume, além de comportamentos que permitem alterar seu estado.

## Atributos

A classe `Celular` possui os seguintes atributos:

* `marca`: representa a marca do celular.

  * Apple

* `modelo`: representa o modelo do celular.

  * iPhone 17 Pro Max

* `bateria`: representa o objeto `Bateria` associado ao celular.

* `volume`: representa o nível de volume do aparelho.

  * Inicia em 0

Os atributos são privados (`private`) para proteger o estado do objeto.

A classe `Bateria` possui o seguinte atributo:

* `porcentagem`: representa a porcentagem de bateria do aparelho.

  * Inicia em 0%

## Construtor

Na aula de ****10/09/26****, foi criado um construtor para a classe `Celular` e foram escolhidos `marca` e `modelo` como os atributos essenciais para o nascimento do objeto.

```java
public Celular(String marca, String modelo) {

    this.setMarca(marca);

    this.setModelo(modelo);

}
```

O construtor recebia apenas os dois atributos considerados essenciais para a criação do objeto.

Na aula de ****17/09/26****, o projeto passou a utilizar uma associação entre as classes `Celular` e `Bateria`. Com isso, o construtor da classe `Celular` foi atualizado para receber também um objeto `Bateria`.

```java
public Celular(String marca, String modelo, Bateria bateria) {
    this.setMarca(marca);
    this.setModelo(modelo);
    this.bateria = bateria;
}
```

Dessa forma, o `Celular` passa a possuir uma `Bateria` como objeto associado.

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

O método `carregarBateria(int quantidade)` solicita que o objeto `Bateria` associado realize o carregamento.

```java
public void carregarBateria(int quantidade) {
    bateria.carregar(quantidade);
}
```

A regra de negócio do carregamento passou a ser responsabilidade da classe `Bateria`, que verifica se a quantidade é maior que zero e se a porcentagem não ultrapassará 100%.

### getBateria()

O método `getBateria()` retorna a porcentagem da bateria por meio do objeto `Bateria` associado.

```java
public int getBateria() {
    return bateria.getPorcentagem();
}
```

### getPorcentagem()

O método `getPorcentagem()` pertence à classe `Bateria` e retorna sua porcentagem atual.

```java
public int getPorcentagem() {
    return porcentagem;
}
```

### carregar()

O método `carregar(int quantidade)` pertence à classe `Bateria` e é responsável por aumentar sua porcentagem.

Regra de negócio:

* A quantidade deve ser maior que zero.
* A porcentagem da bateria não pode ultrapassar 100%.

```java
public void carregar(int quantidade) {
    if (quantidade > 0 && porcentagem + quantidade <= 100) {
        porcentagem = porcentagem + quantidade;
    }
}
```

## Associação entre objetos

Na aula de ****17/09/26****, foi criada uma nova classe chamada `Bateria` para realizar uma associação com a classe `Celular`.

O atributo `bateria` da classe `Celular`, que anteriormente armazenava diretamente um número inteiro, passou a armazenar um objeto da classe `Bateria`.

```java
private Bateria bateria;
```

Essa associação permite que o `Celular` utilize os comportamentos da `Bateria`, enquanto a própria classe `Bateria` fica responsável por controlar sua porcentagem e suas regras de negócio.

No `Main.java`, a associação é criada ao instanciar uma `Bateria` e depois passar esse objeto para o construtor do `Celular`.

```java
Bateria bateria = new Bateria(0);

Celular celular = new Celular(
        "Apple",
        "iPhone 17 Pro Max",
        bateria);
```

## Testes
O projeto possui testes com valores válidos e inválidos para verificar o funcionamento das regras de negócio. Também foi adicionado um teste para verificar o acesso ao objeto `Bateria` associado ao `Celular`.

Atualmente, os testes realizados no `Main.java` apresentam os seguintes resultados:

```text
Volume inicial: 0
Volume após aumentar: 20
Volume após tentativa inválida: 70
Bateria inicial: 0
Bateria após carregar: 30
Bateria após tentativa inválida: 80
Bateria do objeto associado: 80%
```

Os valores permanecem dentro do limite de 100 estabelecido pelas regras de negócio.

## Encapsulamento

Os atributos das classes `Celular` e `Bateria` são privados (`private`) para proteger o estado dos objetos, sendo que não foram criados getters e setters automaticamente para todos os atributos.

A bateria, por exemplo, não possui um `setPorcentagem()` público. Sua alteração ocorre por meio do método `carregar()`, que possui condições para impedir valores inválidos.

Dessa forma, cada objeto controla como seu estado pode ser alterado, mantendo suas próprias responsabilidades e regras de negócio.

## Projeto Celular - Pergunta de Reflexão "Clean Code" - Aula 10/09/26

****Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em "Gerar Getters e Setters para tudo" automaticamente na sua IDE? Como as nossas duas decisões acima protegem o sistema de fraudes e falhas de lógica?****

Pensando em um mundo real, apenas gerar "Getter" e "Setter" no código do sistema pode acarretar em um sério problema de informações não reais. Ou seja, nem toda informação do objeto deve ser alterada livremente. Se tivéssemos um setter público para a bateria, mesmo que o atributo fosse privado, uma pessoa poderia simplesmente adicionar 150% de bateria ao objeto, invalidando a lógica do sistema.

Por isso, é muito importante nos atentarmos para que, quando criarmos um atributo privado, não criemos automaticamente um setter público. Quando for necessário alterar um atributo, devemos criar métodos e condições que representem ações reais do objeto que possam ser validadas pelo sistema. Assim, protegemos o sistema contra fraudes e falhas de lógica.

Por exemplo:

```java
public void carregar(int quantidade) {

    if (quantidade > 0 && porcentagem + quantidade <= 100) {

        porcentagem = porcentagem + quantidade;

    }

}
```

Aqui podemos observar que o usuário não pode simplesmente definir qualquer valor para a bateria. Ele informa uma quantidade que deseja adicionar, e o sistema verifica se ela é maior que zero e se a bateria, após o carregamento, não ultrapassará 100%.

## Projeto Celular - Pergunta de reflexão "Associação entre objetos" - Aula 17/09/26

**"No construtor da Viagem, nós exigimos o objeto inteiro (Passageiro solicitante). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem (String nomeDoPassageiro) em vez do objeto todo?"**

**Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo? Se a Viagem tiver apenas a String "Ana Silva", ela consegue mexer no dinheiro dela?**

Em resumo, não podemos apenar pedir a ``String` do nome no construtor, pois uma `String` guarda apenas o dado e um objeto nos permite acessar os dados + comportamentos e atributos da pessoa. Por exemplo, se uma `Viagem` recebesse apenas a `String` `"Ana Silva"`, ela receberia o nome do passageiro, mas não teria acesso aos atributos do objeto `"Passageiro"` para realizar outras ações, como descontar diretamente do saldo da pessoa.

Sendo assim, neste projeto, o `Celular` passou a ter uma relação com o objeto `Bateria` e ao invés de apenas armazenar um número, a `Bateria` agora é responsável por controlar sua porcentagem e regra de comportamento. Contudo, utilizar o objeto associado permite que cada classe mantenha suas próprias responsabilidades e regras de negócio, deixando o código mais organizado

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

### 17/09/26

* Criação da nova classe `Bateria`.
* Criação do atributo `porcentagem` na classe `Bateria`.
* Criação do construtor da classe `Bateria`.
* Criação do método `getPorcentagem()`.
* Criação do método `carregar()`.
* Associação entre as classes `Celular` e `Bateria`.
* Alteração do atributo `bateria` da classe `Celular` para utilizar um objeto `Bateria`.
* Atualização do construtor de `Celular` para receber um objeto `Bateria`.
* Atualização do método `carregarBateria()` para utilizar o objeto `Bateria` associado.
* Criação de um teste no `Main.java` para imprimir um dado do objeto associado.
* Adição da reflexão sobre associação entre objetos e responsabilidades das classes.
