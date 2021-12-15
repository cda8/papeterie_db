package fr.afpa.papeterie.dal.hibernate;


import fr.afpa.papeterie.entities.ArticlesEntity;

public class HibernateRunner {

	public static void main(String[] args) {
		
	//	
		
		ArticleDAOHibernate articleORM = new ArticleDAOHibernate();
		articleORM.getSession();
		
		System.out.println("---------------------------------------");
		ArticlesEntity a4 = new ArticlesEntity("Bic","BBOrange","Bic bille Orange",1.2f,20,null,"bleu","STYLO");
		articleORM.insert(a4);
		System.out.println("---------------------------------------");
		ArticlesEntity a5 = new ArticlesEntity("Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80,null,"RAMETTE");
		articleORM.insert(a5);
		System.out.println("---------------------------------------");
		ArticlesEntity a6 = new ArticlesEntity("Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20,null, "jaune","STYLO");
		articleORM.insert(a6);
		
		
		for(ArticlesEntity ae : articleORM.selectAll()) {
			System.out.println(ae);
		}
		
		a4.setCouleur("orange");
		articleORM.update(a4);
		System.out.println("\n --------------------------------------- \n");
		for(ArticlesEntity ae : articleORM.selectAll()) {
			System.out.println(ae);
		}
		System.out.println("\n --------------------------------------- \n");
		articleORM.delete(a6);
		for(ArticlesEntity ae : articleORM.selectAll()) {
			System.out.println(ae);
		}
		System.out.println("\n --------------------------------------- \n");
		System.out.println(articleORM.selectById(1));
		System.out.println("\n --------------------------------------- \n");
		for(ArticlesEntity ae : articleORM.selectByMarque("BBOrange")) {
		System.out.println(ae);
		}
		System.out.println("\n --------------------------------------- \n");
		for(ArticlesEntity ae : articleORM.selectByMotCle("Sup")) {
		System.out.println(ae);
		}
		
		articleORM.closeSession();
	}
		

}
