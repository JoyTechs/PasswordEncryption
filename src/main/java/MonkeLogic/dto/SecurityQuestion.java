package MonkeLogic.dto;

public class SecurityQuestion {

    //region Variables
    private final int userID;
    private final int questionNr;
    private final String answer;
    //endregion


    public SecurityQuestion(int userID, int questionNr, String answer) {
        this.userID = userID;
        this.questionNr = questionNr;
        this.answer = answer;
    }

    //region Getters
    public int getUserID() {
        return userID;
    }

    public int getQuestionNr() {
        return questionNr;
    }

    public String getAnswer() {
        return answer;
    }
    //endregion
}
