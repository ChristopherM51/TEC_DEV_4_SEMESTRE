package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Maquina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaquinaAPI {

    public static List<Maquina> getMaquinas() {
        String json = ApiConnection.getData("maquinas");
        List<Maquina> maquinas = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Maquina maquina = new Maquina(
                        jsonObject.getString("id"),
                        jsonObject.getString("codigo"),
                        jsonObject.getString("nome"),
                        jsonObject.getString("modelo"),
                        jsonObject.getString("fabricante"),
                        LocalDate.parse(jsonObject.getString("dataAquisicao")),
                        jsonObject.getLong("tempoVidaEstimado"),
                        jsonObject.getString("localizacao"),
                        jsonObject.getString("detalhes"),
                        jsonObject.getString("manual")
                );
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    // Método Create
    public void postMaquina(Maquina maquina) {
        JSONObject maquinaObject = new JSONObject();
        maquinaObject.put("id", maquina.getId());
        maquinaObject.put("codigo", maquina.getCodigo());
        maquinaObject.put("nome", maquina.getNome());
        maquinaObject.put("modelo", maquina.getModelo());
        maquinaObject.put("fabricante", maquina.getFabricante());
        maquinaObject.put("dataAquisicao", maquina.getDataAquisicao().toString());
        maquinaObject.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        maquinaObject.put("localizacao", maquina.getLocalizacao());
        maquinaObject.put("detalhes", maquina.getDetalhes());
        maquinaObject.put("manual", maquina.getManual());

        // Enviar os dados via POST
        if (maquinaObject.length() > 0) {
            ApiConnection.postData("maquinas", maquinaObject.toString());
        }
    }

    // Método Update (PUT)
    public void putMaquina(String id, Maquina maquina) {
        // Primeiro, verificar se o cadastro existe
        String existingData = ApiConnection.getData("maquinas/" + id);

        if (existingData == null || existingData.isEmpty()) {
            System.out.println("Cadastro não encontrado para atualizar.");
            return;
        }

        // Criar um Objeto Json para a atualização
        JSONObject maquinaObject = new JSONObject();
        maquinaObject.put("id", maquina.getId());
        maquinaObject.put("codigo", maquina.getCodigo());
        maquinaObject.put("nome", maquina.getNome());
        maquinaObject.put("modelo", maquina.getModelo());
        maquinaObject.put("fabricante", maquina.getFabricante());
        maquinaObject.put("dataAquisicao", maquina.getDataAquisicao().toString());
        maquinaObject.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        maquinaObject.put("localizacao", maquina.getLocalizacao());
        maquinaObject.put("detalhes", maquina.getDetalhes());
        maquinaObject.put("manual", maquina.getManual());

        // Enviar os dados via PUT
        ApiConnection.putData("maquinas/" + id, maquinaObject.toString());
    }

    public static boolean deleteMaquina(String id) {
        String endpoint = "maquinas/" + id;
        String response = ApiConnection.deleteData(endpoint); // Chama o método correto em ApiConnection
        return response != null; // Retorna true se a resposta não for nula (sucesso)
    }
}
