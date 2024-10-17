package com.example.api;

import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Falha;

import java.util.ArrayList;
import java.util.List;

public class FalhaAPI {
     public static List<Falha> getFalha() {
        String json = ApiConnection.getData("falha");
        List<Falha> falhas = new ArrayList<>();
        
        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Falha falha = new Falha(
                    jsonObject.getInt("id"),
                    jsonObject.getInt("maquinaId"),
                    LocalDate.parse(jsonObject.getString("data")),
                    jsonObject.getString("problema"),
                    jsonObject.getString("prioridade"),
                    jsonObject.getString("disponibilidade")
                );
                falhas.add(falha);
            }
        }
        return falhas;
    }
    //
    //
    //
    // Método Create
    public void postFalha(Falha falha) {
        // Criar um Objeto Json
        JSONObject falhaObject = new JSONObject();
        falhaObject.put("id", falha.getId());
        falhaObject.put("maquinaId", falha.getMaquinaId());
        falhaObject.put("data", falha.getData());
        falhaObject.put("problema", falha.getProblema());
        falhaObject.put("prioridade", falha.getPrioridade());
        falhaObject.put("operador", falha.getOperador());
    }
    // Método Update (PUT)
    public void putFalha(String id, Falha falha) {
        // Primeiro, verificar se o cadastro existe
        String existingData = ApiConnection.getData("falhas/" + id);

        if (existingData == null || existingData.isEmpty()) {
            System.out.println("Cadastro não encontrado para atualizar.");
            return;
        }

        // Criar um Objeto Json para a atualização
        JSONObject falhaObject = new JSONObject();
        falhaObject.put("id", falha.getId());
        falhaObject.put("maquinaId", falha.getMaquinaId());
        falhaObject.put("data", falha.getData());
        falhaObject.put("problema", falha.getProblema());
        falhaObject.put("prioridade", falha.getPrioridade());
        falhaObject.put("operador", falha.getOperador());
        // Enviar os dados via PUT
        ApiConnection.putData("falhas/" + id, falhaObject.toString());
    }
    // Método Update
    public static boolean updateFalha(Falha falha) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", falha.getId());
        jsonObject.put("maquinaId", falha.getMaquinaId());
        jsonObject.put("data", falha.getData());
        jsonObject.put("problema", falha.getProblema());
        jsonObject.put("prioridade", falha.getPrioridade());
        jsonObject.put("operador", falha.getOperador());

        String endpoint = "falhas/" + falha.getId();
        String response = ApiConnection.putData(endpoint, jsonObject.toString());
        return response != null; // Retorna true se a resposta não for nula (sucesso)
    }
    public static boolean deleteFalha(String id) {
        String endpoint = "falhas/" + id;
        String response = ApiConnection.deleteData(endpoint); // Chama o método correto em ApiConnection
        return response != null; // Retorna true se a resposta não for nula (sucesso)
    }
}
