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
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import com.ejb.intf.DisciplinasSession;
import com.model.dto.DisciplinaDTO;
import com.model.ejb.entity.Disciplina;

@Named("DisciplinaRest")
@RequestScoped
@Path("disciplinas")
public class DisciplinasRestService {

	@EJB
	private DisciplinasSession session;
	
	@Context
	UriInfo uriInfo;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response get() {
		return Response.ok().entity(Mappers.converterLista(session.buscaTodos(), d -> Mappers.converteParaDTO(d))).build();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPorId(@PathParam("id") Long id) {
		ResponseBuilder r = null;		
		Disciplina d = session.buscaPorId(id);
		if (d != null) {
			r = Response.ok().entity(Mappers.converteParaDTO(d));			
		} else {
			r = Response.status(Response.Status.NOT_FOUND).entity("Disciplina nao encontrada");
		}
		return r.build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response altera(@PathParam("id") Long id, DisciplinaDTO dto) {
		Disciplina p = Mappers.converteParaEntidade(dto);
		p.setId(id);
		session.altera(p);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") Long id) {
		Disciplina c = session.buscaPorId(id);
		if (c != null) { 
			session.remove(c);
		}
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insere(DisciplinaDTO dto) {
		Disciplina c = Mappers.converteParaEntidade(dto);
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
}
