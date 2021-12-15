package com.letsCode.jogoDaVelha;

public enum TipoDeJogador {
    X('x'), O('o');

    private char tipo;

    TipoDeJogador(char tipo) {
        this.tipo = tipo;
    }
}
