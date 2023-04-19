package com.nttdata.projetoSpring.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "PROFESSOR")
@Entity(name = "PROFESSOR")
public class ProfessorEntity  {

    @Id
    @Column(name = "cpf", nullable = false, unique = true, columnDefinition = "CHAR")
    private String cpf;

    @Column(name = "nome", nullable = false, columnDefinition = "CHAR")
    private String nome;

    @Column(name = "sexo", columnDefinition = "CHAR")
    private String sexo;

    @Column(name = "idade")
    private int idade;

    @Column(name = "tempo_ensino", columnDefinition = "CHAR")
    private int tempoEnsino;

    @OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.PERSIST, mappedBy = "professor")
    private List<AulaEntity> aulas;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = true)
    private DisciplinaEntity disciplina;

    @Column(name = "salario", columnDefinition = "CHAR")
    private BigDecimal salario;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getTempoEnsino() {
        return tempoEnsino;
    }

    public void setTempoEnsino(int tempoEnsino) {
        this.tempoEnsino = tempoEnsino;
    }

    public DisciplinaEntity getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaEntity disciplina) {
        this.disciplina = disciplina;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public List<AulaEntity> getAulas() {
        return aulas;
    }

    public void setAulas(List<AulaEntity> aulas) {
        this.aulas = aulas;
    }
}
