package view;

import model.Medicamento;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Editar {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void editarMedicamento() {
        JPanel painel = new JPanel();
        JLabel campoPesquisa = new JLabel("Medicamento");
        JTextField inputPesquisa = new JTextField(20);

        painel.add(campoPesquisa);
        painel.add(inputPesquisa);

        JPanel painelEdit = new JPanel();
        painelEdit.setVisible(false);

        JLabel txtNome = new JLabel("Nome");
        JLabel txtPrincipio = new JLabel("Principio");
        JLabel txtFabricacao = new JLabel("Fabricacao");
        JLabel txtValidade = new JLabel("Validade");

        JTextField campoNome = new JTextField(20);
        JTextField campoPrincipio = new JTextField(20);
        JTextField campoFabricacao = criarCampoData();
        JTextField campoValidade = criarCampoData();

        JButton atualizar = new JButton("Atualizar");

        painelEdit.add(txtNome);
        painelEdit.add(campoNome);
        painelEdit.add(txtPrincipio);
        painelEdit.add(campoPrincipio);
        painelEdit.add(txtFabricacao);
        painelEdit.add(campoFabricacao);
        painelEdit.add(txtValidade);
        painelEdit.add(campoValidade);
        painelEdit.add(atualizar);

        JOptionPane.showMessageDialog(null, painel, "Edicao de Medicamentos", JOptionPane.INFORMATION_MESSAGE);

        String pesquisa = inputPesquisa.getText();
        for (Medicamento medicamento : Medicamento.medicamentoList) {
            if (medicamento.getNome().equalsIgnoreCase(pesquisa)) {
                painelEdit.setVisible(true);
                JOptionPane.showMessageDialog(null, painelEdit, "Edicao de Medicamentos", JOptionPane.INFORMATION_MESSAGE);
                int resultado = JOptionPane.showConfirmDialog(null,"Tem certeza de que deseja Alterar " + medicamento.getNome() + " ?","Alterar medicamento", JOptionPane.YES_NO_OPTION);
                if (resultado == JOptionPane.YES_OPTION) {
                    medicamento.setNome(campoNome.getText());
                    medicamento.setPrincipioAtivo(campoPrincipio.getText());
                    medicamento.setDataFabricacao(LocalDate.parse(campoFabricacao.getText(), formatter));
                    medicamento.setDataValidade(LocalDate.parse(campoValidade.getText(), formatter));
                    JOptionPane.showMessageDialog(null, "Medicamento alterado com sucesso!");
                }
            }
        }
    }

    private JFormattedTextField criarCampoData() {
        try {
            MaskFormatter formatter = new MaskFormatter("##/##/####");
            formatter.setPlaceholderCharacter('_');
            return new JFormattedTextField(formatter);
        }catch (Exception e) {
            return new JFormattedTextField();
        }
    }
}
