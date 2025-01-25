CREATE TABLE RATING (
    rating_id int auto_increment,
    comment varchar(200),
    id_movie int auto_increment,
    id_appraiser  int auto_increment,
    PRIMARY KEY (rating_id, id_movie, id_appraiser )
);