package web.firealert.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Floresta {
    @Id
    @SequenceGenerator(name="floresta_seq", sequenceName="floresta_codigo_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="floresta_seq")
    private long id;
    @NotBlank(message = "O nome da área é obrigatório")
    @Size(min = 5, message = "O nome deve ter pelo menos 5 letras.")
    private String name;
    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @OneToMany(mappedBy = "floresta", cascade = CascadeType.ALL)
    private List<Pessoa> pessoa = new ArrayList<>();

    @OneToMany(mappedBy = "floresta", cascade = CascadeType.ALL)
    private List<Alert> alert = new ArrayList<>();

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

    public List<Pessoa> getPessoa() {
        return pessoa;
    }


    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

    public List<Alert> getAlert() {
        return alert;
    }

    public void setAlert(List<Alert> alert) {
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
