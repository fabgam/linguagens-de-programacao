package modelo;

import java.util.Objects;

public class Pessoa {

    private final int id_pessoa;
    private final String nome;
    private final String cpf;
    private final String rg;

    public Pessoa(int id_pessoa, String nome, String cpf, String rg) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getRg() {
        return this.rg;
    }

    @Override
    public String toString() {
        return "ID = " + getId_pessoa() + " => " + getNome() + " CPF => " + getCpf() + " RG => " + getRg();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.id_pessoa != other.id_pessoa) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }
}
