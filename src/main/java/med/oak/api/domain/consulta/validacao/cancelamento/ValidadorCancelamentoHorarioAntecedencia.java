package med.oak.api.domain.consulta.validacao.cancelamento;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.ConsultaRepository;
import med.oak.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorCancelamentoHorarioAntecedencia implements ValidadorCancelamentoConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosCancelamentoConsulta dadosCancelamentoConsulta) {
        var consulta = consultaRepository.getReferenceById(dadosCancelamentoConsulta.idConsulta());
        var agora = LocalDateTime.now();
        var diferenca = Duration.between(agora, consulta.getData()).toHours();

        if (diferenca < 24){
            throw new ValidacaoException("Cancelamento de consulta somente com 24h miníma de antecedência!");
        }
    }
}
