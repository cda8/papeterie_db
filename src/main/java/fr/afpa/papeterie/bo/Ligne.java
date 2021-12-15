package fr.afpa.papeterie.bo;

public class Ligne {
	private int qte;
	private Article article;
	public Ligne(Article article,int qte) {
		this.article=article;
		this.qte=qte;
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
	public float getPrix() {
		return this.article.getPrixUnitaire()*this.qte;
	}
	
	@Override
	public String toString() {
		return this.article+" est commandé. Quantité : "+qte+". Prix total : "+getPrix();
	}
	
	
}
