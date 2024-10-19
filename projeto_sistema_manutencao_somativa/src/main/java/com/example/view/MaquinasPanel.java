package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.MaquinaController;
import com.example.models.Maquina;
import com.example.utils.PdfGenerator; // Importando a classe de geração de PDF

public class MaquinasPanel extends JPanel {
    // Atributos
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnCadastrarMaquina;
    private JButton btnDeletarMaquina;
    private JButton btnEditarMaquina;
    private JButton btnGerarRelatorio; // Novo botão para gerar relatório

    // Construtor
    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();

        // Configurar o modelo da tabela
        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Código", "Nome", "Modelo", "Fabricante", "Data Aquisição",
            "Tempo de Vida Estimado", "Localização", "Detalhes", "Manual"
        }, 0);
        maquinasTable = new JTable(tableModel);

        // Preencher a tabela com dados
        atualizarTabela();

        JScrollPane scrollPane = new JScrollPane(maquinasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os Botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnEditarMaquina = new JButton("Editar");
        btnDeletarMaquina = new JButton("Deletar");
        btnGerarRelatorio = new JButton("Gerar Relatório PDF"); // Botão de gerar relatório

        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnEditarMaquina);
        painelInferior.add(btnDeletarMaquina);
        painelInferior.add(btnGerarRelatorio); // Adicionando o botão ao painel
        this.add(painelInferior, BorderLayout.SOUTH);

        // ActionListener para o botão de Cadastrar Máquina
        btnCadastrarMaquina.addActionListener(e -> abrirFormularioCadastro());

        // ActionListener para o botão de Editar Máquina
        btnEditarMaquina.addActionListener(e -> editarMaquinaSelecionada());

        // ActionListener para deletar máquina
        btnDeletarMaquina.addActionListener(e -> deletarMaquinaSelecionada());

        // ActionListener para o botão de gerar relatório
        btnGerarRelatorio.addActionListener(e -> gerarRelatorioPDF());
    }

    // Método para atualizar a tabela com os dados
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        List<Maquina> maquinas = maquinaController.readMaquinas();
        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[]{
                maquina.getId(),
                maquina.getCodigo(),
                maquina.getNome(),
                maquina.getModelo(),
                maquina.getFabricante(),
                maquina.getDataAquisicao(),
                maquina.getTempoVidaEstimado(),
                maquina.getLocalizacao(),
                maquina.getDetalhes(),
                maquina.getManual()
            });
        }
    }

    // Método para gerar o relatório PDF
    private void gerarRelatorioPDF() {
        List<Maquina> maquinas = maquinaController.readMaquinas();
        PdfGenerator pdfGenerator = new PdfGenerator();
        pdfGenerator.gerarRelatorioMaquinas(maquinas);
    }

    // Método para abrir o formulário de cadastro de máquina
    private void abrirFormularioCadastro() {
        abrirFormularioCadastro("", "", "", "", "", "", "", "", "", "");
    }

    // Método para abrir o formulário de cadastro ou edição
    private void abrirFormularioCadastro(String id, String codigo, String nome, String modelo, String fabricante,
                                         String dataAquisicao, String tempoVida, String localizacao,
                                         String detalhes, String manual) {
        JDialog dialog = new JDialog((JFrame) null, "Cadastrar Máquina", true);
        dialog.setLayout(new GridLayout(11, 2));

        // Campos do formulário
        JTextField txtCodigo = new JTextField(codigo);
        JTextField txtNome = new JTextField(nome);
        JTextField txtModelo = new JTextField(modelo);
        JTextField txtFabricante = new JTextField(fabricante);
        JTextField txtDataAquisicao = new JTextField(dataAquisicao);
        JTextField txtTempoVida = new JTextField(tempoVida);
        JTextField txtLocalizacao = new JTextField(localizacao);
        JTextField txtDetalhes = new JTextField(detalhes);
        JTextField txtManual = new JTextField(manual);

        // Adicionar os campos no diálogo
        dialog.add(new JLabel("Código:"));
        dialog.add(txtCodigo);
        dialog.add(new JLabel("Nome:"));
        dialog.add(txtNome);
        dialog.add(new JLabel("Modelo:"));
        dialog.add(txtModelo);
        dialog.add(new JLabel("Fabricante:"));
        dialog.add(txtFabricante);
        dialog.add(new JLabel("Data Aquisição (YYYY-MM-DD):"));
        dialog.add(txtDataAquisicao);
        dialog.add(new JLabel("Tempo de Vida Estimado:"));
        dialog.add(txtTempoVida);
        dialog.add(new JLabel("Localização:"));
        dialog.add(txtLocalizacao);
        dialog.add(new JLabel("Detalhes:"));
        dialog.add(txtDetalhes);
        dialog.add(new JLabel("Manual:"));
        dialog.add(txtManual);

        JButton btnSalvar = new JButton("Salvar");
        dialog.add(btnSalvar);
        JButton btnCancelar = new JButton("Cancelar");
        dialog.add(btnCancelar);

        btnSalvar.addActionListener(e -> {
            try {
                Maquina novaMaquina = new Maquina(
                    id, // Usar o ID da máquina que está sendo editada
                    txtCodigo.getText(),
                    txtNome.getText(),
                    txtModelo.getText(),
                    txtFabricante.getText(),
                    LocalDate.parse(txtDataAquisicao.getText()),
                    Long.parseLong(txtTempoVida.getText()),
                    txtLocalizacao.getText(),
                    txtDetalhes.getText(),
                    txtManual.getText()
                );
                
                if (id.isEmpty()) {
                    // Se ID for vazio, significa que estamos cadastrando uma nova máquina
                    maquinaController.createMaquina(novaMaquina);
                } else {
                    // Se ID não for vazio, estamos atualizando a máquina existente usando o índice como referência
                    int posicao = Integer.parseInt(id); // Índice da linha selecionada
                    maquinaController.updateMaquina(posicao, novaMaquina);
                }

                atualizarTabela();
                dialog.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void editarMaquinaSelecionada() {
        int selectedRow = maquinasTable.getSelectedRow();
    
        if (selectedRow >= 0) {
            // Obter ID da linha selecionada
            String id = String.valueOf(selectedRow); // Usar o índice da linha como ID
            String codigo = (String) tableModel.getValueAt(selectedRow, 1);
            String nome = (String) tableModel.getValueAt(selectedRow, 2);
            String modelo = (String) tableModel.getValueAt(selectedRow, 3);
            String fabricante = (String) tableModel.getValueAt(selectedRow, 4);
            String dataAquisicao = tableModel.getValueAt(selectedRow, 5).toString();
            String tempoVida = tableModel.getValueAt(selectedRow, 6).toString();
            String localizacao = (String) tableModel.getValueAt(selectedRow, 7);
            String detalhes = (String) tableModel.getValueAt(selectedRow, 8);
            String manual = (String) tableModel.getValueAt(selectedRow, 9);
            
            // Chama o método para abrir o formulário de cadastro com os dados da máquina selecionada
            abrirFormularioCadastro(id, codigo, nome, modelo, fabricante, dataAquisicao, tempoVida, localizacao, detalhes, manual);
        } else {
            // Adicione um log ou mensagem para saber que nada foi selecionado
            System.out.println("Nenhuma linha selecionada.");
        }
    }    

    // Método para deletar a máquina selecionada
    private void deletarMaquinaSelecionada() {
        int selectedRow = maquinasTable.getSelectedRow();
        if (selectedRow >= 0) {
            maquinaController.deleteMaquina(selectedRow);
            atualizarTabela();
        }
    }
}
