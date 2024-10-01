package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeituraAPI {
    public void example() {
        try {
            URL url = new URL("http://api.github.com/users/ChristopherM51");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status != 200) {
                throw new Exception("Erro ed Conexão");
            }
            // conexão estabelecida
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            // laço de repetição
        } catch (Exception e) {

        }
    }
}