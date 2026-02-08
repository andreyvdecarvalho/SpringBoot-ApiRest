package med.oak.api.domain.consulta;

import med.oak.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosDetalhadosAgendamento(Long id, Long idMedico, Long idPaciente, LocalDateTime date) {
}
