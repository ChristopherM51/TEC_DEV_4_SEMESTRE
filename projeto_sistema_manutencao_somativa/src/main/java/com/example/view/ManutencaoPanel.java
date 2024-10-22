// ManutencaoPanel.java
package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;

public class ManutencaoPanel extends JPanel {
    // private ManutencaoController manutencaoController;
    // private JTable manutencaoTable;
    // private DefaultTableModel tableModel;
    // private JButton btnCadastrarManutencao;
    // private JButton btnDeletarManutencao;
    // private JButton btnEditarManutencao;
    // private JButton btnGerarRelatorio;

    // public ManutencaoPanel() {
    //     super(new BorderLayout());
    //     manutencaoController = new ManutencaoController();

    //     // Configurar o modelo da tabela
    //     tableModel = new DefaultTableModel(new Object[]{
    //         "ID", "Manutenção ID", "Data", "Tipo", "Peças Trocadas", "Tempo de Parada", "Técnico ID", "Observações"
    //     }, 0);
    //     manutencaoTable = new JTable(tableModel);

    //     // Preencher a tabela com dados
    //     atualizarTabela();

    //     JScrollPane scrollPane = new JScrollPane(manutencaoTable);
    //     this.add(scrollPane, BorderLayout.CENTER);

    //     // Adicionar os botões
    //     JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
    //     btnCadastrarManutencao = new JButton("Cadastrar");
    //     btnEditarManutencao = new JButton("Editar");
    //     btnDeletarManutencao = new JButton("Deletar");
    //     btnGerarRelatorio = new JButton("Gerar Relatório PDF");

    //     painelInferior.add(btnCadastrarManutencao);
    //     painelInferior.add(btnEditarManutencao);
    //     painelInferior.add(btnDeletarManutencao);
    //     painelInferior.add(btnGerarRelatorio);
    //     this.add(painelInferior, BorderLayout.SOUTH);

    //     // ActionListeners
    //     btnCadastrarManutencao.addActionListener(e -> abrirFormularioCadastro());
    //     btnEditarManutencao.addActionListener(e -> editarManutencaoSelecionada());
    //     btnDeletarManutencao.addActionListener(e -> deletarManutencaoSelecionada());
    //     btnGerarRelatorio.addActionListener(e -> gerarRelatorioPDF());
    // }

    // private void atualizarTabela() {
    //     tableModel.setRowCount(0);
    //     List<Manutencao> manutencoes = manutencaoController.readManutencoes();
    //     for (Manutencao manutencao : manutencoes) {
    //         tableModel.addRow(new Object[]{
    //             manutencao.getId(),
    //             manutencao.getManutencaoId(),
    //             manutencao.getData(),
    //             manutencao.getTipo(),
    //             manutencao.getPecasTrocadas(),
    //             manutencao.getTempoDeParada(),
    //             manutencao.getTecnicoId(),
    //             manutencao.getObservacoes()
    //         });
    //     }
    // }

    // private void gerarRelatorioPDF() {
    //     List<Manutencao> manutencoes = manutencaoController.readManutencoes();
    //     // Geração do relatório (implementar método específico)
    // }

    // private void abrirFormularioCadastro() {
    //     abrirFormularioCadastro("", "", "", "", "", 0, "", "");
    // }

    // private void abrirFormularioCadastro(String id, String manutencaoId, String data, String tipo, String pecasTrocadas, 
    //                                      int tempoDeParada, String tecnicoId, String observacoes) {
    //     JDialog dialog = new JDialog((JFrame) null, "Cadastrar Manutenção", true);
    //     dialog.setLayout(new GridLayout(9, 2));

    //     JTextField txtManutencaoId = new JTextField(manutencaoId);
    //     JTextField txtData = new JTextField(data);
    //     JTextField txtTipo = new JTextField(tipo);
    //     JTextField txtPecasTrocadas = new JTextField(pecasTrocadas);
    //     JTextField txtTempoDeParada = new JTextField(String.valueOf(tempoDeParada)); // Converte int para String
    //     JTextField txtTecnicoId = new JTextField(tecnicoId);
    //     JTextField txtObservacoes = new JTextField(observacoes);

    //     dialog.add(new JLabel("Manutenção ID:"));
    //     dialog.add(txtManutencaoId);
    //     dialog.add(new JLabel("Data (YYYY-MM-DD):"));
    //     dialog.add(txtData);
    //     dialog.add(new JLabel("Tipo:"));
    //     dialog.add(txtTipo);
    //     dialog.add(new JLabel("Peças Trocadas:"));
    //     dialog.add(txtPecasTrocadas);
    //     dialog.add(new JLabel("Tempo de Parada:"));
    //     dialog.add(txtTempoDeParada);
    //     dialog.add(new JLabel("Técnico ID:"));
    //     dialog.add(txtTecnicoId);
    //     dialog.add(new JLabel("Observações:"));
    //     dialog.add(txtObservacoes);

    //     JButton btnSalvar = new JButton("Salvar");
    //     dialog.add(btnSalvar);
    //     JButton btnCancelar = new JButton("Cancelar");
    //     dialog.add(btnCancelar);

    //     btnSalvar.addActionListener(e -> {
    //         try {
    //             Manutencao novaManutencao = new Manutencao(
    //                 id,
    //                 txtManutencaoId.getText(),
    //                 txtData.getText(),
    //                 txtTipo.getText(),
    //                 txtPecasTrocadas.getText(),
    //                 Integer.parseInt(txtTempoDeParada.getText()),  // Conversão de String para int
    //                 txtTecnicoId.getText(),
    //                 txtObservacoes.getText()
    //             );

    //             if (id.isEmpty()) {
    //                 manutencaoController.createManutencao(novaManutencao);
    //             } else {
    //                 int posicao = Integer.parseInt(id);
    //                 manutencaoController.updateManutencao(posicao, novaManutencao);
    //             }

    //             atualizarTabela();
    //             dialog.dispose();
    //         } catch (Exception ex) {
    //             ex.printStackTrace();
    //         }
    //     });

    //     btnCancelar.addActionListener(e -> dialog.dispose());

    //     dialog.pack();
    //     dialog.setLocationRelativeTo(this);
    //     dialog.setVisible(true);
    // }

    // private void editarManutencaoSelecionada() {
    //     int selectedRow = manutencaoTable.getSelectedRow();

    //     if (selectedRow >= 0) {
    //         String id = tableModel.getValueAt(selectedRow, 0).toString(); // Pega o ID correto da primeira coluna
    //         String manutencaoId = (String) tableModel.getValueAt(selectedRow, 1);
    //         String data = (String) tableModel.getValueAt(selectedRow, 2);
    //         String tipo = (String) tableModel.getValueAt(selectedRow, 3);
    //         String pecasTrocadas = (String) tableModel.getValueAt(selectedRow, 4);
    //         int tempoDeParada = Integer.parseInt(tableModel.getValueAt(selectedRow, 5).toString());  // Conversão para int
    //         String tecnicoId = (String) tableModel.getValueAt(selectedRow, 6);
    //         String observacoes = (String) tableModel.getValueAt(selectedRow, 7);

    //         abrirFormularioCadastro(id, manutencaoId, data, tipo, pecasTrocadas, tempoDeParada, tecnicoId, observacoes);
    //     } else {
    //         System.out.println("Nenhuma linha selecionada.");
    //     }
    // }

    // private void deletarManutencaoSelecionada() {
    //     int selectedRow = manutencaoTable.getSelectedRow();
    //     if (selectedRow >= 0) {
    //         String id = tableModel.getValueAt(selectedRow, 0).toString();  // Pega o ID da primeira coluna
    //         manutencaoController.deleteManutencao(Integer.parseInt(id));  // Conversão de ID para int
    //         atualizarTabela();
    //     }
    // }
}
