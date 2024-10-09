package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Maquina;
import com.example.api.MaquinaAPI;

public class MaquinaController {
    private List<Maquina> maquinas;
    
    public MaquinaController(){
        maquinas = new ArrayList<>();
    }
    //
    //Métodos CRUD
    public void createMaquina (Maquina maquina) {
        this.maquinas.add(maquina);
    }

    public List<Maquina> readMaquinas() {
        maquinas = MaquinaAPI.getMaquinas();
        return maquinas;
    }

    public void updateMaquina (int posicao, Maquina maquina){
       maquinas.set(posicao,maquina);
    }

    public void deleteMaquina (int posicao){
        maquinas.remove(posicao);
    }
}
