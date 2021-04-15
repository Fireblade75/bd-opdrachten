package com.example.databases.books.dao;

import com.example.databases.books.exceptions.BookStoreException;
import com.example.databases.books.model.Author;
import com.example.databases.books.model.Book;
import com.example.databases.books.model.builders.BookBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private final Connection con;
    private final AuthorDao authorDao;

    public BookDao(BookSqlConnection bookSqlConnection, AuthorDao authorDao) {
        this.con = bookSqlConnection.getConnection();
        this.authorDao = authorDao;
    }

    public Book getBook(int bookId) {
        String query = "SELECT * FROM books WHERE book_id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, bookId);

            ResultSet rs = statement.executeQuery();
            if(!rs.next()) {
                return null;
            } else {
                return buildBookFromResult(rs);
            }
        } catch (SQLException e) {
            throw new BookStoreException(e);
        }
    }

    public List<Book> getBooks() {
        List<Book> result = new ArrayList<>();
        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                result.add(buildBookFromResult(rs));
            }
        } catch (SQLException e) {
            throw new BookStoreException(e);
        }
        return result;
    }

    public List<Book> getBooksFromAuthor(Author author) {
        List<Book> result = new ArrayList<>();
        String query = "SELECT * FROM books WHERE author_id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, author.getId());
            ResultSet rs = statement.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                result.add(buildBookFromResult(rs));
            }
        } catch (SQLException e) {
            throw new BookStoreException(e);
        }
        return result;
    }

    private Book buildBookFromResult(ResultSet rs) throws SQLException {
        Author author = authorDao.get(rs.getInt("author_id"));

        return new BookBuilder()
                .setId(rs.getInt("book_id"))
                .setTitle(rs.getString("title"))
                .setAuthor(author)
                .build();
    }
}
