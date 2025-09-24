package org.example;

public class ClasseLivro {

    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponivel;
    private int anoPublicacao;

    public ClasseLivro(String isbn, String titulo, String autor, int anoPublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    // Getters e Setters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isDisponivel() { return disponivel; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}

