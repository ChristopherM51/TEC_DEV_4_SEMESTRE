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

public class MaquinasPanel extends JPanel {
    // Atributos
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;
    private JButton btnDeletarMaquina;

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
        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        btnDeletarMaquina = new JButton("Deletar");

        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes);
        painelInferior.add(btnDeletarMaquina);
        this.add(painelInferior, BorderLayout.SOUTH);

        // ActionListener para o botão de Cadastrar Máquina
        btnCadastrarMaquina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioCadastro();
            }
        });

        // ActionListener para salvar alterações
        btnSalvarAlteracoes.addActionListener(e -> salvarAlteracoes());

        // ActionListener para deletar máquina
        btnDeletarMaquina.addActionListener(e -> deletarMaquinaSelecionada());
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

    // Método para abrir o formulário de cadastro de máquina
    private void abrirFormularioCadastro() {
        JDialog dialog = new JDialog((JFrame) null, "Cadastrar Máquina", true);
        dialog.setLayout(new GridLayout(11, 2));

        // Campos do formulário
        JTextField txtCodigo = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtModelo = new JTextField();
        JTextField txtFabricante = new JTextField();
        JTextField txtDataAquisicao = new JTextField();
        JTextField txtTempoVida = new JTextField();
        JTextField txtLocalizacao = new JTextField();
        JTextField txtDetalhes = new JTextField();
        JTextField txtManual = new JTextField();

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
                    "", // O ID será gerado automaticamente
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

                maquinaController.createMaquina(novaMaquina);
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

    // Método para salvar alterações na tabela
    private void salvarAlteracoes() {
        int selectedRow = maquinasTable.getSelectedRow();
        if (selectedRow >= 0) {
            String id = (String) tableModel.getValueAt(selectedRow, 0);
            Maquina maquinaAtualizada = new Maquina(
                id,
                (String) tableModel.getValueAt(selectedRow, 1),
                (String) tableModel.getValueAt(selectedRow, 2),
                (String) tableModel.getValueAt(selectedRow, 3),
                (String) tableModel.getValueAt(selectedRow, 4),
                LocalDate.parse((String) tableModel.getValueAt(selectedRow, 5)),
                Long.parseLong((String) tableModel.getValueAt(selectedRow, 6)),
                (String) tableModel.getValueAt(selectedRow, 7),
                (String) tableModel.getValueAt(selectedRow, 8),
                (String) tableModel.getValueAt(selectedRow, 9)
            );
            maquinaController.updateMaquina(selectedRow, maquinaAtualizada);
            atualizarTabela();
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
