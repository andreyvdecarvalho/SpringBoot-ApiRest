package med.oak.api.controller;

import jakarta.validation.Valid;
import med.oak.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dadosMedico){
        repository.save(new Medico(dadosMedico));
    }

    @GetMapping
    @Transactional
    public Page<DadosListagemMedicos> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico atualizarMedico){
        var medico = repository.getReferenceById(atualizarMedico.id());
        medico.atualizarDados(atualizarMedico);
    }

}
