package com.kanban.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
    private int id;
    private int usuarioId;
    private String descricao;
    private String setor;
    private String prioridade; // baixa, média, alta
    private String dataCadastro;
    private String status; // "a fazer", "fazendo", "pronto"
}
