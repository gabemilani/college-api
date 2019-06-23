package com.ejb.intf;

import java.util.List;

import javax.ejb.Local;

import com.model.ejb.entity.Curso;
import com.model.ejb.entity.Disciplina;

@Local
public interface CursosSession {
	void remove(Curso c);
	Curso insere(Curso c);
	Curso altera(Curso c);
	Curso buscaPorId(Long id);
	List<Curso> buscaTodos();
	List<Disciplina> buscaDisciplinas(Curso c);
}
