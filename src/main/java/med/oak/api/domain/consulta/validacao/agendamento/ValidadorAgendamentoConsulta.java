package med.oak.api.domain.consulta.validacao.agendamento;

import med.oak.api.domain.consulta.DadosAgendarConsulta;

public interface ValidadorAgendamentoConsulta {

    void validar(DadosAgendarConsulta dadosAgendarConsulta);
}
