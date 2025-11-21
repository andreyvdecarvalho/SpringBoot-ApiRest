package med.oak.api.medico;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<DadosListagemMedicos> findByOrderByNome(Pageable paginacao);

}
