package med.oak.api.domain.consulta.validacao;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.DadosAgendarConsulta;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoDaClinica {

    public void validar(DadosAgendarConsulta dadosAgendarConsulta) {
        var dataDaConsulta = dadosAgendarConsulta.data();

        var domingo = dataDaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataDaConsulta.getHour() < 7;
        var depoisDaAberturaDaClinica = dataDaConsulta.getHour() > 18;

        if (domingo || antesDaAberturaDaClinica || depoisDaAberturaDaClinica) {
            throw new ValidacaoException("Consulta fora do horário de atendimento!");
        }
    }
}
