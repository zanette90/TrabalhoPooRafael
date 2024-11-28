package view;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {

    public void TelaPrincipal() {
        setTitle("Bem vindos ao gerenciador de Medicamentos");
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuMedicamento = new JMenu("Medicamento");
        JMenuItem sair = new JMenuItem("Sair");

        JMenuItem cadastrar = new JMenuItem("Cadastrar");
        JMenuItem listar = new JMenuItem("Listar");
        JMenuItem alterar = new JMenuItem("Alterar");
        JMenuItem excluir = new JMenuItem("Excluir");

        menuMedicamento.add(cadastrar);
        menuMedicamento.add(listar);
        menuMedicamento.add(alterar);
        menuMedicamento.add(excluir);

        menuBar.add(menuMedicamento);
        menuBar.add(sair);
        setJMenuBar(menuBar);

        cadastrar.addActionListener(e-> new Cadastrar().cadastrarMedicamento());
        listar.addActionListener(e-> new Listar().listarMedicamento());
        alterar.addActionListener(e-> new Editar().editarMedicamento());
        excluir.addActionListener(e-> new Excluir().excluir());
        sair.addActionListener(e-> System.exit(0));

    }
}
