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
@Table(name = "Area")
@SequenceGenerator(name = "Area_Sequence", sequenceName = "area_seq", allocationSize = 0, initialValue = 1)
@NamedQueries({ 
	@NamedQuery(name = "busca.todas.areas", query = "select a from Area as a"),
	@NamedQuery(name = "busca.disciplinas.area", query = "select d from Disciplina as d where d.area = :area"),
	@NamedQuery(name = "busca.cursos.area", query = "select c from Disciplina as d JOIN d.curso c where d.area = :area")
})
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Area_Sequence")
	private Long id;
	
	@Column(name = "sigla", length = 10, nullable = true)
	private String sigla;
	
	@Column(name = "nome", length = 60, nullable = true)
	private String nome;
	
	public Area() {
		
	}
	
	public Area(Long id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
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
	
	public String getSigla() {
		return this.sigla;
	}
	
	public void setSigla(String sigla) { 
		this.sigla = sigla;
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
		Area other = (Area)obj;
		return id == other.id;
	}
}
