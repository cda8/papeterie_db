package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.dal.jpa.DaoFactory;

public class CatalogueManager {
 private DaoFactory daoFactory = DaoFactory.getInstance();

 public CatalogueManager() {
 }

 public List<Article> getCatalogue() {
   return daoFactory.getArticleDAO().selectAll();
 }

 public void addArticle(Article article) {
   daoFactory.getArticleDAO().create(article);
 }
 public void updateArticle(Article article) {
   daoFactory.getArticleDAO().update(article);
 }
 public void removeArticle(int index) {
   daoFactory.getArticleDAO().delete(index);
 }

 public void validerArticle(Article article) {
   daoFactory.getArticleDAO().validerArticle(article);
 }

 public Article getArticle(int index) {
   daoFactory.getArticleDAO().selectById(index);
 }

}
