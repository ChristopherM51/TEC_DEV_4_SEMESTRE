package com.example;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ListExemplo list = new ListExemplo();
        SetExemplo set = new SetExemplo();
        list.adicionarNome("Maria");
        list.adicionarNome("João");
        list.adicionarNome("João");
        list.adicionarNome("Pedro");
        list.listarNomes();
        list.modificarNomeIndex(2, "Carlos");
        list.listarNomes();
        list.deleteNome("João");
        list.listarNomes();
        //
        set.adicionarNome("Maria");
        set.adicionarNome("João");
        set.adicionarNome("Pedro");
        set.listarNomes();
        set.modificarNomeIndex("Pedro", "Carlos");
        set.listarNomes();
        set.deleteNome("João");
        set.listarNomes();
    }
}