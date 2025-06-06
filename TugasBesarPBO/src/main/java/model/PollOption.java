package model;

public class PollOption {
    private int id;
    private int pollId;
    private String optionText;

    public PollOption() {}

    public PollOption(int pollId, String optionText) {
        this.pollId = pollId;
        this.optionText = optionText;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for pollId
    public int getPollId() {
        return pollId;
    }

    // Setter for pollId
    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    // Getter for optionText
    public String getOptionText() {
        return optionText;
    }

    // Setter for optionText
    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }
}
