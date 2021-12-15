package fr.eni.papeterie.bo;

public class Ligne {
    private int qte;
    private Article article;

    public Ligne() {
    }

    public Ligne(int qte, Article article) {
        this.qte = qte;
        this.article = article;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * calculer le prix en multipliant le prix unitaire de l'article par la quantité
     * @return le tarif de la ligne.
     */
    public float getPrix(){
        return article.getPrixUnitaire() * qte;
    }

    @Override
    public String toString() {


        return "Ligne{" +
                "quantité = " + qte +
                ", article = " + article.getDesignation() +
                '}';
    }
}
