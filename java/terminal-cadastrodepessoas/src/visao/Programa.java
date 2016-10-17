package visao;

import dao.PessoaDAO;
import factory.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Pessoa;

public class Programa {

    private final PessoaDAO dao = new PessoaDAO();
    private final Scanner input = new Scanner(System.in);

    public Programa() {
        Database.create();
    }

    public void menuInicial() {
        System.out.println("Escolha uma opção no menu:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Excluir por ID");
        System.out.println("3 - Exibir dados por ID");
        System.out.println("4 - Alterar dados");
        System.out.println("5 - Exibir todos");
        System.out.println("0 - Sair");
    }

    public void menuCadastrar() {
        System.err.println("Cadastro");
        System.out.println("Digite o nome da pessoa: ");
        input.nextLine();
        String nome = input.nextLine();
        System.out.println("Digite o CPF da pessoa: ");
        String cpf = input.nextLine();
        System.out.println("Digite o RG da pessoa: ");
        String rg = input.nextLine();
        dao.insert(new Pessoa(dao.maiorIDInserida() + 1, nome, cpf, rg));
    }

    public void menuExcluirPorID() {
        System.err.println("Exclusão por ID");
        System.out.println("Digite o ID da pessoa: ");
        int id = input.nextInt();
        if (dao.persist(id)) {
            dao.delete(id);
        } else {
            System.err.println("Cadastro inexistente.");
        }
    }

    public void menuExibirDadosPorID() {
        System.err.println("Exibir por ID");
        System.out.println("Digite a ID da pessoa: ");
        int id = input.nextInt();
        if (dao.persist(id)) {
            Pessoa p = dao.get(id);
            System.out.println(p.toString());
        } else {
            System.err.println("Cadastro inexistente.");
        }
    }

    public void menuAlterarDados() {
        System.err.println("Alteração");
        System.err.println("Digite o ID da pessoa");
        int id = input.nextInt();
        if (dao.persist(id)) {
            System.err.println("Digite o nome da pessoa para alterar: ");
            input.nextLine();
            String nome = input.nextLine();
            System.err.println("Digite o CPF da pessoa para alterar: ");
            String cpf = input.nextLine();
            System.err.println("Digite o RG da pessoa para alterar: ");
            String rg = input.nextLine();
            dao.update(new Pessoa(id, nome, cpf, rg));
        } else {
            System.err.println("Cadastro inexistente.");
        }
    }

    public void menuExibirTodos() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.addAll(dao.getAll());
        System.err.println("Exibir todos");
        System.err.println("Exibição de todos");
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i).toString());
        }
    }

    public boolean isDatabasePopulate() {
        return dao.maiorIDInserida() != 0;
    }

    public void controle() {
        int op = input.nextInt();

        switch (op) {
            case 1:
                menuCadastrar();
                break;
            case 2:
                if (!isDatabasePopulate()) {
                    System.err.println("Nenhum registro encontrado.");
                } else {
                    menuExcluirPorID();
                }
                break;
            case 3:
                if (!isDatabasePopulate()) {
                    System.err.println("Nenhum registro encontrado.");
                } else {
                    menuExibirDadosPorID();
                }
                break;
            case 4:
                if (!isDatabasePopulate()) {
                    System.err.println("Nenhum registro encontrado.");
                } else {
                    menuAlterarDados();
                }
                break;
            case 5:
                if (!isDatabasePopulate()) {
                    System.err.println("Nenhum registro encontrado.");
                } else {
                    menuExibirTodos();
                }
                break;
            case 0:
                System.exit(0);
            default:
                System.err.println("Opção inválida.");
                break;
        }
    }

    public static void main(String[] args) {
        Programa p = new Programa();
        for (;;) {
            p.menuInicial();
            p.controle();
        }
    }
}
