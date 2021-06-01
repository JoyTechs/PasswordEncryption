package MonkeLogic.dto;

public class SecurityQuestion {

    //region Variables
    private int userID;
    private int questionNr;
    private String question;
    private String answer;
    //endregion

    //region Getters
    public int getUserID() {
        return userID;
    }

    public int getQuestionNr() {
        return questionNr;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    //endregion

    //region Setters

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setQuestionNr(int questionNr) {
        this.questionNr = questionNr;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    //endregion
}
