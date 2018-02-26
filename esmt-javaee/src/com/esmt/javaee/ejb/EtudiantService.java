package com.esmt.javaee.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esmt.modele.entities.Etudiant;

@Stateless
public class EtudiantService {
	@PersistenceContext(unitName="scolaireService")
	private EntityManager em;
	
	public Long create(Etudiant etudiant) {
		//persit - Make an instance managed and persistent
		em.persist(etudiant); // C'est un objet immuable, on a pas besoin de faire un variable = pour que ca soit mis à jour
		return etudiant.getId();
	}
	
	public void edit(Etudiant etudiant) {
		//merge -  Returns the managed instance that the state was merged to
		// merge the state of the given entity into the current persistent context
		em.merge(etudiant);
	}
	
	public void delete(Etudiant etudiant) {
		// En réalité on fait une modification (Qui ne produit aucun résultat) puis on utilise l'objet
		// utilisé pour faire la suppression
		etudiant = em.merge(etudiant); // Il est conseillé d'attacher l'objet avant de le supprimer
		em.remove(etudiant);
	}
	
	public Etudiant findById(Long id) {
		return em.find(Etudiant.class, id);
//		Etudiant etudiant = em.find(Etudiant.class, id);
//		return etudiant;
	}
	
	public List<Etudiant> getAll () {
		Query query = em.createNamedQuery(Etudiant.ETUDIANT_GET_ALL);
		@SuppressWarnings("unchecked")
		List<Etudiant> list = query.getResultList();
		return list;
	}
}
