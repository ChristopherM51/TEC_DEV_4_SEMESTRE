package com.example;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamExemplo {
    List<String> words = Arrays.asList(
            "banana", "abacaxi", "laranja", "ameixa", "uva", "amora");
    // crie uma nova List Resultado
    // filtre as words que comecem com a letra "a"

    public void reultadoStrem(){
        List<String> resultado = words.stream()
                .filter(words -> words.startsWith("a")) // Filtra words com mais de 3 letras
                .map(String::toUpperCase) // Converte para maiúsculas
                .collect(Collectors.toList()); // Coleta em uma nova lista
        // Imprime os resultados
        System.out.println(resultado);
    }
}
