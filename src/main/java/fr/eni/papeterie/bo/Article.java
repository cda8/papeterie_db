package fr.eni.papeterie.bo;

public class Article {
  private int idArticle;
  private String marque;
  private String reference;
  private String designation;
  private float prixunitaire;
  private int qteStock;

  public Article() {
  }

  public Article(int idArticle, String marque, String reference, String designation, float prixunitaire, int qteStock) {
    this.idArticle = idArticle;
    this.marque = marque;
    this.reference = reference;
    this.designation = designation;
    this.prixunitaire = prixunitaire;
    this.qteStock = qteStock;
  }

  public Article(String marque, String reference, String designation, float prixunitaire, int qteStock) {
    this.marque = marque;
    this.reference = reference;
    this.designation = designation;
    this.prixunitaire = prixunitaire;
    this.qteStock = qteStock;
  }

  public int getIdArticle() {
    return idArticle;
  }

  public void setIdArticle(int idArticle) {
    this.idArticle = idArticle;
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

  public float getPrixunitaire() {
    return prixunitaire;
  }

  public void setPrixunitaire(float prixunitaire) {
    this.prixunitaire = prixunitaire;
  }

  public int getQteStock() {
    return qteStock;
  }

  public void setQteStock(int qteStock) {
    this.qteStock = qteStock;
  }

  @Override
  public String toString() {
    return "Article [designation=" + designation + ", idArticle=" + idArticle + ", marque=" + marque + ", prixunitaire="
        + prixunitaire + ", qteStock=" + qteStock + ", reference=" + reference + "]";
  }

}
