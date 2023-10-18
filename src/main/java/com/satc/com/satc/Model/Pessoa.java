package com.satc.com.satc.Model;

public abstract class Pessoa extends EntityId{

    private String nome;
    private String telefone;
    private String endereco;
    private String email;

    public abstract String getDocumentoPrincipal();

    /** Getters **/
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    /** Setter**/

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
