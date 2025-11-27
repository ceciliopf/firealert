package web.firealert.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Alert {

    @Id
    @SequenceGenerator(name="alert_seq", sequenceName="alert_codigo_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="alert_seq")
    private long id;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "floresta_id") // Isso cria a coluna na tabela do banco
    private Floresta floresta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
