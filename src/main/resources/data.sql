INSERT INTO Theme (theme_name, deadline_from, deadline_to) VALUES
('こんな法律はマッチョだ', '2024-04-01', '2024-04-15'),
('スパイファミリーマートでありそうなことは？', '2024-05-01', '2024-08-31'),
('AAA', '2024-05-01', '2024-08-31'),
('BBB', '2024-05-01', '2024-08-31'),
('CCC', '2024-05-01', '2024-08-31'),
('DDD', '2024-05-01', '2024-08-31'),
('メンヘラなお医者さん、どんなの？', '2024-11-01', '2024-12-31');

INSERT INTO answer (answer, theme_id, time ) VALUES 
  ('This is the first answer', 1, '2024-12-31'),
  ('Second answer here', 1, '2024-12-31'),
  ('Another answer', 2, '2024-12-31');

INSERT INTO  account (user_name, pass_word) VALUES 
  ('admin', '$2a$10$ofWs8hg7XAHd6QPT1H1SEuWy8r8TDbic0UFY5bTfJZlla4XHahfSW');

INSERT INTO vote(user_name,theme_id,answer_id,time) VALUES 
    ('admin',1,1,TIMESTAMP '2024-04-17 16:23:45.214'),
    ('admin',2,1,TIMESTAMP '2024-04-17 16:23:45.214');
