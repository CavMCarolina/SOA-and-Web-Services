-- Garante que a coluna perfil suporta os valores do enum Role (ADMIN, USER, STUDENT)
ALTER TABLE usuarios MODIFY COLUMN perfil VARCHAR(10) NOT NULL;
