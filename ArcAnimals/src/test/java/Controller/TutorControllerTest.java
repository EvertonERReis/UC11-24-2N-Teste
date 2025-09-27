package Controller;

import Model.Creche;
import Model.Pet;
import Model.Tutor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TutorControllerTest {

    @Test
    void cadastrarTutor() {
        String nome = "João";
        int idade = 18 ;
        String contato = "998765432";
        String email = ": joao@email.com";
        String endereco = "Rua das Águas 33";
        List<Pet> pets = new ArrayList<>();
        String senha = "123456";

        Tutor tutor = new Tutor(nome,idade,contato,email,endereco,senha);

        assertEquals("João", tutor.getNome(), "O nome deveria estar correto!");

    }
}