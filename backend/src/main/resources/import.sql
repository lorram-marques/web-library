INSERT INTO tb_category (name) VALUES ('History'); 
INSERT INTO tb_category (name) VALUES ('Business'); 
INSERT INTO tb_category (name) VALUES ('Science'); 
INSERT INTO tb_category (name) VALUES ('Religion'); 
INSERT INTO tb_category (name) VALUES ('Horror'); 
INSERT INTO tb_category (name) VALUES ('Other'); 

INSERT INTO tb_book (title, author) VALUES ('Epicuru Was Right', 'Lint Winters'); 
INSERT INTO tb_book_category (book_id, category_id) VALUES (1, 1);

INSERT INTO tb_book (title, author) VALUES ('How I Killed Pluto', 'Michael E. Brown'); 
INSERT INTO tb_book_category (book_id, category_id) VALUES (2, 3);

INSERT INTO tb_book (title, author) VALUES ('Journey of Souls', 'Michael Newton'); 
INSERT INTO tb_book_category (book_id, category_id) VALUES (3, 4);

INSERT INTO tb_book (title, author) VALUES ('The Rot', 'Lint Winters'); 
INSERT INTO tb_book_category (book_id, category_id) VALUES (4, 5);

INSERT INTO tb_book (title, author) VALUES ('Glitching Society', 'Markus Eden'); 
INSERT INTO tb_book_category (book_id, category_id) VALUES (5, 2);