 CREATE TABLE MOVIE (
    movie_id int auto_increment PRIMARY KEY,
    title varchar(150) not null,
    year varchar(20) not null,
    released varchar(30) not null,
    runtime varchar(50) not null,
    genre varchar(15) not null,
    director varchar(50) not null,
    writer varchar(50) not null,
    actors varchar(300) not null,
    plot varchar(500) not null,
    language varchar(100) not null,
    country varchar(20) not null,
    awards varchar(150) not null,
    poster varchar(300) not null,
    imdb_rating varchar(200) not null,
    imdb_id varchar(50) not null
);

