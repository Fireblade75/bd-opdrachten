package com.example.databases.books.model.builders;

import com.example.databases.books.exceptions.BuilderAlreadyExecuted;
import com.example.databases.books.model.Author;
import com.example.databases.books.model.Gender;

import java.util.Date;

public class AuthorBuilder {
    private final Author author = new Author("", "", null, Gender.X);
    boolean executed = false;

    public AuthorBuilder() {
    }

    public AuthorBuilder setFirstName(String firstName) {
        author.setFirstName(firstName);
        return this;
    }

    public AuthorBuilder setLastName(String lastName) {
        author.setLastName(lastName);
        return this;
    }

    public AuthorBuilder setBirthDate(Date date) {
        author.setBirthDate(date);
        return this;
    }

    public AuthorBuilder setSex(Gender sex) {
        author.setSex(sex);
        return this;
    }

    public AuthorBuilder setId(int author_id) {
        author.setId(author_id);
        return this;
    }

    public Author build() {
        if(executed) {
            throw new BuilderAlreadyExecuted();
        }
        executed = true;
        return author;
    }

}
