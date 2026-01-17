package med.oak.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.oak.api.domain.endereco.DadosEndereco;

public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
