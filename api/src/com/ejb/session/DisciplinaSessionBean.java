package com.ejb.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ws.api.annotation.WebContext;

import com.ejb.intf.DisciplinasSession;
import com.model.ejb.entity.Area;
import com.model.ejb.entity.Curso;
import com.model.ejb.entity.Disciplina;

@Stateless
@WebService(name="disciplinas")
@WebContext(contextRoot="universidade")
public class DisciplinaSessionBean implements DisciplinasSession {

	@PersistenceContext(unitName="Universidade")
	private EntityManager em;
	
	@Override
	public void remove(Disciplina d) {
		Disciplina c = em.find(Disciplina.class, d.getId());
		if(c != null)
			em.remove(c);
	}

	@Override
	public Disciplina insere(Disciplina d) {
		persistirRelacionamentos(d);
		em.persist(d);
		return d;
	}

	@Override
	public Disciplina altera(Disciplina d) {
		persistirRelacionamentos(d);		
		em.merge(d);
		return d;
	}
	
	private void persistirRelacionamentos(Disciplina d) {
		Curso c = d.getCurso();
		if (c != null) {
			boolean criar = true;
			Long id = c.getId();
			if (id != null) {
				Curso curso = em.find(Curso.class, id);
				if (curso != null) {
					d.setCurso(curso);
					criar = false;
				}				
			} 
			
			if (criar) {
				em.persist(c);
				d.setCurso(c);
			}
		}
		
		Area a = d.getArea();
		if (a != null) {
			boolean criar = true;
			Long id = a.getId();
			if (id != null) {
				Area area = em.find(Area.class, id);
				if (area != null) {
					d.setArea(area);
					criar = false;
				}
			} 
			
			if (criar) {
				em.persist(a);
				d.setArea(a);
			}
		}		
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
