package web.firealert.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Alert {

    @Id
    @SequenceGenerator(name="gerador2", sequenceName="pessoa_codigo_seq", allocationSize=1)
    @GeneratedValue(generator="gerador2", strategy= GenerationType.SEQUENCE)
    private long id;
    private String tipo;

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
