package fr.afpa.papeterie.dal.jdbc;

import fr.afpa.papeterie.entities.Articles;

public class HibernateRunner {

	public static void main(String[] args) {

		ArticleDAOHibernate articleORM = new ArticleDAOHibernate();


		// Ouverture de la session
		articleORM.getSession();

		//Creation d'un article

		//		Articles a5 = new Articles( "Bic","BBOrange","Bic bille Orange",1.2f,20,23,"bleu","STYLO");
		//		Articles a2 = new Articles(  "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80, "blanc", "ramette");
		//		Articles a3 = new Articles( "Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, 40,  "jaune", "Stylo");
		//		
		//		articleORM.create(a5);
		//		articleORM.create(a3);
		//articleORM.create(a2);

//		for(Articles art: articleORM.selectAll()) {
//			System.out.println(art);
//		}
//		
		System.out.println(articleORM.selectByMarque("legrand"));
		System.out.println(articleORM.selectByMotCle("a4"));
		System.out.println(articleORM.selectbyId(5));
		//articleORM.closeSession();


	}


}

