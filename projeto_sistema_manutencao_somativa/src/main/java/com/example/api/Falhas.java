package com.example.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Falha;

public class Falhas {
     public static List<Falha> getFalhas() {
        String json = ApiConnection.getData("falhas");
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
}
