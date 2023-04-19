package com.nttdata.projetoSpring.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "AULA")
@Entity(name = "AULA")
public class AulaEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false, length = 8, columnDefinition = "CHAR")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "professor_cpf", columnDefinition = "CHAR")
	private ProfessorEntity professor;

	@ManyToOne()
	@JoinColumn(name = "aluno_matricula", columnDefinition = "CHAR")
	private AlunoEntity aluno;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	private BigDecimal media;

	private BigDecimal duracao;

	private BigDecimal valor;

	private String resultado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProfessorEntity getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorEntity professor) {
		this.professor = professor;
	}

	public AlunoEntity getAluno() {
		return aluno;
	}

	public void setAluno(AlunoEntity aluno) {
		this.aluno = aluno;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getMedia() {
		return media;
	}

	public void setMedia(BigDecimal media) {
		this.media = media;
	}

	public BigDecimal getDuracao() {
		return duracao;
	}

	public void setDuracao(BigDecimal duracao) {
		this.duracao = duracao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}