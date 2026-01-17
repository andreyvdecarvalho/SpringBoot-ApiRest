package med.oak.api.domain.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.oak.api.domain.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Paciente(DadosCadastroPaciente dadosPaciente) {
        this.nome = dadosPaciente.nome();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.cpf = dadosPaciente.cpf();
        this.endereco = new Endereco(dadosPaciente.endereco());
        this.ativo = true;
    }

    public void atualizarDados(@Valid DadosAtualizarPaciente atualizarPaciente) {
        if(atualizarPaciente.nome() != null){
            this.nome = atualizarPaciente.nome();
        }
        if(atualizarPaciente.telefone() != null){
            this.telefone = atualizarPaciente.telefone();
        }
        if(atualizarPaciente.endereco() != null){
            this.endereco.atualizarEndereco(atualizarPaciente.endereco());
        }
    }

    public void deletar() {
        this.ativo = false;
    }
}
