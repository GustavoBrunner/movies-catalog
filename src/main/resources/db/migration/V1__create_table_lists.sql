CREATE TABLE LISTS (
    movie_status enum('watched', 'favorite', 'watchlist'),
    id_client int auto_increment,
    id_movie int auto_increment,
    id_list int auto_increment,
    PRIMARY KEY (id_client, id_movie, id_list)
);