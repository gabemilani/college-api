package com.ejb.intf;

import java.util.List;

import javax.ejb.Local;

import com.model.ejb.entity.Area;

@Local
public interface AreasSession {
	void remove(Area p);
	Area insere(Area p);
	Area altera(Area p);
	Area buscaPorId(Long id);
	List<Area> buscaTodos();		
}
