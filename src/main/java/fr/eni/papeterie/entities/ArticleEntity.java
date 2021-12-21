package fr.eni.papeterie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "articles")
@Table(name = "articles")
public class ArticleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idArticle;
  private String marque;
  private String reference;
  private String designation;
  private float prixunitaire;
  private int qteStock;
  private Integer grammage;
  private String couleur;
  private String type;

  public ArticleEntity() {
  }

  /**
   * @constructor Ramette without id
   * @param marque
   * @param reference
   * @param designation
   * @param prixunitaire
   * @param qteStock
   * @param grammage
   * @param type
   */
  public ArticleEntity(String marque, String reference, String designation, float prixunitaire, int qteStock,
      Integer grammage,
      String type) {
    this.marque = marque;
    this.reference = reference;
    this.designation = designation;
    this.prixunitaire = prixunitaire;
    this.qteStock = qteStock;
    this.grammage = grammage;
    this.type = type;
  }

  /**
   * @constructor Ramette with id
   * @param idArticle
   * @param marque
   * @param reference
   * @param designation
   * @param prixunitaire
   * @param qteStock
   * @param grammage
   * @param type
   */
  public ArticleEntity(int idArticle, String marque, String reference, String designation, float prixunitaire,
      int qteStock,
      Integer grammage,
      String type) {
    this.idArticle = idArticle;
    this.marque = marque;
    this.reference = reference;
    this.designation = designation;
    this.prixunitaire = prixunitaire;
    this.qteStock = qteStock;
    this.grammage = grammage;
    this.type = type;
  }

  /**
   * @constructor Stylo without id
   * @param marque
   * @param reference
   * @param designation
   * @param prixunitaire
   * @param qteStock
   * @param couleur
   * @param type
   */
  public ArticleEntity(String marque, String reference, String designation, float prixunitaire, int qteStock,
      String couleur, String type) {
    this.marque = marque;
    this.reference = reference;
    this.designation = designation;
    this.prixunitaire = prixunitaire;
    this.qteStock = qteStock;
    this.couleur = couleur;
    this.type = type;
  }

  /**
   * @constructor Stylo with id
   * @param idArticle
   * @param marque
   * @param reference
   * @param designation
   * @param prixunitaire
   * @param qteStock
   * @param couleur
   * @param type
   */
  public ArticleEntity(int idArticle, String marque, String reference, String designation, float prixunitaire,
      int qteStock,
      String couleur, String type) {
    this.idArticle = idArticle;
    this.marque = marque;
    this.reference = reference;
    this.designation = designation;
    this.prixunitaire = prixunitaire;
    this.qteStock = qteStock;
    this.couleur = couleur;
    this.type = type;
  }

  public int getIdArticle() {
    return idArticle;
  }

  public void setIdArticle(int idArticle) {
    this.idArticle = idArticle;
  }

  public String getMarque() {
    return marque;
  }

  public void setMarque(String marque) {
    this.marque = marque;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public float getPrixUnitaire() {
    return prixunitaire;
  }

  public void setPrixUnitaire(float prixunitaire) {
    this.prixunitaire = prixunitaire;
  }

  public int getQteStock() {
    return qteStock;
  }

  public void setQteStock(int qteStock) {
    this.qteStock = qteStock;
  }

  public int getGrammage() {
    return grammage;
  }

  public void setGrammage(int grammage) {
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

  @Override
  public String toString() {
    return "ArticleEntity [couleur=" + couleur + ", designation=" + designation + ", grammage=" + grammage
        + ", idArticle=" + idArticle + ", marque=" + marque + ", prixunitaire=" + prixunitaire + ", qteStock="
        + qteStock + ", reference=" + reference + ", type=" + type + "]";
  }

}
