package com.example.utils;

import com.example.models.Maquina;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfGenerator {
    public void gerarRelatorioMaquinas(List<Maquina> maquinas) {
        // Define o caminho do arquivo PDF
        String dest = "relatorio_maquinas.pdf"; // Você pode personalizar o caminho e o nome do arquivo
        PdfWriter writer;

        try {
            // Cria o escritor e o documento
            writer = new PdfWriter(new File(dest));
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Criação de uma fonte
            PdfFont font = PdfFontFactory.createFont();

            // Adiciona um título ao documento
            document.add(new Paragraph("Relatório de Máquinas").setFont(font).setFontSize(18));

            // Adiciona as máquinas ao documento
            for (Maquina maquina : maquinas) {
                document.add(new Paragraph("ID: " + maquina.getId())
                        .setFont(font));
                document.add(new Paragraph("Código: " + maquina.getCodigo())
                        .setFont(font));
                document.add(new Paragraph("Nome: " + maquina.getNome())
                        .setFont(font));
                document.add(new Paragraph("Modelo: " + maquina.getModelo())
                        .setFont(font));
                document.add(new Paragraph("Fabricante: " + maquina.getFabricante())
                        .setFont(font));
                document.add(new Paragraph("Data de Aquisição: " + maquina.getDataAquisicao())
                        .setFont(font));
                document.add(new Paragraph("Tempo de Vida Estimado: " + maquina.getTempoVidaEstimado())
                        .setFont(font));
                document.add(new Paragraph("Localização: " + maquina.getLocalizacao())
                        .setFont(font));
                document.add(new Paragraph("Detalhes: " + maquina.getDetalhes())
                        .setFont(font));
                document.add(new Paragraph("Manual: " + maquina.getManual())
                        .setFont(font));
                document.add(new Paragraph("---------------------------------------------------")
                        .setFont(font));
            }

            // Fecha o documento
            document.close();
            System.out.println("PDF gerado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
