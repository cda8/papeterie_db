package fr.eni.papeterie.dal.hibernate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.papeterie.dal.jpa.ArticleDAOJPA;
import fr.eni.papeterie.entities.ArticleEntity;

public class HibernateRunner {

  public static void main(String[] args) {
    final Logger LOGGER = LoggerFactory.getLogger("HibernateRunner");
    ArticleDAOJPA articleDAOJPA = ArticleDAOJPA.getInstance();
    
    LOGGER.info("Enregistrement de l'article... ");
    ArticleEntity article = new ArticleEntity("JPA", "testjpa", "JPA",
        1.2f, 20, "rouge", "stylo");

    // articleDAOJPA.create(article);
    System.out.println(articleDAOJPA.selectById(84));

    for (ArticleEntity a : articleDAOJPA.selectAll()) {
      LOGGER.info(a.toString());
    }
    LOGGER.info(articleDAOJPA.selectByMarque("bic").toString());
    // List<ArticleEntity> articlesList = articleDAO.selectAll();
    // for (ArticleEntity articleEntity : articlesList) {
    // System.out.println(articleEntity);
    // }
    // System.out.println("=> select by id " + articleDAO.selectById(2));
    // System.out.println("=> select by marque " +
    // articleDAO.selectByMarque("Bic"));
    // System.out.println("=> select by motCle marque " +
    // articleDAO.selectByMotCle("Bic"));
    // System.out.println("=> select by motCle designation" +
    // articleDAO.selectByMotCle("Plume"));
    // System.out.println("=> first index " + articleDAO.selectAll().get(0));
    // System.out.println("avant " + articleDAO.selectAll().size());
    // article.setDesignation("designation update");
    // System.out.println("=> " +
    // articleDAO.selectAll().get(articleDAO.selectAll().size() - 1));

    // articleDAO.delete(article);

    // System.out.println("apres " + articleDAO.selectAll().size());
    // System.out.println("=> " +
    // articleDAO.selectAll().get(articleDAO.selectAll().size() - 1));

    articleDAOJPA.closeEntityManager();

  }
}
