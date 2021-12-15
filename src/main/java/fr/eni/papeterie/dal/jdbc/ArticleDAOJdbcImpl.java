package fr.eni.papeterie.dal.jdbc;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOJdbcImpl  implements ArticleDAO {

    public ArticleDAOJdbcImpl() {
    }

    public Article selectById(int id) throws DALException {
        Connection newConnection = connection();
        String sql = "SELECT * FROM Articles WHERE idArticle=?";
        Article article = null;
        try {
            PreparedStatement stmt = newConnection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("type").trim().equalsIgnoreCase("STYLO")){
                    article = new Stylo(resultSet.getString("couleur"));
                }else if (resultSet.getString("type").trim().equalsIgnoreCase("RAMETTE")){
                    article = new Ramette(resultSet.getInt("grammage"));
                }
                article.setIdArticle(resultSet.getInt("idArticle"));
                article.setReference(resultSet.getString("reference"));
                article.setDesignation(resultSet.getString("designation"));
                article.setMarque(resultSet.getString("marque"));
                article.setPrixUnitaire(resultSet.getFloat("prixUnitaire"));
                article.setQteStock(resultSet.getInt("qteStock"));
            }


            connection().close();
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return article;
    }

    public List<Article> selectAll() throws DALException {
        List<Article> listArticles = new ArrayList<>();
        Connection newConnection = connection();
        String sql = "SELECT * FROM Articles";
        try(Statement stmt = newConnection.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Article article = null;
                if (rs.getString("type").trim().equalsIgnoreCase("STYLO")){
                    article = new Stylo(rs.getString("couleur"));
                }else if (rs.getString("type").trim().equalsIgnoreCase("RAMETTE")){
                    article = new Ramette(rs.getInt("grammage"));
                }
                article.setIdArticle(rs.getInt("idArticle"));
                article.setReference(rs.getString("reference"));
                article.setDesignation(rs.getString("designation"));
                article.setMarque(rs.getString("marque"));
                article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
                article.setQteStock(rs.getInt("qteStock"));

                listArticles.add(article);

            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return listArticles;
    }

    @Override
    public List<Article> selectByMarque(String marque) throws DALException {
        Connection newConnection = connection();
        String sql = "SELECT * FROM Articles WHERE marque=?";
        Article article = null;
        List<Article> articles = new ArrayList<>();
        try {
            PreparedStatement stmt = newConnection.prepareStatement(sql);
            stmt.setString(1, marque);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("type").trim().equalsIgnoreCase("STYLO")){
                    article = new Stylo(resultSet.getString("couleur"));
                }else if (resultSet.getString("type").trim().equalsIgnoreCase("RAMETTE")){
                    article = new Ramette(resultSet.getInt("grammage"));
                }
                article.setIdArticle(resultSet.getInt("idArticle"));
                article.setReference(resultSet.getString("reference"));
                article.setDesignation(resultSet.getString("designation"));
                article.setMarque(resultSet.getString("marque"));
                article.setPrixUnitaire(resultSet.getFloat("prixUnitaire"));
                article.setQteStock(resultSet.getInt("qteStock"));
                articles.add(article);
            }


            connection().close();
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return articles;

    }

    @Override
    public List<Article> selectByMotCle(String motCle) throws DALException {
        Connection newConnection = connection();
        String sql = "SELECT * FROM articles\n" +
                "WHERE marque LIKE '%word1%'\n" +
                "   OR designation LIKE '%word2%'\n";
        Article article = null;
        List<Article> articles = new ArrayList<>();
        try {
            PreparedStatement stmt = newConnection.prepareStatement(sql);
            stmt.setString(1, motCle);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("type").trim().equalsIgnoreCase("STYLO")){
                    article = new Stylo(resultSet.getString("couleur"));
                }else if (resultSet.getString("type").trim().equalsIgnoreCase("RAMETTE")){
                    article = new Ramette(resultSet.getInt("grammage"));
                }
                article.setIdArticle(resultSet.getInt("idArticle"));
                article.setReference(resultSet.getString("reference"));
                article.setDesignation(resultSet.getString("designation"));
                article.setMarque(resultSet.getString("marque"));
                article.setPrixUnitaire(resultSet.getFloat("prixUnitaire"));
                article.setQteStock(resultSet.getInt("qteStock"));
                articles.add(article);
            }


            connection().close();
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return articles;
    }

    public void update(Article article) throws DALException {
        Connection newConnection = connection();
        String sql = "UPDATE Articles set reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur=?, type=? WHERE idArticle=?";
        try (PreparedStatement stmt = newConnection.prepareStatement(sql)) {
            stmt.setString(1, article.getReference());
            stmt.setString(2, article.getMarque());
            stmt.setString(3, article.getDesignation());
            stmt.setFloat(4, article.getPrixUnitaire());
            stmt.setInt(5, article.getQteStock());
            if (article instanceof Stylo){
                stmt.setString(7, ((Stylo) article).getCouleur());
                stmt.setNull(6, Types.INTEGER);
                stmt.setString(8, "stylo");
            }else if(article instanceof Ramette){
                stmt.setInt(6, ((Ramette) article).getGrammage());
                stmt.setString(7, null);
                stmt.setString(8, "ramette");
            }
            stmt.setInt(9, article.getIdArticle() );
            stmt.executeUpdate();
        }catch (SQLException ex) {
            throw new DALException("test");
        }
    }

    public void insert(Article article) throws DALException {
        Connection newConnection = connection();
        String sql = "INSERT INTO Articles VALUES(default, ?, ?, ?, ?, ?, ?, ?, ? )";
        try (PreparedStatement stmt = newConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, article.getReference());
            stmt.setString(2, article.getMarque());
            stmt.setString(3, article.getDesignation());
            stmt.setFloat(4, article.getPrixUnitaire());
            stmt.setInt(5, article.getQteStock());
            if (article instanceof Stylo){
                stmt.setString(7, ((Stylo) article).getCouleur());
                stmt.setNull(6, Types.INTEGER);
                stmt.setString(8, "stylo");
            }else if(article instanceof Ramette){
                stmt.setInt(6, ((Ramette) article).getGrammage());
                stmt.setString(7, null);
                stmt.setString(8, "ramette");
            }
            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    System.err.println("insert  id  = "+ rs.getInt(1));
                    article.setIdArticle(rs.getInt(1));
                }
            }
            System.err.println(article.getIdArticle());
        }catch(Exception ex){
            System.out.println("ArticleDAOJdbcImpl.insert " + ex.getMessage());
        }

    }

    public void delete(int idArticle) {
        Connection newConnection = connection();
        String sql = "DELETE FROM Articles WHERE id=?";
        try (PreparedStatement stmt = newConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, idArticle);
            System.err.println("Article supprimé");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Connection connection() {

        String url = "jdbc:postgresql://localhost/db_papeterie";
        String user = "u_papyrus";
        String password = "afpa123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }

}
