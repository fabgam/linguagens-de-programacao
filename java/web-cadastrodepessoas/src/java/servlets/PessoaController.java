package servlets;

import dao.PessoaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pessoa;

@WebServlet(name = "PessoaController", urlPatterns = {"/pessoa", "/novocadastro", "/editcadastro", "/infocadastro", "/deletecadastro"})
public class PessoaController extends HttpServlet {

    private final PessoaDAO dao = new PessoaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("action")) {
            case "novo":
                insereCadastro(request, response);
                break;
            case "editar":
                editarCadastro(request, response);
                break;
            case "remover":
                deleteCadastro(request, response);
                break;
            case "redirecionaInfo":
                redirecionaInfoCadastro(request, response);
                break;
            case "redirecionaEditar":
                redirecionaEditarCadastro(request, response);
                break;
            case "redirecionaExibir":
                redirecionaExibirListagem(request, response);
                break;
            default:
                break;
        }
    }

    private void insereCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!validaCadastro(request, response)) {
            request.setAttribute("status", "erroCadastroCampoVazio");
            request.getRequestDispatcher("exibir.jsp").forward(request, response);
        } else {
            Pessoa p = new Pessoa();
            p.setId_pessoa(dao.maiorIDInserida());
            p.setNome(request.getParameter("nome"));
            p.setCpf(request.getParameter("cpf"));
            p.setRg(request.getParameter("rg"));
            dao.persist(p);
            request.setAttribute("status", "inseridoComSucesso");
            request.getRequestDispatcher("exibir.jsp").forward(request, response);
        }
    }

    private void redirecionaEditarCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        preparaRequest(request);
        request.getRequestDispatcher("editar.jsp").forward(request, response);
    }

    private void editarCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!validaCadastro(request, response)) {
            request.setAttribute("status", "erroAtualizacaoCampoVazio");
            request.getRequestDispatcher("exibir.jsp").forward(request, response);
        } else {
            Pessoa p = new Pessoa();
            p.setId_pessoa(Integer.parseInt(request.getParameter("id")));
            p.setNome(request.getParameter("nome"));
            p.setCpf(request.getParameter("cpf"));
            p.setRg(request.getParameter("rg"));
            dao.update(p);
            request.setAttribute("status", "atualizadoComSucesso");
            request.getRequestDispatcher("exibir.jsp").forward(request, response);
        }
    }

    private void redirecionaInfoCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        preparaRequest(request);
        request.getRequestDispatcher("info.jsp").forward(request, response);
    }

    private void deleteCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dao.delete(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("status", "deletadoComSucesso");
        request.getRequestDispatcher("exibir.jsp").forward(request, response);
    }

    private void redirecionaExibirListagem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("exibir.jsp");
    }

    private void preparaRequest(HttpServletRequest request) {
        Pessoa p = dao.get(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("id", p.getId_pessoa());
        request.setAttribute("nome", p.getNome());
        request.setAttribute("cpf", p.getCpf());
        request.setAttribute("rg", p.getRg());
    }

    private boolean validaCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return !(request.getParameter("nome").trim().equals("")
                || request.getParameter("cpf").trim().equals("")
                || request.getParameter("rg").trim().equals(""));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Pessoa controller servlet";
    }
}
