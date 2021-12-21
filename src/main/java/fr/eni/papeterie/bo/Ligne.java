package fr.eni.papeterie.bo;

public class Ligne {
  private Article article;
  private int qte;

  public Ligne(Article article, int qte) {
    this.article = article;
    this.qte = qte;
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

  private void setArticle(Article article) {
    this.article = article;
  }

  public float getPrix() {
    return article.getPrixUnitaire() * qte;
  }

  @Override
  public String toString() {
    return "Ligne [article=" + article + ", qte=" + qte + "]";
  }

}
