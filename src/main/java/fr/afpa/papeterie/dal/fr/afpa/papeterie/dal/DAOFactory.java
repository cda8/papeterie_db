package fr.afpa.papeterie.dal;

import fr.afpa.papeterie.dal.jdbc.ArticleDaoJdbcImpl;

public class DAOFactory {
	public static ArticleDAO getArticleDAO() {
		ArticleDAO aDAO = null;
			aDAO = new ArticleDaoJdbcImpl();
		return aDAO;
	}

}
