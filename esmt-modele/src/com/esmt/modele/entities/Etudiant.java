package com.esmt.modele.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.esmt.modele.utils.EtudiantType;
import static com.esmt.modele.entities.Etudiant.ETUDIANT_GET_ALL;

import java.io.Serializable;

@NamedQueries({
	@NamedQuery(name = ETUDIANT_GET_ALL, query = "SELECT e FROM Etudiant e")
})

// @Entity(name="etud") 
@Entity(name="Etudiant")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Etudiant extends AbstractPersistent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ETUDIANT_GET_ALL = "Etudiant.getAll";
	
	@Column(name="prenom", length=50)
	private String prenom;
	//@Column(name="nom")
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name="etudiantType")
	private EtudiantType etudiantType;
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the etudiantType
	 */
	public EtudiantType getEtudiantType() {
		return etudiantType;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param etudiantType the etudiantType to set
	 */
	public void setEtudiantType(EtudiantType etudiantType) {
		this.etudiantType = etudiantType;
	}
}
