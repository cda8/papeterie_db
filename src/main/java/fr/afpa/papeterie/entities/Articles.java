package fr.afpa.papeterie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="articles")
@Table(name="articles")
public class Articles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idarticle;
	private String reference;
	private String marque;
	private String designation;
	private float prixunitaire;
	private Integer qteStock;
	private Integer grammage;
	private String couleur;
	private String type;
	
	
	
	public Articles() {

	}

	public Articles(Integer idarticle, String reference, String marque, String designation, float prixUnitaire,
			Integer qteStock, Integer grammage, String couleur, String type) {
	
		this.idarticle = idarticle;
		this.reference = reference;
		this.marque = marque;
		this.designation = designation;
		this.prixunitaire = prixUnitaire;
		this.qteStock = qteStock;
		this.grammage = grammage;
		this.couleur = couleur;
		this.type = type;
	}

	public Articles(String reference, String marque, String designation, float prixUnitaire, Integer qteStock, Integer grammage,
			String couleur, String type) {
		
		this.reference = reference;
		this.marque = marque;
		this.designation = designation;
		this.prixunitaire = prixUnitaire;
		this.qteStock = qteStock;
		this.grammage = grammage;
		this.couleur = couleur;
		this.type = type;
	}

	public Integer getIdarticle() {
		return idarticle;
	}

	public void setIdarticle(Integer idarticle) {
		this.idarticle = idarticle;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public Integer getQteStock() {
		return qteStock;
	}

	public void setQteStock(Integer qteStock) {
		this.qteStock = qteStock;
	}

	public Integer getGrammage() {
		return grammage;
	}

	public void setGrammage(Integer grammage) {
		this.grammage = grammage;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public float getPrixunitaire() {
		return prixunitaire;
	}

	public void setPrixunitaire(float prixunitaire) {
		this.prixunitaire = prixunitaire;
	}

	@Override
	public String toString() {
		return "Articles [idarticle=" + idarticle + ", reference=" + reference + ", marque=" + marque + ", designation="
				+ designation + ", prixUnitaire=" + prixunitaire + ", qteStock=" + qteStock + ", grammage=" + grammage
				+ ", couleur=" + couleur + ", type=" + type + "]";
	}
	
	
	
	
}
