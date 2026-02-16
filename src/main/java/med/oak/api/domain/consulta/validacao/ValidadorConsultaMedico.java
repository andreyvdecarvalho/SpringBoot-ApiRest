package med.oak.api.domain.consulta.validacao;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.ConsultaRepository;
import med.oak.api.domain.consulta.DadosAgendarConsulta;

public class ValidadorConsultaMedico {

    ConsultaRepository consultaRepository;

    public void validar(DadosAgendarConsulta dadosAgendarConsulta) {
        var consultaMedicoNoMesmoHorario = consultaRepository.existsByMedicoIdAndData(dadosAgendarConsulta.idMedico(), dadosAgendarConsulta.data());

        if (consultaMedicoNoMesmoHorario) {
            throw new ValidacaoException("Não é permitido o médico ter mais de uma consulta na mesmo hora do dia!");
        }
    }
}
