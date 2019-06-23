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

import com.ejb.intf.AreasSession;
import com.model.dto.AreaDTO;
import com.model.ejb.entity.Area;

@Named("AreaRest")
@RequestScoped
@Path("areas")
public class AreasRestService extends AbstractRestService<Area, AreaDTO> {

	@EJB
	private AreasSession session;
	
	@Context
	UriInfo uriInfo;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response get() {
		return Response.ok().entity(converteParaDTO(session.buscaTodos())).build();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPorId(@PathParam("id") Long id) {
		return Response.ok().entity(converteParaDTO(session.buscaPorId(id))).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response altera(@PathParam("id") Long id, AreaDTO dto) {
		Area p = converteParaEntidade(dto);
		p.setId(id);
		session.altera(p);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") Long id) {
		Area c = session.buscaPorId(id);
		if (c != null) { 
			session.remove(c);
		}
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insere(AreaDTO dto) {
		Area c = converteParaEntidade(dto);
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
	protected AreaDTO converteParaDTO(Area c) {
		if (c != null) {
			return new AreaDTO(c.getId(), c.getNome(), c.getSigla());
		}
		return null;
	}

	@Override
	protected Area converteParaEntidade(AreaDTO dto) {
		if (dto != null) {
			return new Area(dto.getId(), dto.getNome(), dto.getSigla());
		}
		return null;
	}	
}
