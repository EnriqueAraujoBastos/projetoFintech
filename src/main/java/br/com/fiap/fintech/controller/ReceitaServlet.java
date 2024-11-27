package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.ReceitaDao;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Receita;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/receitas")
public class ReceitaServlet extends HttpServlet {

    private ReceitaDao dao;

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
            req.setAttribute("msg", "Receita Removida");
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
            double valor = Double
                    .parseDouble(req.getParameter("valor"));
            String categoria = req
                    .getParameter("categoria");
            String tipo = req
                    .getParameter("tipo");
            String origem = req
                    .getParameter("origem");
            Date recebimento = Date.valueOf(req.
                    getParameter("recebimento"));

            Receita receita = new Receita(
                    0,
                    descricao,
                    valor,
                    categoria,
                    tipo,
                    origem,
                    recebimento
            );

            dao.cadastrar(receita);

            req.setAttribute("mensagem", "Receita cadastrada!");

        }catch(DBException db) {
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar");
        }catch(Exception e){
            e.printStackTrace();
            req.setAttribute("erro","Por favor, valide os dados");
        }
        req.getRequestDispatcher("cadastro-receita.jsp").forward(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String descricao = req.getParameter("descricao");
            double valor = Double.parseDouble(req.getParameter("valor"));
            String categoria = req.getParameter("categoria");
            String tipo = req.getParameter("tipo");
            String origem = req.getParameter("origem");
            Date recebimento = Date.valueOf(req.getParameter("recebimento"));

            Receita receita = new Receita(id, descricao, valor, categoria, tipo, origem, recebimento);
            dao.atualizar(receita);

            req.setAttribute("msg", "Receita atualizada!");
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

        List<Receita> lista = dao.listar();
        req.setAttribute("receitas", lista);
        req.getRequestDispatcher("cadastro-receita.jsp").forward(req, resp);

    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Receita receita = dao.buscar(id);
        req.setAttribute("receita", receita);
        req.getRequestDispatcher("editar-receita.jsp")
                .forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Receita> lista = dao.listar();
        req.setAttribute("receitas", lista);
        req.getRequestDispatcher("lista-receita.jsp")
                .forward(req, resp);
        return;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        dao = DaoFactory.getReceitaDAO();

    }
}