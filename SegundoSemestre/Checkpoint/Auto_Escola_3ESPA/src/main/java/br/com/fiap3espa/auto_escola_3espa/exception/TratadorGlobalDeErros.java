package br.com.fiap3espa.auto_escola_3espa.exception;

import br.com.fiap3espa.auto_escola_3espa.exception.type.instrucao.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorGlobalDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> lidarComNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosBadRequest>> lidarComBadRequestException(MethodArgumentNotValidException ex) {
        List<FieldError> erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosBadRequest::new).toList());
    }

    // CP5: retorna 400 com a mensagem das regras de negócio
    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<DadosErro> lidarComValidacaoException(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(new DadosErro(ex.getMessage()));
    }

    private record DadosBadRequest(String campo, String mensagem) {
        public DadosBadRequest(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    private record DadosErro(String mensagem) {}
}
