package com.letsCode.jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
    
    public static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args) {
        char[][] jogoDaVelha;
        jogoDaVelha = jogoVazio();
        mostrarJogo(jogoDaVelha);
        jogar(jogoDaVelha);
    }
    
    public static char[][] jogoVazio(){
        char[][] jogoDaVelha = new char[3][3];
        for (int linha = 0; linha < jogoDaVelha.length; linha++) {
            for (int coluna = 0; coluna < jogoDaVelha[linha].length; coluna++) {
                jogoDaVelha[linha][coluna] = '-';
            }
        }
        return jogoDaVelha;
    }

    public static void mostrarJogo(char[][] jogoDaVelha){
        for (int i = 0; i < jogoDaVelha.length; i++) {
            indicarLinha(i);
            mostrarLinha(jogoDaVelha[i]);
            System.out.printf("%n");
        }
    }

    public static void mostrarLinha(char[] jogoDaVelha){
        for (int i = 0; i < jogoDaVelha.length; i++) {
            System.out.printf(" %C ", jogoDaVelha[i]);
        }
    }

    public static void indicarLinha(int indice){
        switch (indice){
            case 0:
                System.out.printf("A: ");
                break;
            case 1:
                System.out.printf("B: ");
                break;
            case 2:
                System.out.printf("C: ");
        }
    }
    
    public static void jogar(char[][] jogoDaVelha){
        TipoDeJogador jogador;
        for (int numeroDeJogadas = 0; numeroDeJogadas < 9;) {
            if(numeroDeJogadas % 2 == 0){
                jogador = TipoDeJogador.X;
            }
            else {
                jogador = TipoDeJogador.O;
            }
            System.out.printf("Em que linha deseja jogar %s? DIgite um par de linha coluna EX.: A0%n", jogador);
            String comando = entrada.next();
            comando = tratarEntrada(comando);
            if(comando == Erros.EntradaInválida.name()){
                System.out.println("Erro, entrada inválida");
                System.out.println(comando);
            }
            else {
                int linha = Character.getNumericValue(comando.charAt(0));
                int coluna = Character.getNumericValue(comando.charAt(1));

                if(jogoDaVelha[linha][coluna] == '-'){
                    jogoDaVelha[linha][coluna] = jogador.toString().charAt(0);
                    mostrarJogo(jogoDaVelha);

                    numeroDeJogadas++;
                }
                else {
                    System.out.println("Esta casa já está ocupada");
                }

            }
        }
    }

    public static String tratarEntrada(String comando){
        String comandoTratado;

        if (comando.isBlank() || comando.length() < 2){
            return Erros.EntradaInválida.name();
        }

        char linha = Character.toUpperCase(comando.charAt(0));
        int coluna = Character.getNumericValue(comando.charAt(1));

        if (coluna < 0 || coluna >= 3){
            return Erros.EntradaInválida.name();
        }

        switch (linha){
            case 'A':
                comandoTratado = "0" + comando.charAt(1);
                break;
            case 'B':
                comandoTratado = "1" + comando.charAt(1);
                break;
            case 'C':
                comandoTratado = "2" + comando.charAt(1);
                break;
            default: return Erros.EntradaInválida.name();
        }

        return comandoTratado;
    }
}
