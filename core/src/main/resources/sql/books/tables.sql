CREATE TABLE IF NOT EXISTS author
(
    `author_id` INT NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(20),
    `lastName`  VARCHAR(20),
    `birthDate` DATE,
    `sex`       CHAR(1),
    PRIMARY KEY (`author_id`)
    );

CREATE TABLE IF NOT EXISTS books
(
    `book_id`   INT NOT NULL AUTO_INCREMENT,
    `title`     VARCHAR(20),
    `author_id` INT,
    PRIMARY KEY (book_id),
    FOREIGN KEY (`author_id`)
    REFERENCES author (`author_id`)
    ON DELETE SET NULL
    );

CREATE TABLE IF NOT EXISTS book_editions
(
    `edition_id`    INT NOT NULL AUTO_INCREMENT,
    `book_id`       INT NOT NULL,
    `edition_label` VARCHAR(20),
    `price`         DECIMAL(10,2),
    PRIMARY KEY (`edition_id`),
    FOREIGN KEY (`book_id`)
    REFERENCES books (`book_id`)
    ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS awards
(
    `award_id`      INT NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(20),
    `organisation`  VARCHAR(20),
    PRIMARY KEY (`award_id`)
    );

CREATE TABLE IF NOT EXISTS book_awards
(
    `award_id`      INT NOT NULL,
    `book_id`       INT NOT NULL,
    PRIMARY KEY (`award_id`, `book_id`),
    FOREIGN KEY (`book_id`)
    REFERENCES books (`book_id`)
    ON DELETE CASCADE,
    FOREIGN KEY (`award_id`)
    REFERENCES awards (`award_id`)
    ON DELETE CASCADE
    );