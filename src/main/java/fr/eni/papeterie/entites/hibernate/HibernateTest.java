package fr.eni.papeterie.entites.hibernate;

import fr.eni.papeterie.entites.ArticlesEntity;
import fr.eni.papeterie.entites.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTest {

    public static Session session;

    public void getSession() {
        if (session == null) {
            SessionFactory factory = HibernateUtils.getSessionFactory();
            session = factory.openSession();
        }
    }

    public void closeSession() {
        if (session != null) {
            session.close();
        }
    }


    public void create(ArticlesEntity a) {

        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();

    }

    public List<ArticlesEntity> read() {


        session.beginTransaction();
        List<ArticlesEntity> articles = session.createQuery("from Articles", ArticlesEntity.class).getResultList();
        session.getTransaction().commit();

        return articles;
    }


    public void update(ArticlesEntity articles) {

        session.beginTransaction();
        session.saveOrUpdate(articles);
        session.getTransaction().commit();

    }

    public void delete(ArticlesEntity article) {

        session.beginTransaction();
        session.delete(article);
        session.getTransaction().commit();

    }

    public ArticlesEntity selectById(int idArticle){

        String HQL = "select a from articles a where a.idArticle=" + idArticle;
        return session.createQuery(HQL, ArticlesEntity.class).getSingleResult();
    }

    public List<ArticlesEntity> selectByMarque(String marque){

        String HQL = "select a from articles a where a.marque=" + marque;
        return session.createQuery(HQL, ArticlesEntity.class).getResultList();
    }

    public List<ArticlesEntity> selectByMotCle(String motCle){

        String HQL = "select a from articles a where a.marque=:m and a.description=:m";
        Query<ArticlesEntity> query = session.createQuery(HQL, ArticlesEntity.class);
        query.setParameter("m", "%" + motCle + "%");
        return query.getResultList();
    }





}
