package fr.afpa.papeterie.dal.jdbc;

import fr.afpa.papeterie.entities.ArticlesEntity;

public class HibernateRunner {

	public static void main(String[] args) {

		ArticlesEntity a5 = new ArticlesEntity("Bic","BBOrange","Bic bille Orange",1.2f,20,null,"bleu","STYLO");
		ArticleDAOHibernate articleORM = new ArticleDAOHibernate();

		
		
		articleORM.getSession();
		articleORM.create(a5);
		a5.setCouleur("rouge");

		articleORM.update(a5);
		
		
		for (ArticlesEntity ae : articleORM.read()) {
			System.out.println(ae);
		}
		
		
		articleORM.closeSession();

	}
	
	

}
