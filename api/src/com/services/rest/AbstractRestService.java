package com.services.rest;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRestService<T, D> {

	protected List<D> converteParaDTO(List<T> entidades) {
		List<D> dtos = new ArrayList<D>();
		for (T e : entidades) {
			D dto = converteParaDTO(e);			
			dtos.add(dto);
		}
		return dtos;
	}
	
	protected abstract D converteParaDTO(T entidade);
	
	protected abstract T converteParaEntidade(D dto);
}
