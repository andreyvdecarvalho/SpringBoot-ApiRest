package med.oak.api.domain.consulta;

import med.oak.api.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CancelarConsulta {

    @Autowired
    ConsultaRepository consultaRepository;

    public void cancelar(DadosCancelamentoConsulta dadosCancelamentoConsulta) {
        var consulta = consultaRepository.getReferenceById(dadosCancelamentoConsulta.id());

        if(dadosCancelamentoConsulta.motivo().isBlank()){
            throw new ValidacaoException("Motivo precisa ser informado!");
        }

        if(LocalDateTime.now().plusHours(24).isBefore(consulta.getData())){
            consultaRepository.delete(consulta);
        } else {
            throw new ValidacaoException("Só podera ser cancelada com antecedencia minima de 24h!");
        }

    }
}
