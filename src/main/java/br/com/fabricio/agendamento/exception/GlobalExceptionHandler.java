package br.com.fabricio.agendamento.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RegraNegocioException.class)
	public ResponseEntity<ApiError> tratarRegraNegocio(RegraNegocioException ex) {

		ApiError erro = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Regra de Negócio",
				ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ApiError> tratarRecursoNaoEncontrado(RecursoNaoEncontradoException ex) {

		ApiError erro = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Recurso não encontrado",
				ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> tratarValidacao(MethodArgumentNotValidException ex) {

	    Map<String, String> campos = new LinkedHashMap<>();

	    ex.getBindingResult()
	      .getFieldErrors()
	      .forEach(erro -> campos.put(
	              erro.getField(),
	              erro.getDefaultMessage()));

	    ApiError apiError = new ApiError(
	            LocalDateTime.now(),
	            HttpStatus.BAD_REQUEST.value(),
	            "Erro de Validação",
	            "Os dados enviados são inválidos.");

	    apiError.setCampos(campos);

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(apiError);
	}

}