package main.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DataLink {
    private String connectionString = "jdbc:sqlite:src/main/resources/FeedbackDB.db";

    public void insertIntoResponseData(String user, int ResponseDataId) {
        try {
            Connection connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            stmt.execute("INSERT INTO ResponseData VALUES(\"" + user + "\"," + ResponseDataId + ")");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in insertIntoResponseData: " + e.getMessage());
        }
    }

    public void insertIntoResponse(int ResponseDataId, String QuestionIds) {
        try {
            Connection connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            stmt.execute("INSERT INTO Response VALUES(" + ResponseDataId + ", \"" + QuestionIds + "\")");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in insertIntoResponse: " + e.getMessage());
        }
    }

    public void insertIntoQuestions(int QuestionId, int Question_No, int QuestionResponse) {
        try {
            Connection connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            stmt.execute("INSERT INTO Questions VALUES(" + QuestionId + "," + Question_No + "," + QuestionResponse + ")");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in insertIntoQuestions: " + e.getMessage());
        }
    }

    public ArrayList<String> getAllQuestions(){
        ArrayList<String> allQUestions = new ArrayList<String>();
        try{
            Connection connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT Question FROM AllQuestions order by Question_No");
            while(result.next()){
                allQUestions.add(result.getString("Question"));
            }
            connection.close();
        }
        catch (SQLException e){
            System.out.println("Error in getAllQuestions: " + e.getMessage());
        }
        return allQUestions;
    }

    public ArrayList<Integer> getQuestionStatistics(int Question_No){
        ArrayList<Integer> stats = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT QuestionResponse FROM Questions where Question_No="+Question_No);
            while(result.next()){
                stats.add(result.getInt("QuestionResponse"));
            }
            connection.close();
        }
        catch (SQLException e){
            System.out.println("Error in getQuestionStatistics: " + e.getMessage());
        }
        return stats;
    }

    public HashMap<Integer, ArrayList<Integer>> getAllQuestionsStatistics(){
        HashMap<Integer, ArrayList<Integer>> allStats = new HashMap<>();
        try{
            Connection connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT Question_No from AllQuestions");
            while(result.next()){
                allStats.put(result.getInt("Question_No"), getQuestionStatistics(result.getInt("Question_No")));
            }
            connection.close();
        }
        catch (SQLException e){
            System.out.println("Error in getAllQuestionsStatistics: " + e.getMessage());
        }
        return allStats;
    }

    public ArrayList<Integer> getIndividualUserResponses(String user){
        ArrayList<Integer> userResponses = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM ResponseData");
            connection.close();
        }
        catch (SQLException e){
            System.out.println("Error in getIndividualUserResponse: " + e.getMessage());
        }
        return userResponses;
    }
}
