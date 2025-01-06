@Entity
public class Disciplina {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int codigo;
private String nome;
@ManyToMany(mappedBy = "disciplinas")
private List<Aluno> alunos = new ArrayList<>();
//getters
//setters
//toString()
}


...
@Transactional
public void cadastrarAlunoNaDisciplina() {
Aluno aluno = new Aluno();
aluno.setNome(“Maria Silva");
Disciplina disciplina = new Disciplina();
disciplina.setNome("ALPOO");
alunoDAO.salvar(aluno);
disciplinaDAO.salvar(disciplina);
aluno.getDisciplinas().add(disciplina);
disciplina.getAlunos().add(aluno);
}
...
