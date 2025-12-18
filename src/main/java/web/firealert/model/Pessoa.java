package web.firealert.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="gerador2", sequenceName="pessoa_codigo_seq", allocationSize=1)
	@GeneratedValue(generator="gerador2", strategy=GenerationType.SEQUENCE)
	private Long codigo;
	@NotBlank(message = "O nome do colaborador é obrigatório.")
	@Size(min = 15, message = "Preencha o nome completo.")
	private String nome;
	@NotBlank(message = "O CPF é obrigatório.")
	@Pattern(regexp = "\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido. Use apenas números ou formato padrão.")
	private String cpf;
	@NotBlank(message = "O telefone é obrigatório para contato.")
	@Pattern(regexp = "\\d{10,11}", message = "O telefone deve ter apenas números (DDD + Número), entre 10 e 11 dígitos.")
	private String telefone;

	
	@Enumerated(EnumType.STRING)
	@Column(name = "pessoa_tipo")
	@NotNull(message = "Selecione uma função.")
	private TipoUsuario tipo;

	

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "floresta_id") //
    private Floresta floresta;


	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    public Floresta getFloresta() {
        return floresta;
    }

    public void setFloresta(Floresta floresta) {
        this.floresta = floresta;
    }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + "\nnome: " + nome + "\ncpf: " + cpf + "\ndataNascimento: " + dataNascimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
