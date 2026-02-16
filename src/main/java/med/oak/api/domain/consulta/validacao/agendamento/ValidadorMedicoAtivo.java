package med.oak.api.domain.consulta.validacao.agendamento;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.DadosAgendarConsulta;
import med.oak.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta {

    @Autowired
    MedicoRepository medicoRepository;

    public void validar(DadosAgendarConsulta dadosAgendarConsulta) {
        if (dadosAgendarConsulta.idMedico() == null) {
            return;
        }

        var medicoAtivo = medicoRepository.findAtivoById(dadosAgendarConsulta.idMedico());

        if (!medicoAtivo) {
            throw new ValidacaoException("Médico inativo!");
        }
    }

}
