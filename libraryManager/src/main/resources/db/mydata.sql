
--CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;
--CREATE SEQUENCE IF NOT EXISTS book_seq START WITH 1 INCREMENT BY 1;
--CREATE SEQUENCE IF NOT EXISTS reservation_seq START WITH 1 INCREMENT BY 1;

INSERT INTO MyUser (id, name, surname, email, borrowedbooks)
VALUES (NEXTVAL('user_seq'), 'admin', 'cpt', 'admin@cpt.ti', 1);

INSERT INTO Book (id, name, author, type, storyline)
VALUES
    (NEXTVAL('book_seq'), '1984', 'George Orwell', 'Romanzo', 'Una distopia ambientata in un regime totalitario.'),
    (NEXTVAL('book_seq'), 'Il Signore degli Anelli', 'J.R.R. Tolkien', 'Fantasy', 'Un viaggio epico per distruggere un anello'),
    (NEXTVAL('book_seq'), 'Il Piccolo Principe', 'Antoine de Saint-Exupéry', 'Favola', 'Un racconto poetico riguardante infanzia e l umanità.' );

INSERT INTO Reservation (id, user_id, book_id, registrationdate, expirationdate)
VALUES (
    NEXTVAL('reservation_seq'),
    1,
    1,
    CURRENT_DATE,
    DATEADD('DAY', 30, CURRENT_DATE)
);
