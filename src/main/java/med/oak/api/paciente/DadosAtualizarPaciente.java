package med.oak.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.oak.api.endereco.DadosEndereco;

public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
