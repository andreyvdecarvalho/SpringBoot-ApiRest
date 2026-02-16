package med.oak.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;

public enum MotivoCancelamento {
    @JsonAlias({"pacienteDesistiu, paciente_desistiu"})
    PACIENTE_DESISTIU,
    @JsonAlias({"medicoCancelou, medico_cancelou"})
    MEDICO_CANCELOU,
    @JsonAlias("outros")
    OUTROS;
}
