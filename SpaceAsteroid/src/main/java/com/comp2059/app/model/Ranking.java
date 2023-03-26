package com.comp2059.app.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

/**
 * This class is to store, select and display ranking by using sqlite.
 * @author Jiafang Sun
 * @version 3.0
 * @since 10 December 2022
 */
public class Ranking {
    /**
     * The rank displayed in ranking stage.
     */
    public static ObservableList<String> rankingList = FXCollections.observableArrayList();
    public static int bestScore;
    public static int thisRoundRank;

    /**
     * Insert new ranking instance into database and put it into observable list by desc order for display.
     */
    public static void updateReadRanking() {
        // Get this round score and player's name from game stage.
        int score = GameStageModel.getScore();
        String name = GameStageModel.getName();

        try {
            Class.forName("org.sqlite.JDBC");

            // Connect with database.
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/comp2059/app/database/ranking.db");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from sqlite_master where type = 'table' and name = 'rank'");
            // If there is no table called "rank", create a new one.
            if(!resultSet.next()){
                statement.executeUpdate("CREATE TABLE rank (playerName CHAR(50), score INT);");
            }

            // Insert the new score into database.
            PreparedStatement ranks = connection.prepareStatement("insert into rank (playerName, score) values (?,?);");
            ranks.setString(1,name);
            ranks.setInt(2,score);
            ranks.addBatch();
            ranks.executeBatch();
            ranks.clearBatch();
            connection.commit();

            PreparedStatement readRanks = null;
            ResultSet resultSet1 = null;
            try{
                // Update the rank displayed in ranking stage.
                String sql = "select * from rank order by score desc";
                readRanks = connection.prepareStatement(sql);
                resultSet1 = readRanks.executeQuery();
                bestScore = resultSet1.getInt("score");
                rankingList.clear();
                int count = 0;
                while (resultSet1.next()){
                    count ++;
                    if (resultSet1.getString("playerName").equals(name) && resultSet1.getInt("score") == score) {
                        thisRoundRank = count;
                    }
                    rankingList.add("No. " + count + "        " + resultSet1.getString("playerName") +
                            "        " + resultSet1.getInt("score"));
                }
                resultSet1 = null;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try{
                    if(resultSet1 != null) resultSet.close();
                    if(readRanks != null) readRanks.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Display all the instances in the database by score desc order into observableList for ListView display for only read occasions.
     */
    public static void readRanking() {
        try {
            Class.forName("org.sqlite.JDBC");

            // Connect with database.
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/comp2059/app/database/ranking.db");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from sqlite_master where type = 'table' and name = 'rank'");
            // If there is no table called "rank", create a new one.
            if (!resultSet.next()) {
                statement.executeUpdate("CREATE TABLE rank (playerName CHAR(50), score INT);");
            }

            PreparedStatement readRanks = null;
            ResultSet resultSet1 = null;
            try {
                // Update the rank displayed in ranking stage.
                String sql = "select * from rank order by score desc";
                readRanks = connection.prepareStatement(sql);
                resultSet1 = readRanks.executeQuery();
                rankingList.clear();
                int count = 0;
                while (resultSet1.next()) {
                    count ++;
                    rankingList.add("No. " + count + "        " + resultSet1.getString("playerName") + "        " + resultSet1.getInt("score"));
                }
                resultSet1 = null;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet1 != null) resultSet.close();
                    if (readRanks != null) readRanks.close();
                    if (resultSet1 != null) resultSet1.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Get the best score from the database.
     * @return The best score.
     */
    public static int getBestScore() {
        PreparedStatement readRanks = null;
        ResultSet resultSet1;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/comp2059/app/database/ranking.db");
            String sql = "select * from rank order by score desc";
            readRanks = connection.prepareStatement(sql);
            resultSet1 = readRanks.executeQuery();
            bestScore = resultSet1.getInt("score");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(readRanks != null) readRanks.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bestScore;
    }
}
