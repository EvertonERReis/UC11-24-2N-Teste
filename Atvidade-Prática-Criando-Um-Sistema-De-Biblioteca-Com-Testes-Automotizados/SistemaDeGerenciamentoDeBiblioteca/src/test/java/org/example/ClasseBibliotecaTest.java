package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // permite usar @BeforeAll não-estático
class ClasseBibliotecaTest {
    private ClasseBiblioteca biblioteca;
    private ClasseLivro livro1;
    private ClasseLivro livro2;
    private ClasseUsuario usuario1;
    private ClasseUsuario usuario2;


    // contador global para os testes
    private int contadorTestes = 0;

    @BeforeAll
    void initAll() {
        System.out.println("🚀🪫 Iniciando a suíte de testes da ClasseBibliotecaTest...");
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        biblioteca = new ClasseBiblioteca();

        livro1 = new ClasseLivro("123456", "Dom Casmurro", "Machado de Assis", 1899);
        livro2 = new ClasseLivro("789012", "O Cortiço", "Aluísio Azevedo", 1890);

        usuario1 = new ClasseUsuario("U001", "João Silva", "joao@email.com");
        usuario2 = new ClasseUsuario("U002", "Maria Santos", "maria@email.com");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        System.out.println("🔧 Novo cenário de teste preparado.");

        // incrementa o contador antes de cada teste
        contadorTestes++;
        System.out.println("\n[TESTE " + contadorTestes + "] " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("✅ Deve cadastrar livro com sucesso")
    void testCadastrarLivro() {
        ClasseLivro novo = new ClasseLivro("999999", "Memórias Póstumas", "Machado de Assis", 1881);
        biblioteca.adicionarLivro(novo);

        List<ClasseLivro> disponiveis = biblioteca.listarLivrosDisponiveis();
        assertTrue(disponiveis.contains(novo));
    }

    @Test
    @DisplayName("❌ Deve lançar exceção ao cadastrar livro nulo")
    void testCadastrarLivroNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> biblioteca.adicionarLivro(null));
    }

    @Test
    @DisplayName("✅ Deve realizar empréstimo com sucesso")
    void testEmprestarLivro() {
        boolean emprestado = biblioteca.emprestarLivro("123456", "U001", LocalDate.now());
        assertTrue(emprestado);
        assertFalse(livro1.isDisponivel());
    }

    @Test
    @DisplayName("❌ Não deve emprestar livro indisponível")
    void testEmprestarLivroIndisponivel() {
        biblioteca.emprestarLivro("123456", "U001", LocalDate.now());
        boolean emprestadoNovamente = biblioteca.emprestarLivro("123456", "U002", LocalDate.now());
        assertFalse(emprestadoNovamente);
    }

    @ParameterizedTest
    @DisplayName("💰 Deve calcular multa corretamente")
    @ValueSource(ints = {0, 5, 10} )
    void testCalcularMulta(int diasAtraso) {
        biblioteca.emprestarLivro("123456", "U001", LocalDate.now());
        LocalDate devolucao = LocalDate.now().plusDays(14 + diasAtraso);

        double multa = biblioteca.devolverLivro("123456", devolucao);
        assertEquals(diasAtraso * 2.0, multa);
    }

    @Test
    @DisplayName("📚 Deve listar apenas livros disponíveis")
    void testListarLivrosDisponiveis() {
        biblioteca.emprestarLivro("123456", "U001", LocalDate.now());
        List<ClasseLivro> disponiveis = biblioteca.listarLivrosDisponiveis();

        assertTrue(disponiveis.contains(livro2));
        assertFalse(disponiveis.contains(livro1));
    }

    @Test
    @DisplayName("⏰ Deve bloquear empréstimo para usuário com multa")
    void testUsuarioComMulta() {
        biblioteca.emprestarLivro("123456", "U001", LocalDate.now());
        biblioteca.devolverLivro("123456", LocalDate.now().plusDays(20)); // devolveu atrasado → multa

        boolean emprestimo = biblioteca.emprestarLivro("789012", "U001", LocalDate.now());
        assertFalse(emprestimo);
    }


    @AfterEach
    void tearDown() {
        biblioteca = null;
        System.out.println("🧑🏻‍💻🔋 Cenário de teste finalizado.");
    }

    @AfterAll
    void tearDownAll() {
        System.out.println("✅ Todos os testes foram executados.");
    }



    /// Array de mensagens aleatorias nos sout.println

//    @BeforeEach
//    void mensagem() {
//        String [] mensagens = {"Teste" ,"Testando", "Mais um Teste", "Outro Teste", "Teste Testado",};
//        System.out.println(mensagens[ (int) (Math.random()*mensagens.length)]);
//    }


}
