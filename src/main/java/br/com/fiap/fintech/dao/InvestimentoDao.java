package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Investimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDao {

    private Connection conexao;

    public void cadastrar(Investimento investimento) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Investimento (id_investimento, desc_investimento, vl_investido, categoria_investimento, tp_investimento, dt_investimento) VALUES (investimento_seq.NEXTVAL, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, investimento.getDescricao());
            stmt.setDouble(2, investimento.getValor());
            stmt.setString(3, investimento.getCategoria());
            stmt.setString(4, investimento.getTipo());
            stmt.setDate(5, investimento.getData());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public void atualizar(Investimento investimento) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE INVESTIMENTO SET " + "DESC_INVESTIMENTO = ?, " + "VL_INVESTIDO = ?, " + "CATEGORIA_INVESTIMENTO = ?, " + "TP_INVESTIMENTO = ?, " +  "DT_INVESTIMENTO = ? " + "WHERE ID_INVESTIMENTO = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, investimento.getDescricao());
            stmt.setDouble(2, investimento.getValor());
            stmt.setString(3, investimento.getCategoria());
            stmt.setString(4, investimento.getTipo());
            stmt.setDate(5, investimento.getData());
            stmt.setInt(6, investimento.getId());
            stmt.executeUpdate();

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void remover(int id) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM INVESTIMENTO WHERE ID_INVESTIMENTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Investimento buscar(int id) {

        Investimento investimento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM INVESTIMENTO WHERE ID_INVESTIMENTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idInvestimento = rs.getInt(("id_investimento"));
                String descricao = rs.getString("DESC_INVESTIMENTO");
                double valor = rs.getDouble("VL_INVESTIDO");
                String categoria = rs.getString("CATEGORIA_INVESTIMENTO");
                String tipo = rs.getString("TP_INVESTIMENTO");
                Date data = rs.getDate("DT_INVESTIMENTO");

                investimento = new Investimento( idInvestimento, descricao, valor, categoria, tipo, data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return investimento;
    }

    public List<Investimento> listar() {

        List<Investimento> lista = new ArrayList<Investimento>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM INVESTIMENTO";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_INVESTIMENTO");
                String descricao = rs.getString("DESC_INVESTIMENTO");
                double valor = rs.getDouble("VL_INVESTIDO");
                String categoria = rs.getString("CATEGORIA_INVESTIMENTO");
                String tipo = rs.getString("TP_INVESTIMENTO");
                Date data = rs.getDate("DT_INVESTIMENTO");


                Investimento investimento = new Investimento(id, descricao, valor, categoria, tipo, data);
                lista.add(investimento);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}