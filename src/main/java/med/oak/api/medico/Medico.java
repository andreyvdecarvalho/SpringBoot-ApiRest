package med.oak.api.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.oak.api.endereco.DadosEndereco;
import med.oak.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    String telefone;
    String crm;
    @Enumerated(EnumType.STRING)
    Especialidade especialidade;
    @Embedded
    Endereco endereco;

    public Medico(DadosCadastroMedico dadosMedico) {
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this. telefone = dadosMedico.telefone();
        this.crm = dadosMedico.crm();
        this.especialidade = dadosMedico.especialidade();
        this.endereco = new Endereco(dadosMedico.endereco());
    }

    public void atualizarDados(@Valid DadosAtualizarMedico dadosAtualiza) {
        if (dadosAtualiza.nome() != null){
            this.nome = dadosAtualiza.nome();
        }
        if(dadosAtualiza.telefone() !=null){
            this.telefone = dadosAtualiza.telefone();
        }
        if(dadosAtualiza.endereco() != null){
            this.endereco.atualizarEndereco(dadosAtualiza.endereco());
        }
    }
}
