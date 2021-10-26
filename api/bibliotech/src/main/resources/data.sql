INSERT INTO USUARIO(nome, email, senha) VALUES('Rafael', 'rafael@email.com', '$2a$10$CwHzz0TnNrosp0v8y/DVhu/Y7HQEIIHdKqKUlmMu2tOX6nF5joZgS');
INSERT INTO USUARIO(nome, email, senha) VALUES('Layane', 'layane@email.com', '$2a$10$O/GiWJVTUHS.Q/vy3/Qw.extEsAWdA81G.LcgrHcmPC1zDwVS7L6O');

INSERT INTO ACERVO(titulo, autor, editora, assunto, ano, qtd, usu_cadastro_id) VALUES('Dragon Ball vol 5', 'Akira Toryama','Panini Comics','Shonnen Fantasia',2016,10, 2);
INSERT INTO ACERVO(titulo, autor, editora, assunto, ano, qtd, usu_cadastro_id) VALUES('Bleach Vol 17', 'Tite Kubo','Editora JBC','Shonnen Fantasia',2008,22,2);
INSERT INTO ACERVO(titulo, autor, editora, assunto, ano, qtd, usu_cadastro_id) VALUES('Cavaleiros do Zodiaco vol 1', 'Masami Kurumada','Conrad Editora','Shonnen Fantasia',2004,8,2);
INSERT INTO ACERVO(titulo, autor, editora, assunto, ano, qtd, usu_cadastro_id) VALUES('Attack on titan', 'Hajime Isayama','Panini Comics','Shonnen Fantasia',2015,3,2);


INSERT INTO EMPRESTIMO(acervo_id, qtd, data_emprestimo, data_devolucao, cliente_id) VALUES(1, 1, '2021-10-23 18:00:00', '2021-11-02 18:00:00', 1);
INSERT INTO EMPRESTIMO(acervo_id, qtd, data_emprestimo, data_devolucao, cliente_id) VALUES(1, 2, '2021-10-24 18:00:00', '2021-11-03 18:00:00', 2);
INSERT INTO EMPRESTIMO(acervo_id, qtd, data_emprestimo, data_devolucao, cliente_id) VALUES(1, 2, '2021-10-25 18:00:00', '2021-11-04 18:00:00', 2);




