//ManutencaoController.java
package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Manutencao;
import com.example.api.ManutencaoAPI;

public class ManutencaoController {
    private List<Manutencao> manutencoes;
    private int nextId; // Variável para armazenar o próximo ID disponível
    private ManutencaoAPI manutencaoAPI; // Instância da API
    
    public ManutencaoController(){
        manutencoes = new ArrayList<>();
        nextId = 1; // Começar a contagem do ID a partir de 1
        manutencaoAPI = new ManutencaoAPI(); // Criando a instância da API
    }
    
    //Métodos CRUD
    public void createManutencao (Manutencao manutencao) {
        // Gerar ID automaticamente
        manutencao.setId(String.valueOf(nextId));
        nextId++;
        this.manutencoes.add(manutencao);
        manutencaoAPI.postManutencao(manutencao); // Chamar a API para registrar a manutenção
    }
    
    public List<Manutencao> readManutencoes() {
        manutencoes = manutencaoAPI.getManutencoes();
        return manutencoes;
    }

    public void updateManutencao (int posicao, Manutencao manutencao){
       manutencoes.set(posicao,manutencao);
       manutencaoAPI.putManutencao(manutencao.getId(),manutencao);
    }

    public void deleteManutencao (int posicao){
        Manutencao manutencao = manutencoes.get(posicao);
        manutencaoAPI.deleteManutencao(manutencao.getId()); // Chamar a API para excluir a manutenção
        manutencoes.remove(posicao);
    }
}