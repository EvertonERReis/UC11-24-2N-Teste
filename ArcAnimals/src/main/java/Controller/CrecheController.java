package Controller;

import Model.Creche;
import Model.Pet;
import Model.Tutor;

import java.util.List;

public class CrecheController {
    public void CadastrarTudo(Tutor tutor, List<Pet> pet, Creche creche){
        creche.CadastrarTutor(tutor);
        creche.CadastarPets(pet);
    }
}
