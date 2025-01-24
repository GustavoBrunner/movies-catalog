CREATE TABLE user(
    movie_qtd int,
    password varchar(200),
    username varchar(50),
    token varchar(20),
    email varchar(100),
    token_datetime datetime,
    function enum('client', 'dev'),
    id_user int auto_increment PRIMARY KEY
    UNIQUE(username)
);

