package modelo;

import java.util.Objects;

public class Contato {

    private final int id_contato;
    private final String telResidencial;
    private final String telCelular;
    private final String email;
    private final String whatsApp;

    public Contato(int id_contato, String telResidencial, String telCelular, String email, String whatsApp) {
        this.id_contato = id_contato;
        this.telResidencial = telResidencial;
        this.telCelular = telCelular;
        this.email = email;
        this.whatsApp = whatsApp;
    }

    public int getId_contato() {
        return id_contato;
    }

    public String getTelResidencial() {
        return this.telResidencial;
    }

    public String getTelCelular() {
        return this.telCelular;
    }

    public String getEmail() {
        return this.email;
    }

    public String getWhatsApp() {
        return this.whatsApp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Contato other = (Contato) obj;
        if (this.id_contato != other.id_contato) {
            return false;
        }
        if (!Objects.equals(this.telResidencial, other.telResidencial)) {
            return false;
        }
        if (!Objects.equals(this.telCelular, other.telCelular)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.whatsApp, other.whatsApp)) {
            return false;
        }
        return true;
    }
}
