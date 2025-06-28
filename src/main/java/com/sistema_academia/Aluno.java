package com.sistema_academia;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String matricula;
    private String nome;
    private boolean mensalidadePaga;
    private List<String> avaliacoesAgendadas = new ArrayList<>();
    private boolean receberNotificacoes;

    // Constructor
    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.mensalidadePaga = false;
        this.receberNotificacoes = true;
    }

    // Getters and Setters
    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMensalidadePaga() {
        return mensalidadePaga;
    }

    public void setMensalidadePaga(boolean mensalidadePaga) {
        this.mensalidadePaga = mensalidadePaga;
    }

    public List<String> getAvaliacoesAgendadas() {
        return new ArrayList<>(avaliacoesAgendadas);
    }

    public void addAvaliacaoAgendada(String dataHora) {
        this.avaliacoesAgendadas.add(dataHora);
    }

    public boolean isReceberNotificacoes() {
        return receberNotificacoes;
    }

    public void setReceberNotificacoes(boolean receberNotificacoes) {
        this.receberNotificacoes = receberNotificacoes;
    }
}
