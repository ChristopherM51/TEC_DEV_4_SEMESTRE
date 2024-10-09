package com.example.models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Falha {
    private int id;
    private int maquinaId;
    private Date data;
    private String problema;
    private String prioridade;
    private String operador;

    @Override
    public String toString() {
        return "Falha{" +
                "id=" + id +
                ", maquinaId=" + maquinaId +
                ", data=" + data +
                ", problema='" + problema + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", operador='" + operador + '\'' +
                '}';
    }
}