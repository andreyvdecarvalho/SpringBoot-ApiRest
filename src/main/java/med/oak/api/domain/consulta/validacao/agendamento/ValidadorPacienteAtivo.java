package med.oak.api.domain.consulta.validacao.agendamento;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.DadosAgendarConsulta;
import med.oak.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsulta {

    @Autowired
    PacienteRepository pacienteRepository;

    public void validar(DadosAgendarConsulta dadosAgendarConsulta) {
        var pacientesAtivo = pacienteRepository.findAtivoById(dadosAgendarConsulta.idPaciente());

        if (!pacientesAtivo) {
            throw new ValidacaoException("Paciente inativo!");
        }
    }
}
