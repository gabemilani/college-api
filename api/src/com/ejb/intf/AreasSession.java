package com.ejb.intf;

import java.util.List;

import javax.ejb.Local;

import com.model.ejb.entity.Area;
import com.model.ejb.entity.Curso;
import com.model.ejb.entity.Disciplina;

@Local
public interface AreasSession {
	void remove(Area a);
	Area insere(Area a);
	Area altera(Area a);
	Area buscaPorId(Long id);
	List<Area> buscaTodos();
	List<Curso> buscaCursos(Area a);
	List<Disciplina> buscaDisciplinas(Area a);
}
