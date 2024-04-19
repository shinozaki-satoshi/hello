DROP TABLE IF EXISTS vote;
DROP TABLE IF EXISTS answer;

DROP TABLE IF EXISTS Theme;


DROP TABLE IF EXISTS account;
CREATE TABLE account (
 user_name VARCHAR(20) NOT NULL,
 pass_word VARCHAR(100) NOT NULL,
 PRIMARY KEY (user_name)
);

CREATE TABLE Theme (
  theme_id SERIAL PRIMARY KEY,
  theme_name VARCHAR(255) NOT NULL,
  deadline_from DATE NOT NULL,
  deadline_to DATE NOT NULL,
  user_name VARCHAR(20) NOT NULL,
  FOREIGN KEY (user_name) REFERENCES account(user_name)
);

CREATE TABLE answer (
  answer_id SERIAL NOT NULL,
  answer TEXT NOT NULL,
  time TIMESTAMP(6) WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
  theme_id INTEGER,
  user_name VARCHAR(20) NOT NULL,
  PRIMARY KEY (answer_id),
  FOREIGN KEY (theme_id) REFERENCES Theme(theme_id),
  FOREIGN KEY (user_name) REFERENCES account(user_name)
);

CREATE TABLE vote (
  user_name VARCHAR(20),
  theme_id INTEGER,
  answer_id INTEGER,
  time TIMESTAMP(6) WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (theme_id, user_name),
  FOREIGN KEY (theme_id) REFERENCES theme(theme_id),
  FOREIGN KEY (user_name) REFERENCES account(user_name),
  FOREIGN KEY (answer_id) REFERENCES answer(answer_id)
);
