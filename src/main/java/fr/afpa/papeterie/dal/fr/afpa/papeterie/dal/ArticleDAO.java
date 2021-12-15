package fr.afpa.papeterie.dal;


import java.util.ArrayList;

import fr.afpa.papeterie.bo.Article;


public interface ArticleDAO {


	public void update(Article article);

	public void delete(int idArticle);

	public void insert(Article article);

	public Article selectById(int idArticle);

	public ArrayList<Article> selectAll();
	
	public ArrayList<Article> selectByMarque(String marque);
	
	public ArrayList<Article> selectByMotCle(String motCle);
}
