import com.sistema_academia.Sistema;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestesUnitarios {
    private Sistema sistema;

    @BeforeEach
    void setUp() {
        sistema = new Sistema();
    }

    @Test
    @DisplayName("Cadastro de aluno válido")
    void cadastrarAluno_ComDadosValidos_RetornaTrue() {
        assertTrue(sistema.cadastrarAluno("123", "João Silva"));
        assertEquals(2, sistema.getTotalAlunosCadastrados());
    }

    @Test
    @DisplayName("Atualização de cadastro de aluno")
    void atualizarAluno_ComDadosValidos_RetornaTrue() {
        sistema.cadastrarAluno("456", "Maria Souza");
        assertTrue(sistema.atualizarAluno("456", "Maria Souza Oliveira", true));
    }

    @Test
    @DisplayName("Agendamento de avaliação física")
    void agendarAvaliacao_ComAlunoExistente_RetornaTrue() {
        sistema.cadastrarAluno("789", "Carlos Oliveira");
        assertTrue(sistema.agendarAvaliacao("789", "2023-12-01 10:00"));
        assertTrue(sistema.getTotalNotificacoesEnviadas() > 0);
    }

    @Test
    @DisplayName("Consulta de status de pagamento")
    void consultarStatusPagamento_AlunoNaoPago_RetornaPendente() {
        sistema.cadastrarAluno("101", "Ana Lima");
        assertEquals("Pendente", sistema.consultarStatusPagamento("101"));
    }

    @Test
    @DisplayName("Geração de notificações automáticas")
    void agendarAvaliacao_AlunoAtivo_EnviaNotificacao() {
        sistema.cadastrarAluno("202", "Pedro Santos");
        sistema.agendarAvaliacao("202", "2023-12-02 14:00");
        assertTrue(sistema.getTotalNotificacoesEnviadas() > 0);
    }
}
