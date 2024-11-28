package view;

import model.Medicamento;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Cadastrar  {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cadastrar() {

    }

    public void cadastrarMedicamento() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setSize(500,250);
        jFrame.setTitle("Cadastro");
        jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        jFrame.add(painel);

        JLabel nomeTxt = new JLabel("Nome                  ");
        JLabel principioTxt = new JLabel("Principio Ativo  ");
        JLabel dataFabTxt = new JLabel("Data de Fabricacao ");
        JLabel dataValidade = new JLabel("Data de Validade ");

        nomeTxt.setBounds(20,10,200,10);
        principioTxt.setBounds(20,30,200,10);
        dataFabTxt.setBounds(20,50,200,10);
        dataValidade.setBounds(20,70,200,10);

        painel.add(nomeTxt);
        painel.add(principioTxt);
        painel.add(dataFabTxt);
        painel.add(dataValidade);

        JTextField campoNome = new JTextField(20);
        JTextField campoPrincipioAtivo = new JTextField(20);
        JTextField campoDataFabricacao = criarCampoData();
        JTextField campoDataValidade = criarCampoData();

        campoNome.setBounds(150,10,200,20);
        campoPrincipioAtivo.setBounds(150,30,200,20);
        campoDataFabricacao.setBounds(150,50,200,20);
        campoDataValidade.setBounds(150,70,200,20);

        painel.add(campoNome);
        painel.add(campoPrincipioAtivo);
        painel.add(campoDataFabricacao);
        painel.add(campoDataValidade);

        JButton btn_cadastrar = new JButton("Cadastrar");
        JButton btn_limpar = new JButton("Limpar");

        btn_cadastrar.setBounds(100,100,100,50);
        btn_limpar.setBounds(200,100,100,50);

        painel.add(btn_cadastrar);
        painel.add(btn_limpar);


        btn_cadastrar.addActionListener(e -> {
            try {
                String nome = campoNome.getText();
                String principio = campoPrincipioAtivo.getText();
                LocalDate dataFabricao = LocalDate.parse(campoDataFabricacao.getText(), formatter);
                LocalDate dataValidade1 = LocalDate.parse(campoDataValidade.getText(), formatter);

                if (!nome.isBlank() && !principio.isBlank()) {
                    salvar(nome,principio,dataFabricao, dataValidade1);
                    JOptionPane.showMessageDialog(null,"Medicamento cadastrado com sucesso!",null,JOptionPane.INFORMATION_MESSAGE);
                    campoNome.setText("");
                    campoPrincipioAtivo.setText("");
                    campoDataFabricacao.setText("");
                    campoDataValidade.setText("");
                }else {
                    JOptionPane.showMessageDialog(null,"Campo nome ou principio ativo devem ser preenchidos!",null,JOptionPane.ERROR_MESSAGE);
                }
            }catch (DateTimeParseException dp) {
                JOptionPane.showMessageDialog(null,"Formato de data invalido. Use dd/MM/aaaa","Erro",JOptionPane.ERROR_MESSAGE);
            }
        });

        btn_limpar.addActionListener(e -> {
            campoNome.setText("");
            campoPrincipioAtivo.setText("");
            campoDataFabricacao.setText("");
            campoDataValidade.setText("");
        });
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
    private void salvar (String nome, String PrincipioAtivo, LocalDate dataFabricacao, LocalDate dataValidade) {
        Medicamento medicamento = new Medicamento(nome,PrincipioAtivo,dataFabricacao,dataValidade);
        medicamento.addMedicamento(medicamento);
    }

}
