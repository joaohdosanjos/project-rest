package com.nttdata.projetoSpring.model;



/* se o nome da tabela fosse exatamente o nome da classe (Aluno),
  o uso de Anottation seria opcional 
  obs: o mesmo vale para @Column*/

import javax.persistence.*;
import java.util.List;

@Table(name = "ALUNO")
@Entity(name = "ALUNO")
// se o nome da classe fosse igual ao nome da tabela, podia ficar só @Entity
public class AlunoEntity {

	@Id
	@Column(nullable=false, length = 8, columnDefinition = "CHAR")
	private String matricula;

	@Column(name = "cpf", nullable = false, unique = true, columnDefinition = "CHAR")
    // sendo o nome igual podia ficar:
	// 	@Column(nullable = false, unique = true, columnDefinition = "CHAR")
	private String cpf;

    private String nome;

	@Column(nullable=false, columnDefinition = "CHAR")
	private String sexo;

	@Column(nullable=false, columnDefinition = "CHAR")
	private String pne;

	private Integer escolaridade;

	private Integer idade;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "aluno")
	private List<AulaEntity> aulas;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getPne() {
		return pne;
	}

	public void setPne(String pne) {
		this.pne = pne;
	}

	public Integer getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Integer escolaridade) {
		this.escolaridade = escolaridade;
	}

	public List<AulaEntity> getAulas() {
		return aulas;
	}

	public void setAulas(List<AulaEntity> aulas) {
		this.aulas = aulas;
	}
}