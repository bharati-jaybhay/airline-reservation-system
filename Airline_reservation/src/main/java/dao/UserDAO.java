package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import controller.User;

public class UserDAO {

    private DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean saveData(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO user(username, password, email) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } finally {
            close(conn, ps, null);
        }
    }
    public boolean validateUser(String username, String password) throws Exception {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
	
    public boolean findUser(String username, String password) throws Exception {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            return rs.next(); 
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error while checking user", e);
        } finally {
            close(conn, ps, rs);
        }
    }

    private void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
}
