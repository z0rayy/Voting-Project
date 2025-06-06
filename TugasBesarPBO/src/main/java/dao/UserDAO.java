package dao;
import model.User;
import util.DBUtil;
import java.sql.*;

public class UserDAO {
    public User login(String username, String password) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
          	     return new User(rs.getString("username"), rs.getString("password"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    
    public boolean registerUser(User user) {
        if (isUsernameTaken(user.getUsername())) {
            return false;
        }

        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean isUsernameTaken(String username) {
        String sql = "SELECT id FROM users WHERE username = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true jika ditemukan

        } catch (SQLException e) {
            e.printStackTrace();
            return true; // anggap username dipakai jika gagal koneksi
        }
    }

}
