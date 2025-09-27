package Model;

import java.util.ArrayList;
import java.util.List;

public class Creche {
    String nome = "ArcAnimals";
    String endereco = "Aqui mesmo";
    String contato = "Extraterrestre";
    List<Tutor> clientes = new ArrayList<>();
    List<Pet> alunos = new ArrayList<>();

    public Creche() {}

    public void CadastrarTutor(Tutor tutor){
        clientes.add(tutor);
        this.CadastarPets(tutor.pets);
    }

    public void CadastarPets(List<Pet> pets){
        alunos.addAll(pets);
    }
}
