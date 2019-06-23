package com.services.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.model.dto.AreaDTO;
import com.model.dto.CursoDTO;
import com.model.dto.DisciplinaDTO;
import com.model.ejb.entity.Area;
import com.model.ejb.entity.Curso;
import com.model.ejb.entity.Disciplina;

public class Mappers {
	public static <T,D> List<D> converterLista(List<T> lista, Function<T, D> conversor) {
		List<D> resultado = new ArrayList<D>();
		for (T l : lista) {
			D d = conversor.apply(l);
			resultado.add(d);
		}
		return resultado;
	}
	
	public static AreaDTO converteParaDTO(Area c) {
		if (c != null) {
			return new AreaDTO(c.getId(), c.getNome(), c.getSigla());
		}
		return null;
	}

	public static Area converteParaEntidade(AreaDTO dto) {
		if (dto != null) {
			return new Area(dto.getId(), dto.getNome(), dto.getSigla());
		}
		return null;
	}	
	
	public static CursoDTO converteParaDTO(Curso c) {
		if (c != null) {
			return new CursoDTO(c.getId(), c.getNome(), c.getCodigo());
		}
		return null;
	}

	public static Curso converteParaEntidade(CursoDTO dto) {
		if (dto != null) {
			return new Curso(dto.getId(), dto.getNome(), dto.getCodigo());
		}
		return null;
	}	
	
	public static DisciplinaDTO converteParaDTO(Disciplina d) {
		if (d != null) {
			return new DisciplinaDTO(d.getId(), d.getNome(), d.getCodigo(), d.getCargaHoraria(), converteParaDTO(d.getCurso()), converteParaDTO(d.getArea()));
		}
		return null;
	}
	
	public static Disciplina converteParaEntidade(DisciplinaDTO dto) {
		if (dto != null) {
			return new Disciplina(dto.getId(), dto.getNome(), dto.getCodigo(), dto.getCargaHoraria(), converteParaEntidade(dto.getCurso()), converteParaEntidade(dto.getArea()));
		}
		return null;
	}
}
