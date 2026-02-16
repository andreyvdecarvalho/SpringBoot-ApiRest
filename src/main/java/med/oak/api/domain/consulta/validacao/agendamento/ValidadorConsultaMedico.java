package med.oak.api.domain.consulta.validacao.agendamento;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.ConsultaRepository;
import med.oak.api.domain.consulta.DadosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConsultaMedico implements ValidadorAgendamentoConsulta {

    @Autowired
    ConsultaRepository consultaRepository;

    public void validar(DadosAgendarConsulta dadosAgendarConsulta) {
        var consultaMedicoNoMesmoHorario = consultaRepository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dadosAgendarConsulta.idMedico(), dadosAgendarConsulta.data());

        if (consultaMedicoNoMesmoHorario) {
            throw new ValidacaoException("Não é permitido o médico ter mais de uma consulta na mesmo hora do dia!");
        }
    }
}
