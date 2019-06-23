package com.ejb.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ws.api.annotation.WebContext;

import com.ejb.intf.DisciplinasSession;
import com.model.ejb.entity.Disciplina;

@Stateless
@WebService(name="disciplinas")
@WebContext(contextRoot="universidade")
public class DisciplinaSessionBean implements DisciplinasSession {

	@PersistenceContext(unitName="Universidade")
	private EntityManager em;
	
	@Override
	public void remove(Disciplina p) {
		Disciplina c = em.find(Disciplina.class, p.getId());
		if(c != null)
			em.remove(c);
	}

	@Override
	public Disciplina insere(Disciplina c) {
		em.persist(c);
		return c;
	}

	@Override
	public Disciplina altera(Disciplina c) {
		em.merge(c);
		return c;
	}

	@Override
	public Disciplina buscaPorId(Long id) {
		Disciplina c = em.find(Disciplina.class, id);
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> buscaTodos() {
		Query q = em.createNamedQuery("busca.todas.disciplinas");
		return q.getResultList();
	}
}
