package cadastroAlunos.services;

import cadastroAlunos.entities.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;


public class AlunoService {

    public static void run() {
        Locale.setDefault(Locale.US);
        List<Aluno> alunos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println();
            System.out.println("""
                    Selecione uma opção:
                    1 - Cadastrar Aluno
                    2 - Listar Alunos
                    3 - Pesquisar
                    4 - Sair""");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    sc.nextLine();
                    cadastrarAluno(sc, alunos);
                    break;
                case 2:
                    System.out.println();
                    Optional<String> listaDeAlunos = listarAlunos(alunos);
                    System.out.println(listaDeAlunos.get());
                    break;
                case 3:
                    System.out.println();
                    Optional<Aluno> result = pesquisa(sc, alunos);
                    if (result.isPresent()) System.out.println(result.get());
                    else System.out.println("Sem correspondências");
                    break;
            }
        } while (opcao != 4);
    }

    private static void cadastrarAluno(Scanner sc, List<Aluno> alunos) {
        System.out.println("Cadastro de Alunos");
        do {
            System.out.print("Informe o nome do aluno: ");
            String nome = sc.nextLine();
            System.out.print("Informe a matrícula do aluno: ");
            Integer matricula = sc.nextInt();
            sc.nextLine();
            System.out.print("Informe o curso do aluno: ");
            String curso = sc.nextLine();
            System.out.print("Informe o email do aluno: ");
            String email = sc.nextLine();
            System.out.print("Informe o telefone do aluno: ");
            String telefone = sc.nextLine();

            alunos.add(new Aluno(nome, matricula, curso, email, telefone));

            System.out.print("Deseja cadastrar outro aluno? (s/n) ");
        } while (sc.nextLine().equalsIgnoreCase("s"));
    }

    private static Optional<String> listarAlunos(List<Aluno> alunos) {
        System.out.println("Lista de Alunos: ");
        if (alunos.isEmpty())
            return Optional.of("Nenhum aluno cadastrado");
        else {
            StringBuilder sb = new StringBuilder();
            for (Aluno aluno : alunos) {
                sb.append(aluno + "\n");
            }
            return Optional.of(sb.toString());
        }
    }

    private static Optional<Aluno> pesquisa(Scanner sc, List<Aluno> alunos) {
        System.out.println("""
                Pesquisar por:
                1 - Nome
                2 - Matrícula
                3 - Email
                4 - Telefone""");

        int opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao) {
            case 1:
                System.out.print("Informe o nome do aluno: ");
                String nome = sc.nextLine();
                return alunos.stream().filter(aluno -> aluno.getNome().equalsIgnoreCase(nome)).findFirst();
            case 2:
                System.out.print("Informe a matrícula do aluno: ");
                Integer matricula = sc.nextInt();
                return alunos.stream().filter(aluno -> aluno.getMatricula().equals(matricula)).findFirst();
            case 3:
                System.out.print("Informe o email do aluno: ");
                String email = sc.nextLine();
                return alunos.stream().filter(aluno -> aluno.getEmail().equalsIgnoreCase(email)).findFirst();
            case 4:
                System.out.print("Informe o telefone do aluno: ");
                String telefone = sc.nextLine();
                return alunos.stream().filter(aluno -> aluno.getTelefone().equalsIgnoreCase(telefone)).findFirst();
            default:
                return Optional.empty();
        }
    }
}
