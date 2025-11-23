package med.oak.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<DadosListagemMedicos> findByOrderByNome(Pageable paginacao);

    Page<Medico> findByAtivoTrue(Pageable paginacao);
}
