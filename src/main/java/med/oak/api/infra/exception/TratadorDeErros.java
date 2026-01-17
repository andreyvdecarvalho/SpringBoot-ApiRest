package med.oak.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity erro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erro400(MethodArgumentNotValidException ex){
        var error = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(error.stream().map(DadosValidacaoErro::new).toList());
    }

    private record DadosValidacaoErro(String tipo, String mensagem){
        public DadosValidacaoErro(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
