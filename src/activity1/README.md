# [Atividade: Parser para Expressões Infixadas](./Postfix.java)

Este exercício consiste em ler e compreender o código Java de um Parser (Analisador Sintático) que converte expressões matemáticas infixadas (como `8+3`) para a notação pós-fixada (também chamada de notação polonesa reversa).

O Parser percorre a expressão caractere a caractere, identificando números e operadores, e reorganiza a saída para pós-fixa. Por exemplo, a expressão `8+3` é convertida para `83+`.

### Funcionamento do Parser

O algoritmo utiliza uma variável `lookahead` para armazenar o próximo caractere da entrada. O funcionamento pode ser descrito pelo seguinte pseudocódigo:

```plaintext
VAR lookahead  // armazena o próximo caractere da entrada

FUNÇÃO Parser()
    lookahead ← LER_CARACTERE_DA_ENTRADA()  // lê o primeiro caractere

FUNÇÃO expr()
    term() // processa o primeiro termo (um número)

    // enquanto houver operadores '+' ou '-'
    ENQUANTO VERDADEIRO FAÇA
        SE lookahead = '+' ENTÃO
            match('+')           // consome o operador '+'
            term()               // processa o próximo número
            ESCREVER('+')        // escreve '+' na saída (pós-fixa)
        SENÃO SE lookahead = '-' ENTÃO
            match('-')           // consome o operador '-'
            term()               // processa o próximo número
            ESCREVER('-')        // escreve '-' na saída (pós-fixa)
        SENÃO
            RETORNAR       // encerra quando não há mais operadores
        FIM SE
    FIM ENQUANTO

FUNÇÃO term()
    // Se lookahead for um dígito…
    SE lookahead É DÍGITO ENTÃO
        ESCREVER(lookahead)     // imprime o número na saída
        match(lookahead)        // consome o número
    FIM SE

FUNÇÃO match(t)
    // Verifica se o próximo caractere é o esperado
    SE lookahead = t ENTÃO
        lookahead ← LER_CARACTERE_DA_ENTRADA()
    FIM SE

PROGRAMA PRINCIPAL
    parser ← NOVO Parser()
    parser.expr()               // converte expressão pra pós-fixa
```

### Exemplo de execução para `8+3`

1. `lookahead` recebe `'8'`
2. `term()` escreve `'8'` na saída e consome o caractere
3. `lookahead` agora é `'+'`
4. `match('+')` consome o operador
5. `term()` escreve `'3'` na saída e consome o caractere
6. `lookahead` não é mais operador, encerra o loop
7. Escreve `'+'` na saída

**Saída final:** `83+`

Este algoritmo é útil para tradutores e compiladores, facilitando a avaliação de expressões matemáticas.


