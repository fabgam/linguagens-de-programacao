package modelo;

import java.util.Objects;

public class Pessoa {

    private final int id_pessoa;
    private final String nome;
    private final String cpf;
    private final String rg;
    private final Contato contato;

    public Pessoa(int id_pessoa, String nome, String cpf, String rg, String telResidencial,
            String telCelular, String email, String whatsApp) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        contato = new Contato(id_pessoa, telResidencial, telCelular, email, whatsApp);
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

    public String getTelResidencial() {
        return this.contato.getTelResidencial();
    }

    public String getTelCelular() {
        return this.contato.getTelCelular();
    }

    public String getEmail() {
        return this.contato.getEmail();
    }

    public String getWhatsApp() {
        return this.contato.getWhatsApp();
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (!Objects.equals(this.contato, other.contato)) {
            return false;
        }
        return true;
    }
}
