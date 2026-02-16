package med.oak.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhadosAgendamento(Long id, Long idMedico, Long idPaciente, LocalDateTime date) {

    public DadosDetalhadosAgendamento(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
