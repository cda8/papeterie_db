package fr.afpa.papeterie.bo;

public class Stylo extends Article {
	private String couleur;

	public Stylo() {
		super();
	}

	public Stylo(Integer idArticle, String marque,String ref, String designation, float pu, int qte, String couleur) {
		super(idArticle, marque, ref, designation, pu, qte);
		this.couleur=couleur;
	}

	public Stylo(String marque, String ref, String designation, float pu, int qte, String couleur) {
		super(marque, ref, designation, pu, qte);
		this.couleur=couleur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Stylo [ "+ super.toString() + " couleur=" + couleur +"]";
	}
	

}
