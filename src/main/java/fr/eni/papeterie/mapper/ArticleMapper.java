package fr.eni.papeterie.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.entities.ArticleEntity;

public class ArticleMapper {

  public static Article mapEntityToArticle(ArticleEntity articleEntity) {
    Article article;
    if (articleEntity.getType().equalsIgnoreCase("Stylo")) {
      article = new Stylo();
      ((Stylo) article).setCouleur(articleEntity.getCouleur());
    } else {
      article = new Ramette();
      ((Ramette) article).setGrammage(articleEntity.getGrammage());
    }
    article.setIdArticle(articleEntity.getIdArticle());
    article.setReference(articleEntity.getReference());
    article.setMarque(articleEntity.getMarque());
    article.setDesignation(articleEntity.getDesignation());
    article.setPrixUnitaire(articleEntity.getPrixUnitaire());
    article.setQteStock(articleEntity.getQteStock());
    return article;
  }

  public static ArticleEntity mapArticleToEntity(Article article) {
    ArticleEntity articleEntity = new ArticleEntity();
    if (article instanceof Stylo) {
      articleEntity.setCouleur(((Stylo) article).getCouleur());
      articleEntity.setType("Stylo");
    } else {
      articleEntity.setGrammage(((Ramette) article).getGrammage());
      articleEntity.setType("Ramette");
    }
    articleEntity.setIdArticle(article.getIdArticle());
    articleEntity.setReference(article.getReference());
    articleEntity.setMarque(article.getMarque());
    articleEntity.setDesignation(article.getDesignation());
    articleEntity.setPrixUnitaire(article.getPrixUnitaire());
    articleEntity.setQteStock(article.getQteStock());
    return articleEntity;
  }

  public static List<Article> mapEntityToArticle(List<ArticleEntity> articles) {
    List<Article> articleEntities = new ArrayList<>();
    for (ArticleEntity article : articles) {
      articleEntities.add(mapEntityToArticle(article));
    }
    return articleEntities;
  }
}
