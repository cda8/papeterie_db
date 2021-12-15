package fr.afpa.papeterie.bo;

import java.util.ArrayList;

public class Panier {
	private float montant;
	private ArrayList<Ligne>lignes=new ArrayList<Ligne>();
	
	public Panier() {}

	public float getMontant() {
		for(Ligne l : lignes) {
		montant += l.getPrix();}
		return montant;
	}

	public ArrayList<Ligne> getLignes() {
		return lignes;
	} 
	public Ligne getLigne(int index) {
		return lignes.get(index);
	}
	public void addLigne(Article article, int qte) {
		lignes.add(new Ligne(article,qte));
	}
	public void removeLigne(int index) {
		lignes.remove(index);
	}
	public void updateLigne(int index,int newQte) {
		Ligne l = new Ligne(getLigne(index).getArticle(),newQte);
		lignes.set(index,l);
	}

	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Ligne l :lignes) {
			sb.append(l.toString())
			.append("\n");
		};
		
		return sb+"Le montant du panier est de "+getMontant();
	}
}
