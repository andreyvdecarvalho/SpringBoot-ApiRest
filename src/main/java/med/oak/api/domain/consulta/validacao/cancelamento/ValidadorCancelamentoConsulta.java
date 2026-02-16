package med.oak.api.domain.consulta.validacao.cancelamento;

import med.oak.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoConsulta {

    void validar(DadosCancelamentoConsulta dadosCancelamentoConsulta);
}
