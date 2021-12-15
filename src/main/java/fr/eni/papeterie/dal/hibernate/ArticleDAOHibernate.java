package fr.eni.papeterie.dal.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.eni.papeterie.entities.ArticleEntity;
import fr.eni.papeterie.entities.utils.HibernateUtils;

public class ArticleDAOHibernate {

  private static Session session;

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

  public void create(ArticleEntity article) {
    System.out.println("Enregistrement de l'article... ");
    session.beginTransaction();
    session.save(article);
    session.getTransaction().commit();
  }

  public ArticleEntity selectById(int id) {
    System.out.println("Selection de l'article par son id... " + id);
    return session.get(ArticleEntity.class, id);
  }

  public List<ArticleEntity> selectAll() {
    System.out.println("Selection de touts les articles... ");
    String HQL = "FROM articles";
    return session.createQuery(HQL, ArticleEntity.class).getResultList();

  }

  public List<ArticleEntity> selectByMarque(String marque) {
    System.out.println("Selection par la marque... " + marque);
    String HQL = "FROM articles  WHERE LOWER(marque) = :marque";
    return session.createQuery(HQL, ArticleEntity.class).setParameter("marque", marque.toLowerCase()).getResultList();

  }

  public List<ArticleEntity> selectByMotCle(String motCle) {
    System.out.println("Selection par le mot clé... " + motCle);
    String HQL = "FROM articles WHERE LOWER(marque) = :motCle OR LOWER(designation) LIKE :motCle ";
    return session.createQuery(HQL, ArticleEntity.class).setParameter("motCle", "%" + motCle.toLowerCase() + "%")
        .getResultList();

  }

  public void update(ArticleEntity article) {
    System.out.println("Mise à jour de l'article... ");
    session.beginTransaction();
    session.update(article);
    session.getTransaction().commit();

  }

  public void delete(ArticleEntity article) {
    System.out.println("Suppression de l'article... ");
    ArticleEntity articleToDelete = session.get(ArticleEntity.class, article.getIdArticle());
    session.beginTransaction();
    session.delete(articleToDelete);
    session.getTransaction().commit();
  }

}
