package com.example.databases.books.dao;

import com.example.databases.books.exceptions.BookStoreException;
import com.example.databases.books.model.Author;
import com.example.databases.books.model.Gender;
import com.example.databases.books.model.builders.AuthorBuilder;

import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao implements BasicDao<Author> {

    private final Connection con;

    public AuthorDao(BookSqlConnection bookSqlConnection) {
        this.con = bookSqlConnection.getConnection();
    }

    public Author get(int authorId) {
        String query = "SELECT * FROM author WHERE author_id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, authorId);

            ResultSet rs = statement.executeQuery();
            if(!rs.next()) {
                return null;
            } else {
                return buildAuthorFromResult(rs);
            }
        } catch (SQLException e) {
            throw new BookStoreException(e);
        }
    }

    public List<Author> getAll() {
        List<Author> result = new ArrayList<>();
        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM author");
            while (rs.next()) {
                result.add(buildAuthorFromResult(rs));
            }
        } catch (SQLException e) {
            throw new BookStoreException(e);
        }
        return result;
    }

    private Author buildAuthorFromResult(ResultSet rs) throws SQLException {
        return new AuthorBuilder()
                .setId(rs.getInt("author_id"))
                .setFirstName(rs.getString("firstName"))
                .setLastName(rs.getString("lastName"))
                .setBirthDate(rs.getDate("birthDate"))
                .setSex(Gender.valueOf(rs.getString("sex")))
                .build();
    }

    @Override
    public void save(Author author) {
        if(author.hasId()) {
            String query = "UPDATE author SET firstName=?, lastName=?, birthDate=?, sex=? WHERE author_id=?";
            try {
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, author.getFirstName());
                statement.setString(2, author.getLastName());
                statement.setObject(3, author.getBirthDate().toInstant());
                statement.setString(4, author.getSex().toString());
                statement.setInt(5, author.getId());
                statement.executeQuery();
            } catch (SQLException e) {
                throw new BookStoreException(e);
            }
        } else {
            String query = "INSERT INTO author (firstName, lastName, birthDate, sex) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, author.getFirstName());
                statement.setString(2, author.getLastName());
                statement.setObject(3, author.getBirthDate().toInstant());
                statement.setString(4, author.getSex().toString());
                statement.executeQuery();
            } catch (SQLException e) {
                throw new BookStoreException(e);
            }
        }
    }
}
