package com.services.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ejb.intf.CursosSession;
import com.model.dto.CursoDTO;
import com.model.ejb.entity.Curso;

@Named("CursoRest")
@RequestScoped
@Path("cursos")
public class CursosRestService extends AbstractRestService<Curso, CursoDTO> {

	@EJB
	private CursosSession session;
	
	@Context
	UriInfo uriInfo;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProduto() {
		return Response.ok().entity(converteParaDTO(session.buscaTodos())).build();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProduto(@PathParam("id") Long id) {
		return Response.ok().entity(converteParaDTO(session.buscaPorId(id))).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response alteraProduto(@PathParam("id") Long id, CursoDTO dto) {
		Curso p = converteParaEntidade(dto);
		p.setId(id);
		session.altera(p);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeProduto(@PathParam("id") Long id) {
		Curso c = session.buscaPorId(id);
		if (c != null) { 
			session.remove(c);
		}
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insereProduto(CursoDTO dto) {
		Curso c = converteParaEntidade(dto);
		session.insere(c);
		if (c != null && c.getId() != null) {
			try {
				URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + c.getId());
				return Response.created(uri).build();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}		
		}
		
		return Response.noContent().build();
	}

	@Override
	protected CursoDTO converteParaDTO(Curso c) {
		if (c != null) {
			return new CursoDTO(c.getId(), c.getNome(), c.getCodigo());
		}
		return null;
	}

	@Override
	protected Curso converteParaEntidade(CursoDTO dto) {
		if (dto != null) {
			return new Curso(dto.getId(), dto.getNome(), dto.getCodigo());
		}
		return null;
	}	
}
