package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GerenciamentoVendas {
    private Map<String,List<Produto>> vendasClientes;

    public GerenciamentoVendas(){
        vendasClientes = new HashMap<>();
    }
    //registar venda - IdCliente
    public void venda(String cpf, Produto produto){
        for(String cpfCliente : vendasClientes.keySet()){
            if(cpfCliente.equalsIgnoreCase(cpf)){
                //criando uma lista de produtos que ja existem
                List<Produto> produtos = vendasClientes.get(cpfCliente);
                produtos.add(produto);
                vendasClientes.put(cpf,produtos);
                return;
            }
        }
            List<Produto> produtos = new ArrayList<>();
            produtos.add(produto);
            vendasClientes.put(cpf,produtos);
        }
    //consultar vendas por cliente
    public void produtosClientes(String cpf){
        List<Produto> produtos = vendasClientes.getOrDefault(
            cpf,Collections.emptyList());
        if(produtos.isEmpty()){
            System.out.println("Nenhuma venda cadastrada");
        }else{
            for(Produto produto : produtos){
                System.out.println(produto.toString());
            }
        }
    }
    //listar vendas acima de determinao valor
    public void produtosClientesAcimaDe(String cpf, double valorMinimo){
        List<Produto> produtos = vendasClientes.getOrDefault(
            cpf,Collections.emptyList());
        if(produtos.isEmpty()){
            System.out.println("Nenhuma venda cadastrada");
        }else{
            List<Produto> resultado = produtos.stream()
            .filter(p->p.getValor()>=valorMinimo)
            .collect(Collectors.toList());
            if(resultado.isEmpty()){
                System.out.println("Nenhuma compra atingiu o valor minimo");
            }else{
                for(Produto produto : resultado){
                System.out.println(produto.toString());
            }
        }
    }
    }
}
