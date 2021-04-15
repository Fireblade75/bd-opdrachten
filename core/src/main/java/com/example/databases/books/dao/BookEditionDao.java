package com.example.databases.books.dao;

import com.example.databases.books.exceptions.BookStoreException;
import com.example.databases.books.model.Author;
import com.example.databases.books.model.Book;
import com.example.databases.books.model.BookEdition;
import com.example.databases.books.model.builders.BookBuilder;
import com.example.databases.books.model.builders.BookEditionBuilder;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookEditionDao {

    private static final BigDecimal STANDARD_BOOK_PRICE = new BigDecimal("15.00");
    private final Connection con;
    private final BookDao bookDao;

    public BookEditionDao(BookSqlConnection bookSqlConnection, BookDao bookDao) {
        this.con = bookSqlConnection.getConnection();
        this.bookDao = bookDao;
    }

    public void addStandardEditionForAllBooks() {
        List<Book> books = bookDao.getBooks();

        String query = "INSERT INTO book_editions(book_id, edition_label, price) VALUES (?, ?, ?)";
        try {
            var statement = con.prepareStatement(query);

            for(Book book : books) {
                statement.setInt(1, book.getId());
                statement.setString(2, "standard edition");
                statement.setBigDecimal(3, STANDARD_BOOK_PRICE);
                statement.addBatch();
            }

            int[] rows = statement.executeBatch();
            System.out.println("Added " + rows.length + " new editions");

        } catch (SQLException e) {
            throw new BookStoreException(e);
        }
    }

    public List<BookEdition> getEditionsFromBook(Book book) {
        List<BookEdition> result = new ArrayList<>();
        if(book.hasId()) {
            String query = "SELECT * FROM book_editions WHERE book_id = ?";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setInt(1, book.getId());

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    result.add(buildBookEditionFromResult(rs));
                }
            } catch (SQLException e) {
                throw new BookStoreException(e);
            }
        }
        return result;
    }

    private BookEdition buildBookEditionFromResult(ResultSet rs) throws SQLException {
        Book book = bookDao.getBook(rs.getInt("book_id"));

        return new BookEditionBuilder()
                .setId(rs.getInt("edition_id"))
                .setBook(book)
                .setLabel(rs.getString("edition_label"))
                .setPrice(rs.getBigDecimal("price"))
                .build();
    }
}
