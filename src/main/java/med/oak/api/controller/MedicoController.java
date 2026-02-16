package med.oak.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.oak.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dadosMedico, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dadosMedico);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosMedico(medico));
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<DadosListagemMedicos>> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        var page = repository.findByAtivoTrue(paginacao).map(DadosListagemMedicos::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarMedico atualizarMedico){
        var medico = repository.getReferenceById(atualizarMedico.id());
        medico.atualizarDados(atualizarMedico);

        return ResponseEntity.ok(new DadosDetalhadosMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.deletar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhadosMedico(medico));
    }

}
