package com.nttdata.projetoSpring.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "DISCIPLINA")
@Entity(name = "DISCIPLINA")
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, length = 8, columnDefinition = "CHAR")
	private int id;

    @Column(name = "titulo", nullable = false, columnDefinition = "CHAR")
    private String titulo = "";

    @Column(name = "area", nullable = false, columnDefinition = "CHAR")
    private String area = "";

    @OneToMany(fetch = FetchType.LAZY)
    private List<ProfessorEntity> professores;
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public List<ProfessorEntity> getProfessores() {
        return professores;
    }

    public void setProfessores(List<ProfessorEntity> professores) {
        this.professores = professores;
    }
}
