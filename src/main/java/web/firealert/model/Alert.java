package web.firealert.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Alert {

    @Id
    @SequenceGenerator(name="alert_seq", sequenceName="alert_codigo_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="alert_seq")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name ="alert_gravidade")
    @NotNull(message = "Informe a gravidade.")
    private Gravidade tipo;
    
    @NotBlank(message = "A descrição do ocorrido é fundamental.")
    @Size(min = 15, message = "Descreva com mais detalhes (mínimo 15 caracteres).")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "alert_status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "floresta_id") 
    private Floresta floresta;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Gravidade getTipo() {
        return tipo;
    }

    public void setTipo(Gravidade tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Floresta getFloresta() {
        return floresta;
    }

    public void setFloresta(Floresta floresta) {
        this.floresta = floresta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alert alert = (Alert) o;
        return id == alert.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
