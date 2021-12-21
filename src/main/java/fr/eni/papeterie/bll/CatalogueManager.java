package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.dal.jpa.DaoFactory;
import fr.eni.papeterie.entities.ArticleEntity;
import fr.eni.papeterie.exception.BLLException;
import fr.eni.papeterie.mapper.ArticleMapper;

public class CatalogueManager {
  private DaoFactory daoFactory = DaoFactory.getInstance();

  public CatalogueManager() throws BLLException {
  }

  public List<Article> getCatalogue() {
    List<ArticleEntity> listArticlesEntity = daoFactory.getArticleDAO().selectAll();
    return ArticleMapper.mapEntityToArticle(listArticlesEntity);
  }

  public void addArticle(Article article) throws BLLException {
    daoFactory.getArticleDAO().create(ArticleMapper.mapArticleToEntity(article));
  }

  public void updateArticle(Article article) throws BLLException {
    daoFactory.getArticleDAO().update(ArticleMapper.mapArticleToEntity(article));
  }

  public void removeArticle(int index) throws BLLException {
    daoFactory.getArticleDAO().delete(index);
  }

  public void removeArticle(Article article) throws BLLException {
    daoFactory.getArticleDAO().delete(ArticleMapper.mapArticleToEntity(article));
  }

  // public void validerArticle(Article article) {
  // daoFactory.getArticleDAO().validerArticle(article);
  // }

  public Article getArticle(int index) throws BLLException {
    return ArticleMapper.mapEntityToArticle(daoFactory.getArticleDAO().selectById(index));
  }

}
