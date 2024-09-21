package com.example;

public class ExercicioRecursao{
    // atributos
    int numero = -1;
    //
    Scanner sc = new Scanner (System.in);
    //
    // Métodos
    // Calcular fatorial!
    public long fatorial (int numero)
    if(numero == 0 || numero == 1 ){
        return 1;
    } else {
        return numero * fatorial (numero -1);
    }

    // fazer operação
    public void calculadora () throws Exception {
        while (true)
        System.out.println("Digite um nº");
        if (numero<0){
            throw new Exception ("Não é permitido nº Negativo");
        }
        try {
            long resultado = fatorial (numero);
            System.out.print("O fatorial é "+ resultado);
        } catch (Exception e){
            System.err.println(e);
        }
    }

}