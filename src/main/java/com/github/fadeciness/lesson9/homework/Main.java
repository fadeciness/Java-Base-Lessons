package com.github.fadeciness.lesson9.homework;

import com.github.fadeciness.lesson9.homework.entity.Fish;
import com.github.fadeciness.lesson9.homework.processor.DbInsertQueryProcessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();
//            String query = DbSchemaCreationAnnotationProcessor.createTableQuery(Fish.class);
//            statement.executeUpdate(query);
//            String query = DbSchemaCreationAnnotationProcessor.createTableQuery(Cat.class);
//            statement.executeUpdate(query);
//            query = DbSchemaCreationAnnotationProcessor.createTableQuery(Dog.class);
//            statement.executeUpdate(query);
//            String query = DbInsertQueryProcessor.insertQuery(new Cat(1, "Tomcat", 11));
            String query = DbInsertQueryProcessor.insertQuery(new Fish());
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        System.out.println("Program finished");
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lesson9-homework.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
