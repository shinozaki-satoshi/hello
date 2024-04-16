DROP TABLE IF EXISTS Theme;
CREATE TABLE Theme (
  theme_id SERIAL PRIMARY KEY,
  theme_name VARCHAR(255) NOT NULL,
  deadline_from DATE NOT NULL,
  deadline_to DATE NOT NULL
);

DROP TABLE IF EXISTS answer;
create table answer (
  answer_id serial not null
  , answer text not null
  , vote_num integer default 0
  , time timestamp(6) without time zone default CURRENT_TIMESTAMP
  , theme_id integer
  , primary key (answer_id)
);

DROP TABLE IF EXISTS account;
CREATE TABLE account (
   user_name VARCHAR(20) NOT NULL
 , pass_word VARCHAR(100) NOT NULL
 , primary key (user_name)
);