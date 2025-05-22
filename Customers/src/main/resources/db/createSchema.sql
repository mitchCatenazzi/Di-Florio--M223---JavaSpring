create sequence if not exists customer_seq start with 1 increment by 1;
create table if not exists Customer(
    id integer primary key,
    name    varchar(50) not null,
    surname varchar(50) not null,
    gender  varchar(50) not null,
    age     int         not null

    );
