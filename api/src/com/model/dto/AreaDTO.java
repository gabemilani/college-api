package com.model.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "area")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "nome", "sigla" } )
public class AreaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute
	private Long id;	
	
	@XmlAttribute
	private String nome;
	
	@XmlAttribute
	private String sigla;

	public AreaDTO() {
		super();
	}

	public AreaDTO(Long id, String nome, String sigla) {
		super();
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
}
