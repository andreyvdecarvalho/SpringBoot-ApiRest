package med.oak.api.domain.consulta.validacao;

import med.oak.api.domain.ValidacaoException;
import med.oak.api.domain.consulta.DadosAgendarConsulta;
import med.oak.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

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
