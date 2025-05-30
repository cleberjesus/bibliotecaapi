create table books(
    id int not null primary key,
    title varchar(50) not null,
    author varchar(30),
    yearPublication INT,
    available BOOLEAN
);