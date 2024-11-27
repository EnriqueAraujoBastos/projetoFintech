package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Investimento;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/investimentos")
public class InvestimentoServlet extends HttpServlet {

    private InvestimentoDao dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao){
            case "cadastrar":
                cadastrar(req, resp);
                break;
            case "editar":
                editar(req, resp);
                break;
            case "excluir":
                excluir(req, resp);
        }

    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idExcluir"));
        try {
            dao.remover(id);
            req.setAttribute("msg", "Investimento Removida");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar");
        }
        listar(req, resp);
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String descricao = req
                    .getParameter("descricao");
            Double valor = Double
                    .parseDouble(req.getParameter("valor"));
            String categoria = req
                    .getParameter("categoria");
            String tipo = req
                    .getParameter("tipo");
            Date pagamento = Date.valueOf(req.
                    getParameter("pagamento"));

            Investimento investimento = new Investimento(
                    0,
                    descricao,
                    valor,
                    categoria,
                    tipo,
                    pagamento
            );

            dao.cadastrar(investimento);

            req.setAttribute("mensagem", "Investimento cadastrado!");

        }catch(DBException db) {
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar");
        }catch(Exception e){
            e.printStackTrace();
            req.setAttribute("erro","Por favor, valide os dados");
        }
        req.getRequestDispatcher("cadastro-investimento.jsp").forward(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String descricao = req.getParameter("descricao");
            double valor = Double.parseDouble(req.getParameter("valor"));
            String categoria = req.getParameter("categoria");
            String tipo = req.getParameter("tipo");
            Date pagamento = Date.valueOf(req.getParameter("pagamento"));

            Investimento investimento = new Investimento(id, descricao, valor, categoria, tipo, pagamento);
            dao.atualizar(investimento);

            req.setAttribute("msg", "Investimento atualizada!");
        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Por favor, valide os dados");
        }
        listar(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "listar":
                listar(req, resp);
                break;
            case "abrir-form-edicao":
                abrirForm(req, resp);
                break;
            case "abrir-form-cadastro":
                abrirFormCadastro(req, resp);
                break;
        }

    }

    private void abrirFormCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Investimento> lista = dao.listar();
        req.setAttribute("categorias", lista);
        req.getRequestDispatcher("cadastro-investimento.jsp").forward(req, resp);

    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Investimento investimento = dao.buscar(id);
        req.setAttribute("investimento", investimento);
        req.getRequestDispatcher("editar-investimento.jsp")
                .forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Investimento> lista = dao.listar();
        req.setAttribute("investimentos", lista);
        req.getRequestDispatcher("lista-investimentos.jsp")
                .forward(req, resp);
        return;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        dao = DaoFactory.getInvestimentoDAO();

    }
}