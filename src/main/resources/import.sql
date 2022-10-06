-- INSERT INTO centros (nome) VALUES ("CCJE");
-- INSERT INTO centros (nome) VALUES ("CCE");
-- INSERT INTO centros (nome) VALUES ("CT");

-- INSERT INTO cursos (nome, idCentro) VALUES ("Direito", 1);
-- INSERT INTO cursos (nome, idCentro) VALUES ("Arquivologia", 1);
-- INSERT INTO cursos (nome, idCentro) VALUES ("Física", 2);
-- INSERT INTO cursos (nome, idCentro) VALUES ("Ciência da Computação", 3);
-- INSERT INTO cursos (nome, idCentro) VALUES ("Engenharia da Computação", 3);

-- INSERT INTO enderecos (cep, rua, numero, complemento, bairro, cidade, estado)
-- VALUES ("29701740", "Camélia", "192", "", "Jardim Planalto", "Colatina", "ES");
-- INSERT INTO enderecos (cep, rua, numero, complemento, bairro, cidade, estado)
-- VALUES ("29701740", "Camélia", "192", "", "Jardim Planalto", "Colatina", "ES");
-- INSERT INTO enderecos (cep, rua, numero, complemento, bairro, cidade, estado)
-- VALUES ("29092260", "Esther Oliveira Galveas", "80", "Apto 505", "Jardim Camburi", "vitória", "ES");
-- INSERT INTO enderecos (cep, rua, numero, complemento, bairro, cidade, estado)
-- VALUES ("29092333", "Arlindo de Oliveira", "120", "Apto 301", "Braz", "Teixeira de Freitas", "BA");

-- INSERT INTO pessoas (idEndereco, nome, email, cpf, dataNascimento)
-- VALUES (3, "Guilherme Nicchio Pinotte", "gui@ufes.br", "11111111111", "1987-08-02");
-- INSERT INTO pessoas (idEndereco, nome, email, cpf, dataNascimento)
-- VALUES (1, "Rozana Maria Nicchio Pinotte", "rozana@ufes.br", "22222222222", "1968-05-07");
-- INSERT INTO pessoas (idEndereco, nome, email, cpf, dataNascimento)
-- VALUES (2, "João Bosco Pinotte", "bosco@ufes.br", "33333333333", "1957-10-23");
-- INSERT INTO pessoas (idEndereco, nome, email, cpf, dataNascimento)
-- VALUES (4, "Eduardo Nicchio Pinotte", "eduardo@ufes.br", "44444444444", "1983-08-12");

-- INSERT INTO alunos (idPessoa, idCurso, matricula, situacao, dataIngresso)
-- VALUES (1, 3, 2006100489,"inativo", "2006-02-01");
-- INSERT INTO alunos (idPessoa, idCurso, matricula, situacao, dataIngresso)
-- VALUES (2, 2, 2006100500, "ativo", "2020-05-11");
-- INSERT INTO alunos (idPessoa, idCurso, matricula, situacao, dataIngresso)
-- VALUES (3, 3, 2006100700, "ativo", "2019-02-01");
-- INSERT INTO alunos (idPessoa, idCurso, matricula, situacao, dataIngresso)
-- VALUES (4, 1, 2002100111, "inativo", "2017-01-25");