package web.firealert.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Floresta {
    @Id
    @SequenceGenerator(name="gerador2", sequenceName="pessoa_codigo_seq", allocationSize=1)
    @GeneratedValue(generator="gerador2", strategy= GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String endereco;
    ArrayList<Pessoa> pessoa;
    ArrayList<Alert> alert;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(ArrayList<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<Alert> getAlert() {
        return alert;
    }

    public void setAlert(ArrayList<Alert> alert) {
        this.alert = alert;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Floresta floresta = (Floresta) o;
        return id == floresta.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Floresta{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", endereco='" + endereco + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
