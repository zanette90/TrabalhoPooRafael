package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Medicamento {
    private long id;
    private String nome;
    private String principioAtivo;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    public static List<Medicamento> medicamentoList = new ArrayList<>();
    public static long proximoId = 1;

    public Medicamento(String nome, String principioAtivo, LocalDate dataFabricacao, LocalDate dataValidade) {
        this.id = proximoId++;
        this.nome = nome;
        this.principioAtivo = principioAtivo;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void addMedicamento(Medicamento medicamento) {
        this.medicamentoList.add(medicamento);
    }

    public void removerMedicamento(Medicamento medicamento) {
        this.medicamentoList.remove(medicamento);
    }

    public List<Medicamento> listarMedicamento() {
        return this.medicamentoList;
    }
}
