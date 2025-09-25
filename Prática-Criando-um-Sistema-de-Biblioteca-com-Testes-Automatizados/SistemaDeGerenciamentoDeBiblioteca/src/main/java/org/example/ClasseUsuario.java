package org.example;

public class ClasseUsuario {

        private String id;
        private String nome;
        private String email;
        private boolean possuiMulta;

        public ClasseUsuario(String id, String nome, String email) {
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.possuiMulta = false;
        }

        // Getters e Setters
        public String getId() { return id; }
        public String getNome() { return nome; }
        public String getEmail() { return email; }
        public boolean isPossuiMulta() { return possuiMulta; }
        public void setPossuiMulta(boolean possuiMulta) { this.possuiMulta = possuiMulta; }
    }

