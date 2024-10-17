package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Tecnico;

import java.util.ArrayList;
import java.util.List;

public class TecnicoAPI {
     public static List<Tecnico> getTecnico() {
        String json = ApiConnection.getData("tecnicos");
        List<Tecnico> tecnicos = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Tecnico tecnico = new Tecnico(
                    jsonObject.getString("id"),
                    jsonObject.getString("nome"),
                    jsonObject.getString("especialidade"),
                    jsonObject.getString("disponibilidade")
                );
                tecnicos.add(tecnico);
            }
        }
        return tecnicos;
    }
    // Método Create
    public void postTecnico(Tecnico tecnico) {
        // Criar um Objeto Json
        JSONObject tecnicoObject = new JSONObject();
        tecnicoObject.put("id", tecnico.getId());
        tecnicoObject.put("nome", tecnico.getNome());
        tecnicoObject.put("especialidade", tecnico.getEspecialidade());
        tecnicoObject.put("disponibilidade", tecnico.getDisponibilidade());
        // Enviar os dados via POST
        if (tecnicoObject.length() > 0) { // Verifica se o JSON tem pelo menos um campo
            ApiConnection.postData("tecnicos", tecnicoObject.toString());
        }
    }
    // Método Update (PUT)
    public void putTecnico(String id, Tecnico tecnico) {
        // Primeiro, verificar se o cadastro existe
        String existingData = ApiConnection.getData("tecnicos/" + id);

        if (existingData == null || existingData.isEmpty()) {
            System.out.println("Cadastro não encontrado para atualizar.");
            return;
        }
        // Criar um Objeto Json para a atualização
        JSONObject tecnicoObject = new JSONObject();
        tecnicoObject.put("id", tecnico.getId());
        tecnicoObject.put("nome", tecnico.getNome());
        tecnicoObject.put("especialidade", tecnico.getEspecialidade());
        tecnicoObject.put("disponibilidade", tecnico.getDisponibilidade());
        // Enviar os dados via PUT
        ApiConnection.putData("tecnicos/" + id, tecnicoObject.toString());
    }
    // Método Update
    public static boolean updateTecnico(Tecnico tecnico) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", tecnico.getId());
        jsonObject.put("nome", tecnico.getNome());
        jsonObject.put("especialidade", tecnico.getEspecialidade());
        jsonObject.put("disponibilidade", tecnico.getDisponibilidade());
        
        String endpoint = "tecnicos/" + tecnico.getId();
        String response = ApiConnection.putData(endpoint, jsonObject.toString());
        return response != null; // Retorna true se a resposta não for nula (sucesso)
    }
    // Método Delete
    public static boolean deleteTecnico(String id) {
        String endpoint = "tecnicos/" + id;
        String response = ApiConnection.deleteData(endpoint); // Chama o método correto em ApiConnection
        return response != null; // Retorna true se a resposta não for nula (sucesso)
    }
}