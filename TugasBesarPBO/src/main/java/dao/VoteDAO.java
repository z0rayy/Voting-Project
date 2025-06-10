package dao;

import util.DBUtil;
import java.sql.*;

public class VoteDAO {

    public boolean castVote(int userId, int optionId) {
        String sql = "INSERT INTO votes (user_id, option_id) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, optionId);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getTotalVotesByPollId(int pollId) {
        String sql = "SELECT COUNT(*) AS totalVotes FROM votes v "
                   + "JOIN polling_options o ON v.option_id = o.id "
                   + "WHERE o.polling_id = ?";
        int totalVotes = 0;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pollId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalVotes = rs.getInt("totalVotes");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalVotes;
    }

    public int getVotesByOptionId(int optionId) {
        String sql = "SELECT COUNT(*) AS voteCount FROM votes WHERE option_id = ?";
        int voteCount = 0;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, optionId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                voteCount = rs.getInt("voteCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voteCount;
    }
}
