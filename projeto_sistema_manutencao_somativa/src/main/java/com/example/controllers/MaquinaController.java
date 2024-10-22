//MaquinaController.java
package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Maquina;
import com.example.api.MaquinaAPI;

public class MaquinaController {
    private List<Maquina> maquinas;
    private int nextId; // Variável para armazenar o próximo ID disponível
    private MaquinaAPI maquinaAPI; // Instância da API

    public MaquinaController() {
        maquinas = new ArrayList<>();
        nextId = 1; // Começar a contagem do ID a partir de 1
        maquinaAPI = new MaquinaAPI(); // Criando a instância da API
    }

    // Métodos CRUD
    public void createMaquina(Maquina maquina) {
        // Gerar ID automaticamente
        maquina.setId(String.valueOf(nextId));
        nextId++;
        this.maquinas.add(maquina);
        maquinaAPI.postMaquina(maquina); // Chamar a API para registrar a máquina
    }

    public List<Maquina> readMaquinas() {
        maquinas = maquinaAPI.getMaquinas();
        return maquinas;
    }

    public void updateMaquina(int posicao, Maquina maquina) {
        maquinas.set(posicao, maquina);
        maquinaAPI.putMaquina(maquina.getId(), maquina); // Chamando como método de instância
    }

    public void deleteMaquina(int posicao) {
        Maquina maquina = maquinas.get(posicao);
        maquinaAPI.deleteMaquina(maquina.getId()); // Chamando como método de instância
        maquinas.remove(posicao);
    }
}
