package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Manutencao;

import java.util.ArrayList;
import java.util.List;
public class ManutencaoAPI {
    public static List<Manutencao> getManutencao(){
        String json = ApiConnection.getData("manutencao");
        List<Manutencao> manutencoes = new ArrayList<>();

        if(json != null){
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Manutencao manutencao = new Manutencao(
                    jsonObject.getInt("id"),
                    jsonObject.getInt("maquinaId"),
                    jsonObject.getString("data"),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getInt("tempoDeParada"),
                    jsonObject.getInt("tecnicoId"),
                    jsonObject.getString("observacoes")
                );
                manutencoes.add(manutencao);
            }
        }
        return manutencoes;
    }
}
