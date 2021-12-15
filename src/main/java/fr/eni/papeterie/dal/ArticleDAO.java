package fr.eni.papeterie.dal;

import fr.eni.papeterie.bo.Article;

import java.util.List;

public interface ArticleDAO {

    Article selectById(int i) throws DALException;
    List<Article> selectAll() throws DALException;
    List<Article> selectByMarque(String marque) throws DALException;
    List<Article> selectByMotCle(String motCle) throws DALException;
    void update(Article data) throws DALException;
    void insert(Article data) throws DALException;
    void delete(int id) throws DALException;



}
