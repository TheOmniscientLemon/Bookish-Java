package org.softwire.training.bookish.services;

//package org.softwire.training.bookish;
import org.softwire.training.bookish.models.database.Book;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Database {
    public Connection initialise() throws SQLException {
        String hostname = "localhost";
        String database = "bookish";
        String user = "root";
        String password = "bookish1";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";
        Connection connection = DriverManager.getConnection(connectionString);
        return connection;
        /*try {
            Connection connection = DriverManager.getConnection(connectionString);
            return connection;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    }

    public static ArrayList<Book> getAllBooks(Connection connection) throws SQLException {
        ArrayList<Book> allBooks = new ArrayList<Book>();
        String titleQuery = "select * from book";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(titleQuery);
            while (rs.next()) {
                //int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");

                System.out.println(title+" by "+author+", genre: "+genre);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allBooks;
    }

    public static void getByTitle(Connection connection, String title) throws SQLException {
        String query = "select * from bookish.book where title=\""+title+"\"";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String book = rs.getString("title") + " by " + rs.getString("author") + ", genre: " + rs.getString("genre");

                System.out.println(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getByAuthor(Connection connection, String author) throws SQLException {
        String query = "select * from bookish.book where author=\""+author+"\"";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String book = rs.getString("title") + " by " + rs.getString("author") + ", genre: " + rs.getString("genre");

                System.out.println(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void getByGenre(Connection connection, String genre) throws SQLException {
        String query = "select * from bookish.book where genre=\""+genre+"\"";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String book = rs.getString("title") + " by " + rs.getString("author") + ", genre: " + rs.getString("genre");

                System.out.println(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

