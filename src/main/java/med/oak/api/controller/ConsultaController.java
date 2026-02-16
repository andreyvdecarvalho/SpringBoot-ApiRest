package med.oak.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaConsulta agendaConsulta;

    @Autowired
    private CancelarConsulta cancelarConsulta;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendarConsulta dadosAgendarConsulta){

        var dto = agendaConsulta.agendar(dadosAgendarConsulta);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity remover(@RequestBody @Valid DadosCancelamentoConsulta dadosCancelamentoConsulta){

        cancelarConsulta.cancelar(dadosCancelamentoConsulta);

        return ResponseEntity.noContent().build();
    }
}
