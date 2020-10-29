package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.services.Database;

import java.sql.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException {
        Database database = new Database();
        Connection connection = database.initialise();
        search(database, connection);
    }
    public static void search(Database database, Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which functionality would you like to use? \n1. Get all books \n2. Search by title \n3. Search by author \n4. Search by genre \nPlease enter the number.");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            database.getAllBooks(connection);
        }
        else if (choice.equals("2")){
            System.out.println("Enter title: ");
            String title = scanner.nextLine();
            database.getByTitle(connection, title);
        }
        else if (choice.equals("3")){
            System.out.println("Enter author: ");
            String author = scanner.nextLine();
            database.getByAuthor(connection, author);
        }
        else if (choice.equals("4")){
            System.out.println("Enter genre: ");
            String genre = scanner.nextLine();
            database.getByGenre(connection, genre);
        }
    }

}



        // TODO: print out the details of all the books (using JDBC)
        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html








