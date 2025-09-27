package Model;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    String nome;
    int idade;
    String contato;
    String email;
    String endereco;
    List<Pet> pets = new ArrayList<>();
    String senha;

    public Tutor(String nome, int idade, String contato, String email, String endereco, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.contato = contato;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Pet> getPet() {
        return pets;
    }

    public void setPet(Pet pet) {
        this.pets.add(pet);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
