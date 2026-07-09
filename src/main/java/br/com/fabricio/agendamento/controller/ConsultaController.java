package br.com.fabricio.agendamento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.fabricio.agendamento.dto.ConsultaRequest;
import br.com.fabricio.agendamento.dto.ConsultaResponse;
import br.com.fabricio.agendamento.service.ConsultaService;
import jakarta.validation.Valid;

/* Pacote Controller - "Porta" de comunicação entrada/saída da API com o cliente. Delega processamento ao Service */

@RestController
@RequestMapping("/consultas")
@Validated
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> listar() {

        return ResponseEntity.ok(service.listar());

    }

    @PostMapping
    public ResponseEntity<ConsultaResponse> agendar(
            @Valid @RequestBody ConsultaRequest request) {

        ConsultaResponse response = service.agendar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();

    }

}
