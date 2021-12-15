package fr.afpa.papeterie.dal.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.afpa.papeterie.entities.ArticlesEntity;


public class ArticleDAOJPA {
	
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	//gestion via l'API au lieu d'hibernate (va avec persistence.xml dans META-INF) 
	
	public void insert(ArticlesEntity a) {
		System.out.println("Enregistrement d'un article...");
		entityManager.getTransaction().begin();
		entityManager.persist(a);
		entityManager.getTransaction().commit();
	}
	public void closeEntityManager() {
		if(entityManager!=null)	entityManager.close();
	}


	public List<ArticlesEntity> selectAll(){
		System.out.println("Lecture des articles...");
		
		String HQL = "from articles";
		List<ArticlesEntity> articlesList = entityManager.createQuery(HQL,ArticlesEntity.class).getResultList();
		
		/*String HQL = "select a from articles a where a.idArticle=:monId";
		Query<ArticlesEntity> query = session.createQuery(HQL,ArticlesEntity.class);
		query.setParameter("monId", 36);
		List<ArticlesEntity> articlesList = query.getResultList();*/
			
		return articlesList;
	}

	public void update(ArticlesEntity ae) {
		System.out.println("Mise à jour d'un article...");
		
		entityManager.getTransaction().begin();
		entityManager.refresh(ae);
		entityManager.getTransaction().commit();
	}

	//public ArticlesEntity getArticleFromSession(int id) {
//		return (ArticlesEntity) session.get(ArticlesEntity.class, id);
	//}
	public void delete(ArticlesEntity article) {
		System.out.println("Suppression de l'article...");
		
		entityManager.getTransaction().begin();
		entityManager.remove(article);
		entityManager.getTransaction().commit();
	}

	public List<ArticlesEntity> selectByMarque(String marque){
		System.out.println("Selection des articles de la marque "+marque);
		String HQL = "select a from articles a  where a.marque =:m";
		TypedQuery <ArticlesEntity> query = entityManager.createQuery(HQL,ArticlesEntity.class);
		query.setParameter("m",marque);
		return query.getResultList();
	}

	public List<ArticlesEntity> selectByMotCle(String mot){
		System.out.println("Selection des articles contenant le mot clé "+mot);
		String HQL = "select a from articles a where a.marque LIKE : motcle OR a.designation LIKE : motcle";
		TypedQuery <ArticlesEntity> query = entityManager.createQuery(HQL,ArticlesEntity.class);
		String motcle = "%"+mot+"%";
		query.setParameter("motcle", motcle);
		return query.getResultList();
	}

	public ArticlesEntity selectById(int id) {
		System.out.println("Selection de l'article avec l'id :"+id);
		String HQL = "select a from articles a  where a.idarticle =:id";
		TypedQuery <ArticlesEntity> query = entityManager.createQuery(HQL,ArticlesEntity.class);
		query.setParameter("id",id);
		return query.getSingleResult();
	}


}
