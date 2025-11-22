package med.oak.api.medico;

import jakarta.validation.constraints.NotNull;
import med.oak.api.endereco.DadosEndereco;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
