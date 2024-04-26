package cadastroAlunos.entities;

public class Aluno {
    private final String nome;
    private final Integer matricula;
    private final String curso;
    private final String email;
    private final String telefone;

    public Aluno(String nome, Integer matricula, String curso, String email, String telefone) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return String.format(""" 
                
                Nome: %s
                Matrícula: %s
                Curso: %s
                Email: %s
                Telefone: %s""",
                nome, matricula, curso, email, telefone);
    }
}
