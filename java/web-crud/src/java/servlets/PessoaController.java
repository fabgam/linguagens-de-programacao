package servlets;

import dao.PessoaDAO;
import factory.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pessoa;

@WebServlet(name = "PessoaController", urlPatterns = {"/PessoaController"})
public class PessoaController extends HttpServlet {

    private final PessoaDAO dao = new PessoaDAO();
    private boolean isDatabaseCreate;

    private void initConfig() {
        Database.create();
        setIsDatabaseCreate(true);
    }

    private boolean isDatabaseCreate() {
        return isDatabaseCreate;
    }

    private void setIsDatabaseCreate(boolean isDatabaseCreate) {
        this.isDatabaseCreate = isDatabaseCreate;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("enviar").equals("Salvar")) {
            insereCadastro(request, response);
        }
    }

    private void insereCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!isDatabaseCreate()) {
            initConfig();
        }

        Pessoa p = new Pessoa();
        p.setId_pessoa(dao.maiorIDInserida());
        p.setNome(request.getParameter("nome"));
        p.setCpf(request.getParameter("cpf"));
        p.setRg(request.getParameter("rg"));
        dao.insert(p);
        
        response.sendRedirect("index.jsp");
    }

    private void editarCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void listarCadastros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Pessoa> p = dao.getAll();

        if (p.isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                out.println("</html>");
            }
        } else {

        }
    }

    private void deleteCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        return "Short description";
    }
}
