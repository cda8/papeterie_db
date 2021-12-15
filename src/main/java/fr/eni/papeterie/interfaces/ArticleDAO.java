package fr.eni.papeterie.interfaces;

import java.sql.SQLException;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.exception.DALException;

public interface ArticleDAO {
  Article selectById(int id) throws DALException, SQLException;

  List<Article> selectAll() throws DALException, SQLException;

  List<Article> selectByMarque(String marque) throws DALException, SQLException;

  List<Article> selectByMotCle(String motCle) throws DALException, SQLException;

  void update(Article art) throws DALException, SQLException;

  void insert(Article art) throws DALException, SQLException;

  void delete(int id) throws DALException, SQLException;
}
