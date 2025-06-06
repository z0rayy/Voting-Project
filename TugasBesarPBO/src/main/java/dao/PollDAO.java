package dao;

import model.Poll;
import model.PollOption;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PollDAO {

    public int createPoll(Poll poll, List<String> options) {
        int pollId = -1;
        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);

            // Insert polling
            String pollSql = "INSERT INTO polling (user_id, question) VALUES (?, ?)";
            PreparedStatement pollStmt = conn.prepareStatement(pollSql, Statement.RETURN_GENERATED_KEYS);
            pollStmt.setInt(1, poll.getUserId());
            pollStmt.setString(2, poll.getQuestion());
            pollStmt.executeUpdate();

            ResultSet rs = pollStmt.getGeneratedKeys();
            if (rs.next()) {
                pollId = rs.getInt(1);
            }

            // Insert opsi polling
            String optionSql = "INSERT INTO polling_options (polling_id, option_text) VALUES (?, ?)";
            PreparedStatement optionStmt = conn.prepareStatement(optionSql);
            for (String option : options) {
                optionStmt.setInt(1, pollId);
                optionStmt.setString(2, option);
                optionStmt.addBatch();
            }
            optionStmt.executeBatch();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pollId;
    }
    public List<Poll> getAllPolls() {
        List<Poll> polls = new ArrayList<>();
        String sql = "SELECT id, user_id, question FROM polling ORDER BY id DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Poll poll = new Poll();
                poll.setId(rs.getInt("id"));
                poll.setUserId(rs.getInt("user_id"));
                poll.setQuestion(rs.getString("question"));

                polls.add(poll);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return polls;
    }


    public List<PollOption> getOptionsByPollId(int pollingId) {
        List<PollOption> options = new ArrayList<>();
        String sql = "SELECT id, polling_id, option_text FROM polling_options WHERE polling_id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pollingId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PollOption option = new PollOption();
                option.setId(rs.getInt("id"));
                option.setPollId(rs.getInt("polling_id"));  // pastikan ada method setPollId
                option.setOptionText(rs.getString("option_text")); // pastikan ada method setText
                options.add(option);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return options;
    }
    
    public String getQuestionByPollId(int pollingId) {
        String sql = "SELECT question FROM polling WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pollingId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("question");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<Poll, List<PollOption>> getAllPollsWithOptions() {
        Map<Poll, List<PollOption>> map = new LinkedHashMap<>();
        String pollSql = "SELECT * FROM polling ORDER BY id DESC";
        String optionSql = "SELECT * FROM polling_options WHERE polling_id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pollStmt = conn.prepareStatement(pollSql);
             ResultSet pollRs = pollStmt.executeQuery()) {

            while (pollRs.next()) {
                Poll poll = new Poll();
                poll.setId(pollRs.getInt("id"));
                poll.setUserId(pollRs.getInt("user_id"));
                poll.setQuestion(pollRs.getString("question"));

                // Ambil opsi untuk polling ini
                PreparedStatement optStmt = conn.prepareStatement(optionSql);
                optStmt.setInt(1, poll.getId());
                ResultSet optRs = optStmt.executeQuery();

                List<PollOption> options = new ArrayList<>();
                while (optRs.next()) {
                    PollOption opt = new PollOption();
                    opt.setId(optRs.getInt("id"));
                    opt.setPollId(optRs.getInt("polling_id"));
                    opt.setOptionText(optRs.getString("option_text"));
                    options.add(opt);
                }
                map.put(poll, options);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }

}
