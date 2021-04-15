INSERT INTO author (firstName, lastName, birthDate, sex) VALUE ('Carl', 'Skriber', '1958-02-04', 'M');
INSERT INTO author (firstName, lastName, birthDate, sex) VALUE ('Anna', 'van Molen', '1963-07-04', 'F');
INSERT INTO author (firstName, lastName, birthDate, sex) VALUE ('Bernard', 'Buren', '1951-01-20', 'M');
INSERT INTO author (firstName, lastName, birthDate, sex) VALUE ('Jules', 'Verbeek', '1987-12-21', 'M');
INSERT INTO author (firstName, lastName, birthDate, sex) VALUE ('Femke', 'Berg', '1979-09-11', 'F');



SELECT * FROM author;


INSERT INTO books(title, author_id) VALUE ('Rode Rozen', 5);
INSERT INTO books(title, author_id) VALUE ('Het levensgedicht', 1);
INSERT INTO books(title, author_id) VALUE ('De Zwanen', 1);
INSERT INTO books(title, author_id) VALUE ('Amsterdam', 3);
INSERT INTO books(title, author_id) VALUE ('Verloren schipper', 3);
INSERT INTO books(title, author_id) VALUE ('Strand van as', 3);
INSERT INTO books(title, author_id) VALUE ('Gelukzoeken', 4);;
INSERT INTO books(title, author_id) VALUE ('Slim lenen', 4);
INSERT INTO books(title, author_id) VALUE ('Roze vriendschap', 2);
INSERT INTO books(title, author_id) VALUE ('De sluwe haatster', 2);
INSERT INTO books(title, author_id) VALUE ('Drama om niets', 2);

SELECT a.firstName, a.lastName, count(b.title) as bookCount FROM author a
                                                                     JOIN books b on a.author_id = b.author_id
GROUP BY a.firstName, a.lastName
ORDER BY bookCount DESC ;

