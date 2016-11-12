package servlets;

import dao.PessoaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pessoa;

@WebServlet(name = "PessoaController", urlPatterns = {"/PessoaController"})
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
            case "redirecionaExibir":
                redirecionaExibirCadastro(request, response);
                break;
            case "redirecionaEditar":
                redirecionaEditarCadastro(request, response);
                break;
            case "pesquisarEditar":
                redirecionaEditarCadastro(request, response);
                break;
            default:
                break;
        }
    }

    private void insereCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa p = new Pessoa();
        p.setId_pessoa(dao.maiorIDInserida());
        p.setNome(request.getParameter("nome"));
        p.setCpf(request.getParameter("cpf"));
        p.setRg(request.getParameter("rg"));
        dao.insert(p);

        response.sendRedirect("index.jsp");
    }

    private void redirecionaEditarCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("editar.jsp").forward(request, response);
    }

    private void editarCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa p = new Pessoa();
        p.setId_pessoa(Integer.parseInt(request.getParameter("id")));
        p.setNome(request.getParameter("nome"));
        p.setCpf(request.getParameter("cpf"));
        p.setRg(request.getParameter("rg"));
        dao.update(p);

        response.sendRedirect("index.jsp");
    }

    private void redirecionaExibirCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("exibir.jsp").forward(request, response);
    }

    private void deleteCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        dao.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("index.jsp");
    }

    private void pesquisarCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (dao.persist(Integer.parseInt(request.getParameter("data[search]")))) {

        }
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
