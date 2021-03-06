package br.com.java.terminal.cad.view;

import br.com.java.terminal.cad.dao.PessoaDAO;
import br.com.java.terminal.cad.factory.Database;
import br.com.java.terminal.cad.model.Pessoa;
import br.com.java.terminal.cad.util.ProgramaUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaView {

    private PessoaDAO dao = new PessoaDAO();
    private Scanner input = new Scanner(System.in);
    private ProgramaUtil util = new ProgramaUtil();

    public ProgramaView() {
        Database db = new Database();
        db.create();
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
        String nome = input.nextLine();
        System.out.println("Digite o CPF da pessoa: ");
        String cpf = input.nextLine();
        System.out.println("Digite o RG da pessoa: ");
        String rg = input.nextLine();

        if (util.isCadastroValido(nome, cpf, rg)) {
            Pessoa p = new Pessoa();
            p.setId_pessoa(dao.maiorIDInserida());
            p.setNome(nome);
            p.setCpf(cpf);
            p.setRg(rg);
            dao.persist(p);
            System.err.println("Cadastro realizado com sucesso.");
        } else {
            System.err.println("Cadastro não realizado.");
            System.err.println("Preencha todos os campos.");
        }
    }

    public void menuExcluirPorID() {

        System.err.println("Exclusão por ID");
        System.out.println("Digite o ID da pessoa: ");
        String str = input.nextLine();

        if (util.isDigit(str)) {
            if (dao.isIDExistente(util.strToInt(str))) {
                dao.delete(util.strToInt(str));
                System.err.println("Cadastro removido com sucesso.");
            } else {
                System.err.println("Cadastro inexistente.");
            }
        } else {
            System.err.println("Entrada inválida.");
        }
    }

    public void menuExibirDadosPorID() {

        System.err.println("Exibir por ID");
        System.out.println("Digite a ID da pessoa: ");
        String str = input.nextLine();

        if (util.isDigit(str)) {
            if (dao.isIDExistente(util.strToInt(str))) {
                Pessoa p = dao.get((util.strToInt(str)));
                System.out.println(p.toString());
            } else {
                System.err.println("Cadastro inexistente.");
            }
        } else {
            System.err.println("Entrada inválida.");
        }
    }

    public void menuAlterarDados() {

        System.err.println("Alteração");
        System.err.println("Digite o ID da pessoa");
        String str = input.nextLine();

        if (util.isDigit(str)) {
            if (dao.isIDExistente(util.strToInt(str))) {

                System.err.println("Digite o nome da pessoa para alterar: ");
                String nome = input.nextLine();
                System.err.println("Digite o CPF da pessoa para alterar: ");
                String cpf = input.nextLine();
                System.err.println("Digite o RG da pessoa para alterar: ");
                String rg = input.nextLine();

                if (util.isCadastroValido(nome, cpf, rg)) {
                    dao.update(new Pessoa(util.strToInt(str), nome, cpf, rg));
                    System.err.println("Alteração no cadastro realizada com sucesso.");
                } else {
                    System.err.println("Dados inválidos.");
                    System.err.println("Alteração no cadastro não realizada.");
                }
            } else {
                System.err.println("Cadastro inexistente.");
            }
        } else {
            System.err.println("Entrada inválida.");
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

    public void controle() {

        String str = input.nextLine();

        if (util.isDigit(str)) {

            switch (util.strToInt(str)) {
                case 1:
                    menuCadastrar();
                    break;
                case 2:
                    if (!util.isDatabasePopulate()) {
                        System.err.println("Nenhum registro encontrado.");
                    } else {
                        menuExcluirPorID();
                    }
                    break;
                case 3:
                    if (!util.isDatabasePopulate()) {
                        System.err.println("Nenhum registro encontrado.");
                    } else {
                        menuExibirDadosPorID();
                    }
                    break;
                case 4:
                    if (!util.isDatabasePopulate()) {
                        System.err.println("Nenhum registro encontrado.");
                    } else {
                        menuAlterarDados();
                    }
                    break;
                case 5:
                    if (!util.isDatabasePopulate()) {
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
        } else {
            System.err.println("Entrada inválida.");
            System.err.println("Apenas números.");
        }
    }

    public static void main(String[] args) {
        ProgramaView p = new ProgramaView();

        for (;;) {
            p.menuInicial();
            p.controle();
        }
    }
}
