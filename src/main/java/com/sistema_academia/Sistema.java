package com.sistema_academia;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Sistema {
    private final Map<String, Aluno> alunos = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<String> notificacoesEnviadas = new CopyOnWriteArrayList<>();

    public boolean cadastrarAluno(String matricula, String nome) {
        if (alunos.containsKey(matricula)) return false;

        Aluno aluno = new Aluno(matricula, nome);
        alunos.put(matricula, aluno);
        return true;
    }

    public boolean atualizarAluno(String matricula, String novoNome, boolean receberNotificacoes) {
        if (!alunos.containsKey(matricula)) return false;

        Aluno aluno = alunos.get(matricula);
        aluno.setNome(novoNome);
        aluno.setReceberNotificacoes(receberNotificacoes);
        return true;
    }

    public boolean agendarAvaliacao(String matricula, String dataHora) {
        if (!alunos.containsKey(matricula)) return false;

        Aluno aluno = alunos.get(matricula);
        aluno.addAvaliacaoAgendada(dataHora);
        enviarNotificacao(matricula, "Nova avaliação agendada: " + dataHora);
        return true;
    }

    public String consultarStatusPagamento(String matricula) {
        if (!alunos.containsKey(matricula)) return "Aluno não encontrado";

        return alunos.get(matricula).isMensalidadePaga() ? "Regular" : "Pendente";
    }

    private void enviarNotificacao(String matricula, String mensagem) {
        if (alunos.containsKey(matricula) && alunos.get(matricula).isReceberNotificacoes()) {
            notificacoesEnviadas.add(matricula + ": " + mensagem);
        }
    }

    public int getTotalNotificacoesEnviadas() {
        return notificacoesEnviadas.size();
    }

    public int getTotalAlunosCadastrados() {
        return alunos.size();
    }
}


