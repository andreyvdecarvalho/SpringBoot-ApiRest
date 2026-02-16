package med.oak.api.domain.consulta.validacao;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.ConsultaRepository;
import med.oak.api.domain.consulta.DadosAgendarConsulta;

public class ValidadorConsultaPaciente {

    ConsultaRepository consultaRepository;

    public void validar(DadosAgendarConsulta dadosAgendarConsulta) {
        var primeiroHorario = dadosAgendarConsulta.data().withHour(7);
        var ultimoHorario = dadosAgendarConsulta.data().withHour(18);

        var consultaPaciente = consultaRepository.existsByPacienteIdAndDataBetween(dadosAgendarConsulta.idPaciente(), primeiroHorario, ultimoHorario);

        if (consultaPaciente) {
            throw new ValidacaoException("Não é permitido o paciente agendar mais de uma consulta no mesmo dia!");
        }

    }
}
