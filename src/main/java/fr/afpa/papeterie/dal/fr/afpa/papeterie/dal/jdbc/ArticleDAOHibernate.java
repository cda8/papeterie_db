package fr.afpa.papeterie.dal.jdbc;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.afpa.papeterie.entities.ArticlesEntity;
import fr.afpa.papeterie.entities.utils.HibernateUtils;

public class ArticleDAOHibernate {
	private static Session session;
	
	
	public void getSession() {
		if(session==null) {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			session= factory.openSession();
		}
	}
	
	public void closeSession() {
		if( session != null) {
			session.close();
		}
	}
	
	public void create(ArticlesEntity a) {
	getSession();
	System.out.println("Enregistrement d'un article...");
	session.beginTransaction();
	session.save(a);
	session.getTransaction().commit();
}
	
	public List<ArticlesEntity> read() {
		System.out.println("lecture des articles...");
		
		String HQL = "from articles";
		List<ArticlesEntity> articleslist = session.createQuery(HQL, ArticlesEntity.class).getResultList();
		return articleslist;
		
	}
	
	
	public void update(ArticlesEntity article) {
		System.out.println("modification de l'article "+article.getIdarticle());

		
		session.beginTransaction();
		session.saveOrUpdate(article);
		session.getTransaction().commit();
	}
	
	
	public void delete(ArticlesEntity article) {
		System.out.println("modification de l'article "+article.getIdarticle());

		
		session.beginTransaction();
		session.delete(article);
		session.getTransaction().commit();
		
		
	}
	
	public ArticlesEntity selectById(int id) {
	    System.out.println("Selection de l'article avec l'id :"+id);
	    String HQL = "select a from articles a  where a.idArticle =:id";
	    Query <ArticlesEntity> query = session.createQuery(HQL,ArticlesEntity.class);
	    query.setParameter("id",id);
	    return query.getSingleResult();
	}
}
