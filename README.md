# Conversor de Moedas via Console
Oracle One Java Challenge

Este é um programa Java que permite realizar conversões de moedas diretamente no seu terminal. Ele oferece um menu interativo com seis opções de conversão utilizando as taxas de câmbio fornecidas pela "Exchange Rate API". A biblioteca GSON é utilizada para processar a resposta JSON da API.

## Funcionalidades

O programa oferece as seguintes opções de conversão:

1.  Dólar (USD) para Peso argentino (ARS)
2.  Peso argentino (ARS) para Dólar (USD)
3.  Dólar (USD) para Real brasileiro (BRL)
4.  Real brasileiro (BRL) para Dólar (USD)
5.  Dólar (USD) para Peso colombiano (COP)
6.  Peso colombiano (COP) para Dólar (USD)
7.  Sair do programa

Após selecionar uma opção de conversão, o programa solicita que você digite o valor a ser convertido e, em seguida, exibe o resultado da conversão com a taxa de câmbio atual.

## Pré-requisitos

Para executar este programa, você precisará ter:

* **Java Development Kit (JDK)** instalado em seu sistema.
* Uma **chave de API** válida da "Exchange Rate API". Você pode obter uma chave registrando-se no site da API.
* A biblioteca **GSON** da Google.

## Configuração

1.  **Obtenha uma chave da API:**
    * Registre-se no site da [Exchange Rate API](https://www.exchangerate-api.com/).
    * Siga as instruções para obter sua chave de API.

2.  **Substitua a chave no código:**
    * Abra o arquivo `ConversorMoedas.java`.
    * Localize a linha:
        ```java
        private static final String API_KEY = "SUA_CHAVE_DA_API";
        ```
    * Substitua `"SUA_CHAVE_DA_API"` pela sua chave de API real.

3.  **Adicione a dependência do GSON:**

    * **Se você estiver usando Maven:**
        Adicione a seguinte dependência ao seu arquivo `pom.xml`:
        ```xml
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.10.1</version> </dependency>
        ```

    * **Se você estiver usando Gradle:**
        Adicione a seguinte implementação ao seu arquivo `build.gradle`:
        ```gradle
        implementation 'com.google.code.gson:gson:2.10.1' // Use a versão mais recente disponível
        ```

    * **Se você não estiver usando um gerenciador de dependências:**
        * Baixe o arquivo `.jar` mais recente do GSON da [página de releases do GSON](https://github.com/google/gson/releases).
        * Adicione o arquivo `.jar` ao classpath do seu projeto.

## Como Executar

1.  **Compile o código Java:**
    Abra o seu terminal ou prompt de comando, navegue até o diretório onde o arquivo `ConversorMoedas.java` está salvo e execute o seguinte comando:
    ```bash
    javac ConversorMoedas.java
    ```

2.  **Execute o programa:**
    Após a compilação bem-sucedida, execute o programa com o seguinte comando:
    ```bash
    java ConversorMoedas
    ```

    O programa exibirá o menu de opções no seu console. Siga as instruções para realizar as conversões desejadas.

## Tratamento de Erros

O programa inclui um tratamento básico para os seguintes cenários:

* **Opção inválida:** Se você digitar uma opção que não está no menu, o programa informará que a opção é inválida e pedirá para tentar novamente.
* **Erro ao acessar a API:** Se houver um problema ao conectar-se com a "Exchange Rate API" ou ao receber a resposta, uma mensagem de erro será exibida.
* **Moeda de destino não encontrada:** Se a moeda de destino especificada não for encontrada na resposta da API, uma mensagem informando isso será exibida.

## Observações

* As taxas de câmbio fornecidas pela API estão sujeitas a alterações. O programa utiliza as taxas mais recentes disponíveis no momento da requisição.
* Certifique-se de que sua chave de API esteja correta para evitar erros de autenticação.
* Verifique a documentação da "Exchange Rate API" para entender os termos de uso e possíveis limitações da API.

## Autor

[Seu Nome]

Sinta-se à vontade para contribuir com melhorias ou reportar problemas!
