package fr.eni.papeterie.dao.jpa;

import fr.eni.papeterie.entites.ArticlesEntity;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ArticlesDaoJpa {

    private final String SELECT_ALL_ARTICLES = "select a from Articles a";

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Default");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static EntityTransaction entityTransaction = entityManager.getTransaction();

    public  void beginTransaction(){
        entityTransaction.begin();

    }


    public  void commitTransaction(){
        entityTransaction.commit();
    }

    public void createOrUpdate(ArticlesEntity article){
        entityManager.persist(article);
    }

    public List<ArticlesEntity> read(){

        return entityManager.createQuery(SELECT_ALL_ARTICLES, ArticlesEntity.class).getResultList();

    }

    //TODO a revoir
//    public List<ArticlesEntity> readOther(){
//        return entityManager.getReference(ArticlesEntity.class, )
//    }

    public ArticlesEntity find(int id){
       return entityManager.find(ArticlesEntity.class, id);
    }

    public List<ArticlesEntity> SelectByMarque(String marque){
        String hql = "select a from Articles a where a.marque=:p";

        return entityManager.createQuery(hql, ArticlesEntity.class).setParameter("p", marque).getResultList();
    }

    public List<ArticlesEntity> selectByMotCle(String motCle){

        String hql = "select a from Articles a where a.marque LIKE:p OR a.designation LIKE :p";
        return entityManager.createQuery(hql, ArticlesEntity.class).setParameter("p", "%"+motCle+"%").getResultList();
    }



}
