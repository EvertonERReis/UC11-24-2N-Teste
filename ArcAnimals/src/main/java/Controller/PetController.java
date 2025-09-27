package Controller;

import Model.Pet;

public class PetController {

    public Pet CadastrarPet(String nome, String raca, int idade, String turno, String genero, String tutor, String porte){
        return new Pet(nome, idade, raca, turno, genero, tutor, porte);
    }


}
