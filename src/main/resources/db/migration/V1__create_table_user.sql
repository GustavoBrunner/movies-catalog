CREATE TABLE USER (
    id_user int auto_increment PRIMARY KEY,
    movie_qtd int,
    password varchar(200) not null,
    username varchar(50) not null,
    token varchar(20) not null,
    email varchar(100) not null,
    token_datetime datetime not null,
    function enum('client', 'dev') not null
);