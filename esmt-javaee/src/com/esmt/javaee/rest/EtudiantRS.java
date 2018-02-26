package com.esmt.javaee.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esmt.javaee.ejb.EtudiantService;
import com.esmt.modele.entities.Etudiant;

@Path("etudiant")
public class EtudiantRS {
	@EJB
	private EtudiantService etudiantService;
	
	@Path("{id}") 
	@GET @Produces(MediaType.APPLICATION_XML)
	public Etudiant findById(@PathParam("id") Long id) {
		return etudiantService.findById(id);
	}
}
