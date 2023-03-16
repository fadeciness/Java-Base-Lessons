package com.github.fadeciness.lesson9.classwork;

import java.sql.*;

public class Main {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) throws Exception {
        try {
            connect();
//            insertEx();
//            selectEx();
//            updateEx();
//            deleteSingleEx();
            deleteAllEx();
//            transactionAndPreparedStatement();
//            transactionAndPreparedStatementBatch();
            rollbackEx();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void rollbackEx() throws SQLException {
        statement.executeUpdate(
                "INSERT INTO students (name, score) VALUES ('Bob1', 80);"
        );
        Savepoint sp1 = connection.setSavepoint(); // команда отключает автокоммит, поэтому Bob3 не запишется, т.к. нужно принудительный connection.commit();
        statement.executeUpdate(
                "INSERT INTO students (name, score) VALUES ('Bob2', 80);"
        );
        connection.rollback(sp1);
        statement.executeUpdate(
                "INSERT INTO students (name, score) VALUES ('Bob3', 80);"
        );
    }

    private static void transactionAndPreparedStatementBatch() throws SQLException {
        long start = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 0; i < 10_000; i++) {
            preparedStatement.setString(1, "Bob" + (i+1));
            preparedStatement.setInt(2, 50);
//                preparedStatement.setObject();
//                preparedStatement.executeUpdate();
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    private static void transactionAndPreparedStatement() throws SQLException {
        long start = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 0; i < 10_000; i++) {
            preparedStatement.setString(1, "Bob" + (i+1));
            preparedStatement.setInt(2, 50);
//                preparedStatement.setObject();
            preparedStatement.executeUpdate();
        }
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    private static void deleteSingleEx() throws SQLException {
        statement.executeUpdate(
                "DELETE FROM students WHERE id = 3;"
        );
    }

    private static void deleteAllEx() throws SQLException {
        statement.executeUpdate(
                "DELETE FROM students;"
        );
    }

    private static void updateEx() throws SQLException {
        statement.executeUpdate(
                "UPDATE students SET score = 80 WHERE id = 1;"
        );
    }

    private static void selectEx() {
        // Сначала курсор не указывает ни на какую строку
        try (ResultSet rs = statement.executeQuery(
                "SELECT * FROM students;"
        )) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                                rs.getString("name") + " " +
                                rs.getInt("score")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int insertEx() throws SQLException {
        return statement.executeUpdate(
                "INSERT INTO students (name, score) VALUES ('Bob3', 100);"
        );
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lesson9-classwork-initdb.db");
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO students (name, score) VALUES (?, ?);"
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public static void disconnect() {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
