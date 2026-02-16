package med.oak.api.domain.consulta;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.validacao.ValidadorAgendamentoConsulta;
import med.oak.api.domain.medico.Medico;
import med.oak.api.domain.medico.MedicoRepository;
import med.oak.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaConsulta {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadorAgendamentoConsultas;

    public DadosDetalhadosAgendamento agendar(DadosAgendarConsulta dadosAgendarConsulta){
        if (!pacienteRepository.existsById(dadosAgendarConsulta.idPaciente())){
            throw new ValidacaoException("id do paciente informado não existe!");
        }

        if (dadosAgendarConsulta.idMedico() != null && !medicoRepository.existsById(dadosAgendarConsulta.idMedico())){
            throw new ValidacaoException("id do médico informado não existe!");
        }

        //validações
        validadorAgendamentoConsultas.forEach(v -> v.validar(dadosAgendarConsulta));

        var paciente = pacienteRepository.getReferenceById(dadosAgendarConsulta.idPaciente());
        var medico = escolherMedico(dadosAgendarConsulta);
        if (medico == null){
            throw new ValidacaoException("Médico indisponivél nesta data");
        }
        var consulta = new Consulta(null, medico, paciente, dadosAgendarConsulta.data(), null);
        consultaRepository.save(consulta);

        return new DadosDetalhadosAgendamento(consulta);
    }

    private Medico escolherMedico(DadosAgendarConsulta dadosAgendarConsulta) {
        if (dadosAgendarConsulta.idMedico() != null){
            return  medicoRepository.getReferenceById(dadosAgendarConsulta.idMedico());
        }

        if (dadosAgendarConsulta.especialidade() == null){
            throw new ValidacaoException("Especialidade deve ser informada, quando não tem médico selecionado!");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dadosAgendarConsulta. especialidade(), dadosAgendarConsulta.data());
    }


}
