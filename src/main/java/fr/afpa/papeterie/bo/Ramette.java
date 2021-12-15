package fr.afpa.papeterie.bo;

public class Ramette extends Article {
	private int grammage;

	public int getGrammage() {
		return grammage;
	}

	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	public Ramette() {
		super();
	}

	public Ramette(Integer idArticle, String marque,String ref, String designation, float pu, int qte,int grammage) {
		super(idArticle, marque,ref, designation, pu, qte);
		this.grammage=grammage;
	}

	public Ramette(String marque, String ref, String designation, float pu, int qte,int grammage) {
		super(marque, ref, designation, pu, qte);
		this.grammage=grammage;
	}

	@Override
	public String toString() {
		return "Ramette [ "+ super.toString() +" grammage=" + grammage+"]";
	}

	

	
}
