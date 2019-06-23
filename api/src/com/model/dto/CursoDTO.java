package com.model.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "curso")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "nome", "codigo" } )
public class CursoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute
	private Long id;	
	
	@XmlAttribute
	private String nome;
	
	@XmlAttribute
	private int codigo;

	public CursoDTO() {
		super();
	}

	public CursoDTO(Long id, String nome, int codigo) {
		super();
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
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
