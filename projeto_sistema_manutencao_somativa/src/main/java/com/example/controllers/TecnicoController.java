package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.TecnicoAPI;
import com.example.models.Tecnico;

public class TecnicoController {
    private List<Tecnico> tecnicos;
    
    public TecnicoController(){
        tecnicos = new ArrayList<>();
    }
    //
    //Métodos CRUD
    public void createTecnico (Tecnico tecnico) {
        this.tecnicos.add(tecnico);
    }

    public List<Tecnico> readTecnicos() {
        tecnicos = TecnicoAPI.getTecnico();
        return tecnicos;
    }

    public void updateTecnico (int posicao, Tecnico Tecnico){
       tecnicos.set(posicao,Tecnico);
    }

    public void deleteTecnico (int posicao){
        tecnicos.remove(posicao);
    }
}
