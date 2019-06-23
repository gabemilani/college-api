package com.ejb.intf;

import java.util.List;

import javax.ejb.Local;

import com.model.ejb.entity.Disciplina;

@Local
public interface DisciplinasSession {
	void remove(Disciplina p);
	Disciplina insere(Disciplina p);
	Disciplina altera(Disciplina p);
	Disciplina buscaPorId(Long id);
	List<Disciplina> buscaTodos();
}
