package fr.afpa.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afpa.papeterie.bo.Article;
import fr.afpa.papeterie.bo.Ramette;
import fr.afpa.papeterie.bo.Stylo;
import fr.afpa.papeterie.dal.ArticleDAO;

public class ArticleDaoJdbcImpl implements ArticleDAO{
	/**
	 * Instance variables URL connection URL to the database USER user defined as
	 * database owner PASSWORD user's password conn connection to the database @see
	 * connect() stmt prepared statement (used in requests with parameters
	 */
	
	JdbcTools jdbcT = new JdbcTools();
	Connection conn = jdbcT.connect();
	PreparedStatement stmt = null;

	public ArticleDaoJdbcImpl() {}

	/**
	 * update method 
	 * keep the same id as the article in parameter and reset every other attribute with the new values
	 * @param article
	 */
	public void update(Article article) {
// we instantiate a string with the SQL request. Every ? represents a parameter we need to set with the new values in java	
		String sql = "UPDATE Articles SET reference =?,marque=?,designation=?,prixUnitaire=?,qteStock=?,grammage=?,couleur=?,type=? where idArticle=?";
		try {
// we need to instantiate a Prepared Statement to be able to replace every ? with the linked value			
			PreparedStatement stmt = conn.prepareStatement(sql);
// we use the set method from PreparedStatement, the first parameter is the location of the ? in the query and the second one is the value we want to put			
			stmt.setInt(9, article.getIdArticle());
			stmt.setString(1, article.getReference());
			stmt.setString(2, article.getMarque());
			stmt.setString(3, article.getDesignation());
			stmt.setFloat(4, article.getPrixUnitaire());
			stmt.setInt(5, article.getQteStock());
// if the article is a pen then we set grammage to null and type to "STYLO"		
			if (article instanceof Stylo) {
				stmt.setNull(6, java.sql.Types.NULL);
				stmt.setString(7, ((Stylo) article).getCouleur());
				stmt.setString(8, "STYLO");
			}
// if the article is a ream then we set couleur to null and type to "RAMETTE"				
			if (article instanceof Ramette) {
				stmt.setNull(7, java.sql.Types.NULL);
				stmt.setInt(6, ((Ramette) article).getGrammage());
				stmt.setString(8, "RAMETTE");
			}
// we use the executeUpdate method from PreparedStatement to push the update to the database (if we don't the update is made inside the object but is never updated in the database)
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
			
	}

	/**
	 * delete method
	 * delete the Article sharing the ID in parameter
	 * @param idArticle
	 */
	public void delete(int idArticle) {
		try {
// we instantiate a string with the SQL query. The ? is instantiated with the id of the article we want to delete from the database 		
			stmt = conn.prepareStatement("delete from Articles where idArticle=?");
			stmt.setInt(1, idArticle);
// the request is not an update or a query so we just call the execute method			
			stmt.execute();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void insert(Article article) {
		String sql = "INSERT INTO Articles VALUES(default,?,?,?,?,?,?,?,?)";
		try {
// we instantiate a Prepared Statement  with another parameter to return the ID auto generated by the database			
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, article.getReference());
			stmt.setString(2, article.getMarque());
			stmt.setString(3, article.getDesignation());
			stmt.setFloat(4, article.getPrixUnitaire());
			stmt.setInt(5, article.getQteStock());
			if (article instanceof Stylo) {
				stmt.setNull(6, java.sql.Types.NULL);
				stmt.setString(7, ((Stylo) article).getCouleur());
				stmt.setString(8, "STYLO");
			}
			if (article instanceof Ramette) {
				stmt.setNull(7, java.sql.Types.NULL);
				stmt.setInt(6, ((Ramette) article).getGrammage());
				stmt.setString(8, "RAMETTE");
			}
// we catch the number of the row affected by the update
			int affectedRows = stmt.executeUpdate();
//if affectedRow=0 then it means that the row we try to update does not exist
			if (affectedRows == 0) {
				throw new SQLException("Creating article failed, no rows affected.");
			}
// we stock the auto generated key created by the database in a ResultSet instance
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {

				;
// the next method check if there is a value in the ID attribute 				
				if (generatedKeys.next()) {
// we store the generated key in the IdArticle attribute					
					article.setIdArticle((int) generatedKeys.getLong(1));
				} else {
					throw new SQLException("Creating article failed, no ID obtained.");
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public Article selectById(int idArticle) {
		Article article = null;
		try {
			stmt = conn.prepareStatement("select * from Articles where idArticle=?");
			stmt.setInt(1, idArticle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("type").toUpperCase().trim().equals("STYLO")) {
					article = new Stylo();
					((Stylo) article).setCouleur(rs.getString("couleur"));
				} else if (rs.getString("type").toUpperCase().trim().equals("RAMETTE")) {
					article = new Ramette();
					((Ramette) article).setGrammage(rs.getInt("grammage"));
				}

				article.setReference(rs.getString("reference"));
				article.setMarque(rs.getString("marque"));
				article.setDesignation(rs.getString("designation"));
				article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
				article.setQteStock(rs.getInt("qteStock"));

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return article;
	}

	public ArrayList<Article> selectAll() {
		Article article = null;
		ArrayList<Article> articles = new ArrayList<Article>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Articles");
			while (rs.next()) {
				if (rs.getString("type").toUpperCase().trim().equals("STYLO")) {
					article = new Stylo();
					((Stylo) article).setCouleur(rs.getString("couleur"));
				} else if (rs.getString("type").toUpperCase().trim().equals("RAMETTE")) {
					article = new Ramette();
					((Ramette) article).setGrammage(rs.getInt("grammage"));
				}
				article.setIdArticle(rs.getInt("idArticle"));
				article.setReference(rs.getString("reference"));
				article.setMarque(rs.getString("marque"));
				article.setDesignation(rs.getString("designation"));
				article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
				article.setQteStock(rs.getInt("qteStock"));
				articles.add(article);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return articles;
	}

	@Override
	public ArrayList<Article> selectByMarque(String marque) {
		Article article = null;
		ArrayList<Article> articles = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("select * from Articles where marque=?");
			stmt.setString(1, marque);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("type").toUpperCase().trim().equals("STYLO")) {
					article = new Stylo();
					((Stylo) article).setCouleur(rs.getString("couleur"));
				} else if (rs.getString("type").toUpperCase().trim().equals("RAMETTE")) {
					article = new Ramette();
					((Ramette) article).setGrammage(rs.getInt("grammage"));
				}
				article.setIdArticle(rs.getInt("idArticle"));
				article.setReference(rs.getString("reference"));
				article.setMarque(rs.getString("marque"));
				article.setDesignation(rs.getString("designation"));
				article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
				article.setQteStock(rs.getInt("qteStock"));
				articles.add(article);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return articles;
	}
	

	@Override
	public ArrayList<Article> selectByMotCle(String motCle) {
		Article article = null;
		ArrayList<Article> articles = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("select * from Articles where marque LIKE ? OR designation LIKE ?");
			String s1 = "%"+motCle+"%";
			stmt.setString(1, s1);
			stmt.setString(2, s1);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("type").toUpperCase().trim().equals("STYLO")) {
					article = new Stylo();
					((Stylo) article).setCouleur(rs.getString("couleur"));
				} else if (rs.getString("type").toUpperCase().trim().equals("RAMETTE")) {
					article = new Ramette();
					((Ramette) article).setGrammage(rs.getInt("grammage"));
				}
				article.setIdArticle(rs.getInt("idArticle"));
				article.setReference(rs.getString("reference"));
				article.setMarque(rs.getString("marque"));
				article.setDesignation(rs.getString("designation"));
				article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
				article.setQteStock(rs.getInt("qteStock"));
				articles.add(article);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return articles;
	}
	}

