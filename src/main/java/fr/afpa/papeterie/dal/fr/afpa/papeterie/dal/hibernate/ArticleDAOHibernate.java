package fr.afpa.papeterie.dal.hibernate;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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
		if(session!=null) {
			session.close();
		}
	}
	
public void insert(ArticlesEntity a) {
	System.out.println("Enregistrement d'un article...");
	session.beginTransaction();
	session.save(a);
	session.getTransaction().commit();
}


public List<ArticlesEntity> selectAll(){
	System.out.println("Lecture des articles...");
	
	String HQL = "from articles";
	List<ArticlesEntity> articlesList = session.createQuery(HQL,ArticlesEntity.class).getResultList();
	
	/*String HQL = "select a from articles a where a.idArticle=:monId";
	Query<ArticlesEntity> query = session.createQuery(HQL,ArticlesEntity.class);
	query.setParameter("monId", 36);
	List<ArticlesEntity> articlesList = query.getResultList();*/
		
	return articlesList;
}

public void update(ArticlesEntity ae) {
	System.out.println("Mise à jour d'un article...");
	
	session.beginTransaction();
	session.saveOrUpdate(ae);
	session.getTransaction().commit();
}

//public ArticlesEntity getArticleFromSession(int id) {
//	return (ArticlesEntity) session.get(ArticlesEntity.class, id);
//}
public void delete(ArticlesEntity article) {
	System.out.println("Suppression de l'article...");
	
	session.beginTransaction();
	session.delete(article);
	session.getTransaction().commit();
}

public List<ArticlesEntity> selectByMarque(String marque){
	System.out.println("Selection des articles de la marque "+marque);
	String HQL = "select a from articles a  where a.marque =:m";
	Query <ArticlesEntity> query = session.createQuery(HQL,ArticlesEntity.class);
	query.setParameter("m",marque);
	return query.getResultList();
}

public List<ArticlesEntity> selectByMotCle(String mot){
	System.out.println("Selection des articles contenant le mot clé "+mot);
	String HQL = "select a from articles a where a.marque LIKE : motcle OR a.designation LIKE : motcle";
	Query <ArticlesEntity> query = session.createQuery(HQL,ArticlesEntity.class);
	String motcle = "%"+mot+"%";
	query.setParameter("motcle", motcle);
	return query.getResultList();
}

public ArticlesEntity selectById(int id) {
	System.out.println("Selection de l'article avec l'id :"+id);
	String HQL = "select a from articles a  where a.idarticle =:id";
	Query <ArticlesEntity> query = session.createQuery(HQL,ArticlesEntity.class);
	query.setParameter("id",id);
	return query.getSingleResult();
}



}
