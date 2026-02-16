package med.oak.api.domain.medico;

import com.fasterxml.jackson.annotation.JsonAlias;

public enum Especialidade {
    @JsonAlias("cardiologia")
    CARDIOLOGIA,
    @JsonAlias("ortopedia")
    ORTOPEDIA,
    @JsonAlias("ginicologia")
    GINICOLOGIA,
    @JsonAlias("dermatologia")
    DERMATOLOGIA
}
