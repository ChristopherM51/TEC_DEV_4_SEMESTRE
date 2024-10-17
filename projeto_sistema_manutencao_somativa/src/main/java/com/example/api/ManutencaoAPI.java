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
                    jsonObject.getString("id"),
                    jsonObject.getString("manutencaoId"),
                    jsonObject.getString("data"),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getInt("tempoDeParada"),
                    jsonObject.getString("tecnicoId"),
                    jsonObject.getString("observacoes")
                );
                manutencoes.add(manutencao);
            }
        }
        return manutencoes;
    }
    // Método Create
    public void postMaquina(Manutencao manutencao) {
        // Criar um Objeto Json
        JSONObject manutencaoObject = new JSONObject();
        manutencaoObject.put("id", manutencao.getId());
        manutencaoObject.put("manutencao", manutencao.getManutencao());
        manutencaoObject.put("data", manutencao.getData());
        manutencaoObject.put("tipo", manutencao.getTipo());
        manutencaoObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        manutencaoObject.put("tempoDeParada", manutencao.getTempoDeParada());
        manutencaoObject.put("tecnicoId", manutencao.getTecnicoId());
        manutencaoObject.put("observacoes", manutencao.getObservacoes());
    }
    // Método Update (PUT)
    public void putManutencao(String id, Manutencao manutencao) {
        // Primeiro, verificar se o cadastro existe
        String existingData = ApiConnection.getData("manutencoes/" + id);

        if (existingData == null || existingData.isEmpty()) {
            System.out.println("Cadastro não encontrado para atualizar.");
            return;
        }

        // Criar um Objeto Json para a atualização
        JSONObject manutencaoObject = new JSONObject();
        manutencaoObject.put("id", manutencao.getId());
        manutencaoObject.put("manutencao", manutencao.getManutencao());
        manutencaoObject.put("data", manutencao.getData());
        manutencaoObject.put("tipo", manutencao.getTipo());
        manutencaoObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        manutencaoObject.put("tempoDeParada", manutencao.getTempoDeParada());
        manutencaoObject.put("tecnicoId", manutencao.getTecnicoId());
        manutencaoObject.put("observacoes", manutencao.getObservacoes());

        // Enviar os dados via PUT
        ApiConnection.putData("manutencoes/" + id, manutencaoObject.toString());
    }
    // Método Update
    public static boolean updateManutencao(Manutencao manutencao) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", manutencao.getId());
        jsonObject.put("manutencao", manutencao.getManutencao());
        jsonObject.put("data", manutencao.getData());
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());

        String endpoint = "manutencoes/" + manutencao.getId();
        String response = ApiConnection.putData(endpoint, jsonObject.toString());
        return response != null; // Retorna true se a resposta não for nula (sucesso)
    }
    public static boolean deleteManutencao(String id) {
        String endpoint = "manutencoes/" + id;
        String response = ApiConnection.deleteData(endpoint); // Chama o método correto em ApiConnection
        return response != null; // Retorna true se a resposta não for nula (sucesso)
    }
}
