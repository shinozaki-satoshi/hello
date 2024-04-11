DROP TABLE IF EXISTS Theme;
CREATE TABLE Theme (theme_id INT NULL,theme_name VARCHAR(255) NULL,deadline_from DATE NULL,deadline_to DATE NULL);

DROP TABLE IF EXISTS answer;
create table answer (
  answer_id serial not null
  , answer text not null
  , vote_num integer default 0
  , time timestamp(6) without time zone default CURRENT_TIMESTAMP
  , theme_id integer
  , primary key (answer_id)
);