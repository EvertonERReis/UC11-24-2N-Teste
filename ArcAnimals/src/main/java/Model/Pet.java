package Model;

public class Pet {
    String nome;
    String raca;
    int idade;
    String turno;
    String[] frequencia;
    String genero;
    String porte;
    String tutor;

    public Pet(String nome, int idade, String turno, String raca, String genero, String tutor, String porte) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.turno = turno;
        this.genero = genero;
        this.porte = porte;
        this.tutor = tutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String[] getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String[] frequencia) {
        this.frequencia = frequencia;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}
