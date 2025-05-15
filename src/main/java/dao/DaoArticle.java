package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.Article;

public class DaoArticle {
    private String jdbcURL = System.getenv("db.url");
    private String jdbcUsername = System.getenv("db.username");
    private String jdbcPassword = System.getenv("db.password");

 
    public DaoArticle() {    
    }


    public void insert(Article article) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO articles (ref, marque, prix) VALUES (?, ?, ?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, article.getRef());
            ps.setString(2, article.getMarque());
            ps.setDouble(3, article.getPrix());
            ps.executeUpdate();
        }
    }

    public Article findById(String ref) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM articles WHERE ref = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ref);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Article(rs.getString("ref"), rs.getString("marque"), rs.getDouble("prix"));
                }
            }
        }
        return null;
    }

    public void delete(String ref) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM articles WHERE ref = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ref);
            ps.executeUpdate();
        }
    }

    public List<Article> findByMarque(String marque) throws ClassNotFoundException, SQLException {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM articles WHERE marque LIKE ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + marque + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    articles.add(new Article(rs.getString("ref"), rs.getString("marque"), rs.getDouble("prix")));
                }
            }
        }
        return articles;
    }

    public List<Article> findAll() throws ClassNotFoundException, SQLException {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM articles";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Article article = new Article(rs.getString("ref"), rs.getString("marque"), rs.getDouble("prix"));
                articles.add(article);
            }
        }
        return articles;
    }
}
