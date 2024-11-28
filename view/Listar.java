package view;

import model.Medicamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;

public class Listar  {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void listarMedicamento() {

        String[] cabecalho = { "Id","Nome","Principio","Fabricacao","Validade" };
        DefaultTableModel modeloTabela = new DefaultTableModel(cabecalho,0);

        for (Medicamento medicamento : Medicamento.medicamentoList) {
            Object[] dadosMedicamento = {medicamento.getId(),medicamento.getNome(),medicamento.getPrincipioAtivo(),medicamento.getDataValidade().format(formatter),medicamento.getDataFabricacao().format(formatter)};
            modeloTabela.addRow(dadosMedicamento);
        }

        JTable tabelaMedicamento = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaMedicamento);
        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Medicamentos", JOptionPane.INFORMATION_MESSAGE);
    }


}
