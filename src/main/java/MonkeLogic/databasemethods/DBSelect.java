package MonkeLogic.databasemethods;

import MonkeLogic.controllers.CryptKeeper;
import MonkeLogic.controllers.SessionManager;
import MonkeLogic.dto.Account;
import MonkeLogic.dto.SecurityQuestion;
import MonkeLogic.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBSelect {

    private static Connection c = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    private static User user = SessionManager.getActiveUser();

    //region Singleton
    private static DBSelect instance;

    private DBSelect() {
    }

    public static DBSelect getInstance() {
        if (instance == null) {
            instance = new DBSelect();
        }
        return instance;
    }

    public static void setInstance() {
        instance = null;
    }
    //endregion

    public static User readFromDBToLogin(String username, String password) {

        c = DBConnection.getC();

        try {
            String query = "SELECT * FROM USERS WHERE USERNAME = ? and PASSWORD = ? LIMIT 0,1";
            statement = c.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, CryptKeeper.enCrypt(password));

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
                            CryptKeeper.deCrypt(resultSet.getString("PASSWORD")),
                            resultSet.getString("CLEARANCELEVEL"),
                            resultSet.getBoolean("HASSECURITYQUESTION"));
                    return user;
                } else {
                    System.out.println("Username and password is incorrect");
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    public static Boolean validationOfUsername(String username) {

        c = DBConnection.getC();

        try {
            String query = "SELECT * FROM USERS WHERE USERNAME = ?";
            statement = c.prepareStatement(query);
            statement.setString(1, username);

            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;

                if (count == 1) {
                    System.out.println("That username already exists! ");
                    return true;
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return false;
    }

    public static Boolean firstStart() {

        c = DBConnection.getC();

        try {
            String query = "SELECT * FROM USERS WHERE ID = 1 and USERNAME = ? and PASSWORD = ?";
            statement = c.prepareStatement(query);
            statement.setString(1, "Admin");
            statement.setString(2, CryptKeeper.enCrypt("FirstStart"));

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
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return false;
    }

    public static boolean lookForDefaultAdmin() {

        c = DBConnection.getC();

        try {
            String query = "SELECT * FROM USERS";
            statement = c.prepareStatement(query);
            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;

                user = new User(Integer.parseInt(
                        resultSet.getString("ID")),
                        resultSet.getString("USERNAME"),
                        CryptKeeper.deCrypt(resultSet.getString("PASSWORD")),
                        resultSet.getString("CLEARANCELEVEL"));
                return true;
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return false;
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
                        CryptKeeper.deCrypt(resultSet.getString("PASSWORD")));
                tempList.add(tempAccount);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return tempList;
    }

    public static ArrayList<Account> getAccountsUser() {

        c = DBConnection.getC();
        Account tempAccount = null;
        ArrayList<Account> tempList = new ArrayList<>();

        try {
            String query = "SELECT * FROM ACCOUNT WHERE USERID = ?";
            statement = c.prepareStatement(query);
            statement.setInt(1, SessionManager.getActiveUser().getUserID());

            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                tempAccount = new Account(
                        resultSet.getInt("ID"),
                        resultSet.getInt("USERID"),
                        resultSet.getString("WEBSITE"),
                        resultSet.getString("EMPLOYEE"),
                        resultSet.getString("USERNAME"),
                        CryptKeeper.deCrypt(resultSet.getString("PASSWORD")));
                tempList.add(tempAccount);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return tempList;
    }

    public static Boolean getSecurityQuestion(SecurityQuestion securityQuestion) {

        c = DBConnection.getC();

        try {
            String query = "SELECT * FROM SECURITY_QUESTIONS WHERE USERID = ? and QUESTION = ? and ANSWER = ?";
            statement = c.prepareStatement(query);
            statement.setInt(1, securityQuestion.getUserID());
            statement.setInt(2, securityQuestion.getQuestionNr());
            statement.setString(3, CryptKeeper.enCrypt(securityQuestion.getAnswer()));

            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = count + 1;
                if (count == 1) {
                    return true;
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
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

                if (count == 1) {
                    int userID = resultSet.getInt("ID");
                    SessionManager.setActiveUser(new User(
                            userID,
                            resultSet.getString("USERNAME"),
                            CryptKeeper.deCrypt(resultSet.getString("PASSWORD")),
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
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return -1;
    }
}