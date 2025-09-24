package org.example;
import java.time.LocalDate;

public class ClasseEmprestimo {


        private ClasseLivro livro;
        private ClasseUsuario usuario;
        private LocalDate dataEmprestimo;
        private LocalDate dataDevolucaoPrevista;
        private LocalDate dataDevolucaoReal;

        public ClasseEmprestimo(ClasseLivro livro, ClasseUsuario usuario, LocalDate dataEmprestimo) {
            this.livro = livro;
            this.usuario = usuario;
            this.dataEmprestimo = dataEmprestimo;
            this.dataDevolucaoPrevista = dataEmprestimo.plusDays(14); // 14 dias para devolução
        }

        // Getters e Setters
        public ClasseLivro getLivro() { return livro; }
        public ClasseUsuario getUsuario() { return usuario; }
        public LocalDate getDataEmprestimo() { return dataEmprestimo; }
        public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
        public LocalDate getDataDevolucaoReal() { return dataDevolucaoReal; }
        public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
            this.dataDevolucaoReal = dataDevolucaoReal;
        }
    }

