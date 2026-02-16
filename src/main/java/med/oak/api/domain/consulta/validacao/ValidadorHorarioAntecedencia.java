package med.oak.api.domain.consulta.validacao;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.DadosAgendarConsulta;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {

    public void validar(DadosAgendarConsulta dadosAgendarConsulta) {
        var consulta = dadosAgendarConsulta.data();
        var agora = LocalDateTime.now();
        var diferenca = Duration.between(agora, consulta).toMinutes();
        if (diferenca < 30) {
            throw new ValidacaoException("Agendamento deve ser no mínimo com 30 minutos de antecedência!");
        }
    }
}
