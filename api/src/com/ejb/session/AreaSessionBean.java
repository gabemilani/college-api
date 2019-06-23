package com.ejb.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ws.api.annotation.WebContext;

import com.ejb.intf.AreasSession;
import com.model.ejb.entity.Area;
import com.model.ejb.entity.Curso;
import com.model.ejb.entity.Disciplina;

@Stateless
@WebService(name="areas")
@WebContext(contextRoot="universidade")
public class AreaSessionBean implements AreasSession {

	@PersistenceContext(unitName="Universidade")
	private EntityManager em;
	
	@Override
	public void remove(Area a) {
		Area c = em.find(Area.class, a.getId());
		if(c != null)
			em.remove(c);
	}

	@Override
	public Area insere(Area c) {
		em.persist(c);
		return c;
	}

	@Override
	public Area altera(Area c) {
		em.merge(c);
		return c;
	}

	@Override
	public Area buscaPorId(Long id) {
		Area c = em.find(Area.class, id);
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Area> buscaTodos() {
		Query q = em.createNamedQuery("busca.todas.areas");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> buscaCursos(Area a) {
		Query q = em.createNamedQuery("busca.cursos.area").setParameter("area", a);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> buscaDisciplinas(Area a) {
		Query q = em.createNamedQuery("busca.disciplinas.area").setParameter("area", a);
		return q.getResultList();
	}
}
