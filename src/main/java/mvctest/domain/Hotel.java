package mvctest.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String idade;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String temperaturaMax;

	@Column(nullable = false)
	private String temperaturaMin;

	public Hotel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(String temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public String getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(String temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

}