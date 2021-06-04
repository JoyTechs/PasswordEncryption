package MonkeLogic.databasemethods;

import MonkeLogic.controllers.SessionManager;
import MonkeLogic.dto.Account;
import MonkeLogic.dto.SecurityQuestion;
import MonkeLogic.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadFromDB {

    private static Connection c = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    private static User user = SessionManager.getActiveUser();

    //region Singleton
    private static ReadFromDB instance;

    private ReadFromDB() {
    }

    public static ReadFromDB getInstance() {
        if (instance == null) {
            instance = new ReadFromDB();
        }
        return instance;
    }
    public static void setInstance(){
        instance = null;
    }
    //endregion

    public static User readFromDbToLoginIn(String username, String password) {

        c = DBConnection.getC();

        try {
            String query = "SELECT * FROM USERS WHERE USERNAME = ? and PASSWORD = ? LIMIT 0,1";
            statement = c.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;
                System.out.println(count);

                if (count == 1) {
                    System.out.println("Username and password is correct");
                    user = new User(Integer.parseInt(
                            resultSet.getString("ID")),
                            resultSet.getString("USERNAME"),
                            resultSet.getString("PASSWORD"),
                            resultSet.getString("CLEARANCELEVEL"));
                    return user;
                } else {
                    System.out.println("Username and password is incorrect");
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Account> getAccountsAdmin() {

        c = DBConnection.getC();
        Account tempAccount = null;
        ArrayList<Account> tempList = new ArrayList<>();
        try {
            String query = "SELECT * FROM ACCOUNT";
            statement = c.prepareStatement(query);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                tempAccount = new Account(
                        resultSet.getInt("ID"),
                        resultSet.getInt("USERID"),
                        resultSet.getString("WEBSITE"),
                        resultSet.getString("EMPLOYEE"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("PASSWORD"));
                tempList.add(tempAccount);

            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tempList;
    }

    public static ArrayList<Account> getAccountsUser() {

        c = DBConnection.getC();
        Account tempAccount = null;
        ArrayList<Account> tempList = new ArrayList<>();
        try {
            String query = "SELECT * FROM ACCOUNT WHERE ID = ?";
            statement = c.prepareStatement(query);
            statement.setString(1, String.valueOf(user.getUserID()));

            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                tempAccount = new Account(
                        resultSet.getInt("ID"),
                        resultSet.getInt("USERID"),
                        resultSet.getString("WEBSITE"),
                        resultSet.getString("EMPLOYEE"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("PASSWORD"));
                tempList.add(tempAccount);

            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tempList;
    }

    public static Boolean firstStart() {
        c = DBConnection.getC();

        try {
            String query = "SELECT * FROM USERS WHERE ID = 1 and USERNAME = ? and PASSWORD = ?";
            statement = c.prepareStatement(query);
            statement.setString(1, "Admin");
            statement.setString(2, "FirstStart");

            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;
            }
            if (count == 1) {
                System.out.println("Username and password is correct");
                return true;
            } else {
                System.out.println("Not First Start");
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static Boolean getSecurityQuestion(SecurityQuestion securityQuestion) {
        c = DBConnection.getC();

        try {
            String query = "SELECT * FROM SECURITY_QUESTIONS WHERE USERID = ? and QUESTION = ? and ANSWER = ?";
            statement = c.prepareStatement(query);
            statement.setInt(1, securityQuestion.getUserID());
            statement.setInt(2, securityQuestion.getQuestionNr());
            statement.setString(3, securityQuestion.getAnswer());

            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;
                if (count == 1) {
                    return true;
                } else {
                }
            }

            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static int getUserIDFromUsername(String username) {

        c = DBConnection.getC();

        try {
            String query = "SELECT * FROM USERS WHERE USERNAME = ? LIMIT 0,1";
            statement = c.prepareStatement(query);
            statement.setString(1, username);

            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;
                System.out.println(count);

                if (count == 1) {
                    int userID = resultSet.getInt("ID");
                    SessionManager.setActiveUser(new User(resultSet.getInt("ID"),
                            resultSet.getString("USERNAME"),
                            resultSet.getString("PASSWORD"),
                            resultSet.getString("CLEARANCELEVEL"),
                            resultSet.getBoolean("HASSECURITYQUESTION")));
                    return userID;
                } else {
                    System.out.println("Username and password is incorrect");
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }
}