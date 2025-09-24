package org.example;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;




    public class ClasseBiblioteca {
        private List<ClasseLivro> livros;
        private List<ClasseUsuario> usuarios;
        private List<ClasseEmprestimo> emprestimos;

        public ClasseBiblioteca() {
            this.livros = new ArrayList<>();
            this.usuarios = new ArrayList<>();
            this.emprestimos = new ArrayList<>();
        }

        public void adicionarLivro(ClasseLivro livro) {
            if (livro == null) {
                throw new IllegalArgumentException("Livro não pode ser nulo");
            }
            livros.add(livro);
        }

        public void registrarUsuario(ClasseUsuario usuario) {
            if (usuario == null) {
                throw new IllegalArgumentException("Usuário não pode ser nulo");
            }
            usuarios.add(usuario);
        }

        public boolean emprestarLivro(String isbn, String usuarioId, LocalDate dataEmprestimo) {
            ClasseLivro livro = buscarLivroPorIsbn(isbn);
            ClasseUsuario usuario = buscarUsuarioPorId(usuarioId);

            if (livro == null || usuario == null) {
                return false;
            }

            if (!livro.isDisponivel() || usuario.isPossuiMulta()) {
                return false;
            }

            livro.setDisponivel(false);
            ClasseEmprestimo emprestimo = new ClasseEmprestimo(livro, usuario, dataEmprestimo);
            emprestimos.add(emprestimo);
            return true;
        }

        public double devolverLivro(String isbn, LocalDate dataDevolucao) {
            ClasseEmprestimo emprestimo = buscarEmprestimoAtivo(isbn);
            if (emprestimo == null) {
                return -1; // Empréstimo não encontrado
            }

            ClasseLivro livro = emprestimo.getLivro();
            livro.setDisponivel(true);

            // Calcular multa se houver atraso
            long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataDevolucaoPrevista(), dataDevolucao);
            double multa = 0;

            if (diasAtraso > 0) {
                multa = diasAtraso * 2.0; // R$ 2,00 por dia de atraso
                emprestimo.getUsuario().setPossuiMulta(true);
            }

            emprestimo.setDataDevolucaoReal(dataDevolucao);
            return multa;
        }

        public List<ClasseLivro> listarLivrosDisponiveis() {
            return livros.stream()
                    .filter(ClasseLivro::isDisponivel)
                    .toList();
        }

        private ClasseLivro buscarLivroPorIsbn(String isbn) {
            return livros.stream()
                    .filter(l -> l.getIsbn().equals(isbn))
                    .findFirst()
                    .orElse(null);
        }

        private ClasseUsuario buscarUsuarioPorId(String id) {
            return usuarios.stream()
                    .filter(u -> u.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        private ClasseEmprestimo buscarEmprestimoAtivo(String isbn) {
            return emprestimos.stream()
                    .filter(e -> e.getLivro().getIsbn().equals(isbn) && e.getDataDevolucaoReal() == null)
                    .findFirst()
                    .orElse(null);
        }
    }

