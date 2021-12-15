package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
  private float montant;
  private List<Ligne> lignesPanier;

  public Panier() {
    this.lignesPanier = new ArrayList<>();
  }

  public float getMontant() {
    for (Ligne ligne : lignesPanier) {
      this.montant += ligne.getPrix();
    }
    return montant;
  }

  public Ligne getLigne(int index) {
    return lignesPanier.get(index);
  }

  public List<Ligne> getLignesPanier() {
    return lignesPanier;
  }

  public void addLigne(Article article, int qte) {
    Ligne ligne = new Ligne(article, qte);
    lignesPanier.add(ligne);
  }

  public void updateLigne(int index, int newQte) {
    Ligne ligne = lignesPanier.get(index);
    ligne.setQte(newQte);
  }

  public void removeLigne(int index) {
    lignesPanier.remove(index);
  }

  @Override
  public String toString() {
    return "Panier =\n" + lignesPanier + "\nValeur du panier = " + getMontant();
  }

}
