package com.esmt.javaee.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.esmt.javaee.ejb.EtudiantService;
import com.esmt.modele.entities.Etudiant;

@ ConversationScoped
@Named("etudiantController")
public class EtudiantController implements Serializable{
	private static final long serialVersionUID=1l;
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	private Etudiant etudiant;
	@EJB
	private EtudiantService etudiantService;
	@Inject
	private Conversation conversation;
	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest)FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String sId=request.getParameter("id");
		if(sId==null) {
			etudiant = new Etudiant();
		}
		else {
			id=Long.parseLong(sId);
			etudiant=etudiantService.findById(id);
		}
		conversation.begin();
	}
	public void create() {
		etudiantService.create(etudiant);
		//permet de vider les données sur les champs
		etudiant= new Etudiant();
		conversation.end();
	}
	public void delete(Etudiant etudiant) {
		etudiantService.delete(etudiant);
		conversation.end();
	}
	public List<Etudiant>getLines(){
		return etudiantService.getAll();
	}
	public String edit() {
		etudiantService.edit(etudiant);
		conversation.end();
		return "list-etudiant.xhtml";
	}
	

	public EtudiantController() {
		// TODO Auto-generated constructor stub
	}

}