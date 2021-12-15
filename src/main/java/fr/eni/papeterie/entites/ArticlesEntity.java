package fr.eni.papeterie.entites;


import javax.persistence.*;

@Entity(name="Articles")
@Table(name="Articles")
public class ArticlesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticle;
    private String reference;
    private String marque;
    private String designation;
    private float prixUnitaire;
    private int qteStock;
    private Integer grammage;
    private String couleur;
    private String type;

    public ArticlesEntity() {
    }

    public ArticlesEntity(String reference, String marque, String designation, float prixUnitaire, int qteStock, Integer gramme, String couleur, String type) {
        this.reference = reference;
        this.marque = marque;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.qteStock = qteStock;
        this.grammage = gramme;
        this.couleur = couleur;
        this.type = type;
    }

    public ArticlesEntity(int idArticle, String reference, String marque, String designation, float prixUnitaire, int qteStock, int gramme, String couleur, String type) {
        this.idArticle = idArticle;
        this.reference = reference;
        this.marque = marque;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.qteStock = qteStock;
        this.grammage = gramme;
        this.couleur = couleur;
        this.type = type;
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

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
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

    @Override
    public String toString() {
        return "Articles{" +
                "idArticle=" + idArticle +
                ", reference='" + reference + '\'' +
                ", marque='" + marque + '\'' +
                ", designation='" + designation + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                ", qteStock=" + qteStock +
                ", grammage=" + grammage +
                ", couleur='" + couleur + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
