package br.com.fiap3espa.auto_escola_3espa.exception.type.aluno;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(String message) {
        super(message);
    }
}