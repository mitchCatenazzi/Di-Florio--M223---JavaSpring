create sequence if not exists blog_seq start with 1 increment by 1;
create table if not exists Blog(
    id integer primary key,
    title    varchar(50) not null,
    publishedDate Date not null,
    category  varchar(50) not null,
    author  varchar(50) not null,
    likes integer not null,
    content  clob not null
    );
