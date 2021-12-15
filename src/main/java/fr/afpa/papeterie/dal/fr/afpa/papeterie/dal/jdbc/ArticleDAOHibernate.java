package fr.afpa.papeterie.dal.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.afpa.papeterie.entities.Articles;
import fr.afpa.papeterie.entities.utils.HibernateUtils;

public class ArticleDAOHibernate {
	
	private static Session session;
	
	
	
public void getSession() {
		if(session==null) {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			session= factory.openSession();
		}
	}
	
public void create(Articles a) {
	
	System.out.println("Enregistrement d'un article...");
	session.beginTransaction();
	session.save(a);
	session.getTransaction().commit();
}

public void closeSession( ) {
	if(session !=null) {
		session.close();
	}
}


//Selection de tout les articles
	
	public List<Articles> selectAll(){
	System.out.println("Selection de touts les articles ");
	String HQL = "from articles";
	List<Articles> articlesList = session.createQuery (HQL, Articles.class).getResultList();
	return articlesList;
	}
	
// methode Update (modifie les attributs d'un article):**************************************************************************************************************
	
	public void update ( Articles article) {
		session.beginTransaction();
		session.saveOrUpdate(article);
		session.getTransaction().commit();
	}
	
// Methode Insert (ajoute un article en base de donnée):***************************************************************************************************************
	
	public void insert(Articles article) {
		session.beginTransaction();
		session.save(article);
		session.getTransaction().commit();
	}
	
	
// Methode Delete : ***************************************************************************************************************
	
	public void delete(Articles article) {
		session.beginTransaction();
		session.delete(article);
		session.getTransaction().commit();
		
	}
	
	// Methode SelectByMarque :********************************************************************************************************
	
	
	public List<Articles> selectByMarque(String marque) {
		String HQL = "from articles where LOWER(marque) = :marque";
		List<Articles> articlesList = session.createQuery (HQL, Articles.class).setParameter("marque",marque.toLowerCase()).getResultList();
		return articlesList;
		
	}
	
	
	
	
// Methode SelectByMotClé :********************************************************************************************************
	

public List<Articles> selectByMotCle(String motcle) {
	String HQL = "from articles where  LOWER(marque) = :motcle or LOWER(designation) like :motcle";
	List<Articles> articlesList = session.createQuery (HQL, Articles.class).setParameter("motcle","%" +motcle.toLowerCase() +"%").getResultList();
	return articlesList;
	
}

// Methode SelectById :***************************************************************************************************************

public Articles selectbyId(int id) {
	return session.get(Articles.class, id);
	
}

/*public Articles selectById(int id) {
    System.out.println("Selection de l'article avec l'id :"+id);
    String HQL = "select a from articles a  where a.idArticle =:id";
    Query <Articles> query = session.createQuery(HQL,Articles.class);
    query.setParameter("id",id);
    return query.getSingleResult();*/
}


