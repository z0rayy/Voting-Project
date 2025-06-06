package model;

public class Poll {
    private int id;
    private int userId;
    private String question;

    public Poll() {}

    public Poll(int userId, String question) {
        this.userId = userId;
        this.question = question;
    }

    // Getter dan Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
