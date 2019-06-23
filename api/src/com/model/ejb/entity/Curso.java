package com.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Curso")
@SequenceGenerator(name = "Curso_Sequence", sequenceName = "curso_seq", allocationSize = 0, initialValue = 1)
@NamedQueries({ 
	@NamedQuery(name = "busca.todos.cursos", query = "select c from Curso as c") 
})
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Curso_Sequence")
	private Long id;
	
	@Column(name = "codigo", nullable = true)
	private int codigo;
	
	@Column(name = "nome", length = 60, nullable = true)
	private String nome;
	
	public Curso() {
		
	}
	
	public Curso(Long id, String nome, int codigo) {
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
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
		Curso other = (Curso)obj;
		return id == other.id;
	}
}
