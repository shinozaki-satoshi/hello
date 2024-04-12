INSERT INTO Theme (theme_name, deadline_from, deadline_to) VALUES
('こんな法律はマッチョだ', '2024-04-01', '2024-04-15'),
('スパイファミリーマートでありそうなことは？', '2024-05-01', '2024-08-31'),
('メンヘラなお医者さん、どんなの？', '2024-11-01', '2024-12-31');

INSERT INTO public.answer (answer, theme_id, time ) VALUES 
  ('This is the first answer', 1, '2024-12-31'),
  ('Second answer here', 1, '2024-12-31'),
  ('Another answer', 2, '2024-12-31');