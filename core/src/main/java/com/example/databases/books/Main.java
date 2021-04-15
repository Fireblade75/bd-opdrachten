package com.example.databases.books;

import com.example.databases.books.dao.AuthorDao;
import com.example.databases.books.dao.BookDao;
import com.example.databases.books.dao.BookEditionDao;
import com.example.databases.books.dao.BookSqlConnection;
import com.example.databases.books.model.Author;
import com.example.databases.books.model.Book;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try(BookSqlConnection connection = new BookSqlConnection()) {;

            AuthorDao authorDao = new AuthorDao(connection);
            BookDao bookDao = new BookDao(connection, authorDao);
            BookEditionDao editionDao = new BookEditionDao(connection, bookDao);

//            var authors = authorDao.getAuthors();
//            System.out.println(authors);


            editionDao.addStandardEditionForAllBooks();

            Author author = authorDao.get(2);
            List<Book> books = bookDao.getBooksFromAuthor(author);
            for(Book book : books) {
                System.out.println(editionDao.getEditionsFromBook(book));
            }

        } catch (SQLException e) {
            System.err.println("Database error " + e.getMessage());
        }
    }
}
