package view;

import model.Medicamento;

import javax.swing.*;

public class Excluir {

    public void excluir () {
       String nomeBusca = JOptionPane.showInputDialog("Digite o nome do medicamento para excluir:");
       if (nomeBusca != null && !nomeBusca.isEmpty()) {
           for (Medicamento medicamento : Medicamento.medicamentoList) {
               if (medicamento.getNome().equalsIgnoreCase(nomeBusca)) {
                   int resultado = JOptionPane.showConfirmDialog(null,"Tem certeza de que deseja excluir " + medicamento.getNome() + " ?","Excluir medicamento", JOptionPane.YES_NO_OPTION);
                   if (resultado == JOptionPane.YES_OPTION) {
                       medicamento.removerMedicamento(medicamento);
                       JOptionPane.showMessageDialog(null,"Medicamento excluido com sucesso!");
                   }
                   return;
               }
           }
       }
       JOptionPane.showMessageDialog(null, "Medicamento não encontrado");
    }

}
