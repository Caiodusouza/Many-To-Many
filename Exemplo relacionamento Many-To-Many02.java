import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(
        name = "matriculas", // Nome da tabela intermediária
        joinColumns = @JoinColumn(name = "estudante_id"), // FK para Estudantes
        inverseJoinColumns = @JoinColumn(name = "curso_id") // FK para Cursos
    )
    private Set<Curso> cursos = new HashSet<>();

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}
