package med.oak.api.controller;

import jakarta.validation.Valid;
import med.oak.api.domain.consulta.DadosAgendarConsulta;
import med.oak.api.domain.consulta.DadosDetalhadosAgendamento;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendarConsulta dadosAgendarConsulta){
        System.out.println(dadosAgendarConsulta);

        return ResponseEntity.ok(new DadosDetalhadosAgendamento(null, null, null, null));
    }
}
