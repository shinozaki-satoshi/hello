INSERT INTO  account (user_name, pass_word) VALUES 
  ('admin', '$2a$10$ofWs8hg7XAHd6QPT1H1SEuWy8r8TDbic0UFY5bTfJZlla4XHahfSW');

INSERT INTO Theme (theme_name, deadline_from, deadline_to,user_name) VALUES
('こんな法律はマッチョだ', '2024-04-01', '2024-04-15', 'admin'),
('スパイファミリーマートでありそうなことは？', '2024-04-01', '2024-04-30', 'admin'),
('メンヘラなお医者さん、どんなの？', '2024-11-01', '2024-12-31', 'admin');

  INSERT INTO answer (answer, theme_id,user_name, time ) VALUES 
  ('ムキ超ムキ', 1, 'admin','2024-12-31'),
  ('Second answer here', 1, 'admin', '2024-12-31'),
  ('夜勤の人をヨルさんと呼ぶ', 2, 'admin','2024-12-31'),
   ('Second answer', 2, 'admin','2024-12-31');

INSERT INTO vote(user_name,theme_id,answer_id,time) VALUES 
    ('admin',1,1,TIMESTAMP '2024-04-17 16:23:45.214'),
    ('admin',2,3,TIMESTAMP '2024-04-17 16:23:45.214');
