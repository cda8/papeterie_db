package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {

    private float montant;
    private List<Ligne> listLignes;

    public Panier() {
        this.listLignes = new ArrayList<>();
    }

    public float getMontant() {
        return montant;
    }

    public Ligne getLigne(int index) {

        return listLignes.get(index);

    }

    public void addLigne(Article article, int qte) {
        listLignes.add(new Ligne(qte, article));
    }

    public void updateLigne(int index, int newQte) {
        listLignes.get(index).setQte(newQte);
    }

    public void removeLigne(int index) {
        listLignes.remove(index);
    }

    public List<Ligne> getListLignes() {
        return listLignes;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Le panier est composé de : \n");

        for (Ligne element : listLignes) {
            sb.append("-\t")
                    .append(element.getArticle().toString())
                    .append("\tQuantité : ")
                    .append(element.getQte())
                    .append(".\n");

        }

        return sb.toString();
    }
}
