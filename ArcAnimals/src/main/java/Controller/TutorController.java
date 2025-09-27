package Controller;

import Model.Tutor;

public class TutorController {
    public Tutor CadastrarTutor(String nome, int idade, String email, String contato, String endereco, String senha){
        return new Tutor(nome, idade, email, contato, endereco, senha);
    }
}
