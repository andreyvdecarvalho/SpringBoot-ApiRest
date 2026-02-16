package med.oak.api.domain.consulta.validacao;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.DadosAgendarConsulta;
import med.oak.api.domain.paciente.PacienteRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsulta {

    PacienteRepository pacienteRepository;

    public void validar(DadosAgendarConsulta dadosAgendarConsulta) {
        var pacientesAtivo = pacienteRepository.findAtivoById(dadosAgendarConsulta.idPaciente());

        if (!pacientesAtivo) {
            throw new ValidacaoException("Paciente inativo!");
        }
    }
}
