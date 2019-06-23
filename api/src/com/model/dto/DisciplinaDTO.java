package com.model.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "disciplina")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "nome", "codigo", "cargaHoraria", "curso", "area" } )
public class DisciplinaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute
	private Long id;	
	
	@XmlAttribute
	private String nome;
	
	@XmlAttribute
	private int codigo;
	
	@XmlAttribute
	private int cargaHoraria;
	
	@XmlElement
	private CursoDTO curso;
	
	@XmlElement
	private AreaDTO area;

	public DisciplinaDTO() {
		super();
	}

	public DisciplinaDTO(Long id, String nome, int codigo, int cargaHoraria, CursoDTO curso, AreaDTO area) {
		super();
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
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public CursoDTO getCurso() {
		return curso;
	}
	
	public void setCurso(CursoDTO curso) {
		this.curso = curso;
	}
	
	public AreaDTO getArea() {
		return area;
	}
	
	public void setArea(AreaDTO area) {
		this.area = area;
	}
}
