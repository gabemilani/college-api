package com.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Disciplina")
@SequenceGenerator(name = "Disciplina_Sequence", sequenceName = "disciplina_seq", allocationSize = 0, initialValue = 1)
@NamedQueries({ 
	@NamedQuery(name = "busca.todas.disciplinas", query = "select d from Disciplina as d")
})
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Disciplina_Sequence")
	private Long id;
	
	@Column(name = "codigo", nullable = true)
	private int codigo;
	
	@Column(name = "nome", length = 60, nullable = true)
	private String nome;
	
	@Column(name = "cargaHoraria", nullable = true)
	private int cargaHoraria;
	
	@ManyToOne
	@JoinColumn(name="curso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="area")
	private Area area;
	
	public Disciplina() {
		
	}
	
	public Disciplina(Long id, String nome, int codigo, int cargaHoraria, Curso curso, Area area) {
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.cargaHoraria = cargaHoraria;
		this.curso = curso;
		this.area = area;
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
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int codigo) { 
		this.codigo = codigo;
	}
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) { 
		this.cargaHoraria = cargaHoraria;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina)obj;
		return id == other.id;
	}
}
