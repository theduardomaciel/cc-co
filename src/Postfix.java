import java.io.*;

class Parser {
    static int lookahead;

    public Parser() throws IOException {
        lookahead = System.in.read(); // Lê o primeiro caractere da entrada
    }

    // Analisa e converte uma expressão aritmética simples de notação infixa para pós-fixa.
    // Exemplo: "3+4-2" se torna "34+2-"
    void expr() throws IOException {
        // Processa o primeiro termo (número)
        term();

        // Processa operadores '+' ou '-' seguidos de termos
        while (true) {
            if (lookahead == '+') {
                // Se encontrar '+', consome o operador, processa o próximo termo e escreve '+' na saída
                match('+'); term(); System.out.write('+');
            } else if (lookahead == '-') {
                // Se encontrar '-', consome o operador, processa o próximo termo e escreve '-' na saída
                match('-'); term(); System.out.write('-');
            } else return; // Se não houver mais operadores, encerra o processamento
        }
    }

    void term() throws IOException {
        // Se o próximo caractere for um dígito, consome-o e escreve na saída
        if (Character.isDigit((char) lookahead)) {
            System.out.write((char) lookahead); match(lookahead);
        } else {
            throw new Error("Syntax Error");
        }
    }

    void match(int t) throws IOException {
        // Verifica se o próximo token é o esperado
        if (lookahead == t) {
            lookahead = System.in.read();
        } else {
            throw new Error("Syntax Error");
        }
    }
}

public class Postfix {
    public static void main(String[] args) throws IOException {
        System.out.println("Digite uma expressão em notação infixa (ex: 3+4-2):");

        Parser parse = new Parser();

        // Lê a expressão da entrada padrão e converte para notação pós-fixa
        parse.expr();

        System.out.write('\n');
    }
}