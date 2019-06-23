package com.ejb.intf;

import java.util.List;

import javax.ejb.Local;

import com.model.ejb.entity.Curso;

@Local
public interface CursosSession {
	void remove(Curso p);
	Curso insere(Curso p);
	Curso altera(Curso p);
	Curso buscaPorId(Long id);
	List<Curso> buscaTodos();		
}
