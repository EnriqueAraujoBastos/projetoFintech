package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Receita;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDao {

    private Connection conexao;

    public void cadastrar(Receita receita) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Receita (id_receita, desc_receita, vl_receita, categoria_receita, tp_receita, origem_receita, dt_recebimento_receita) VALUES (receita_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, receita.getDescricao());
            stmt.setDouble(2, receita.getValor());
            stmt.setString(3, receita.getCategoria());
            stmt.setString(4, receita.getTipo());
            stmt.setString(5, receita.getOrigem());
            stmt.setDate(6, receita.getData());
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


    public void atualizar(Receita receita) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE RECEITA SET " + "DESC_RECEITA = ?, " + "VL_RECEITA = ?, " + "CATEGORIA_RECEITA = ?, " + "TP_RECEITA = ?, " + "ORIGEM_RECEITA = ?, " + "DT_PAGAMENTO_DESPESA = ? " + "WHERE ID_RECEITA = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, receita.getDescricao());
            stmt.setDouble(2, receita.getValor());
            stmt.setString(3, receita.getCategoria());
            stmt.setString(4, receita.getTipo());
            stmt.setString(5, receita.getOrigem());
            stmt.setDate(6, receita.getData());
            stmt.setInt(7, receita.getId());
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
            String sql = "DELETE FROM RECEITA WHERE ID_RECEITA = ?";
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

    public Receita buscar(int id) {

        Receita receita = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM RECEITA WHERE ID_RECEITA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idReceita = rs.getInt(("ID_RECEITA"));
                String descricao = rs.getString("DESC_RECEITA");
                double valor = rs.getDouble("VL_RECEITA");
                String categoria = rs.getString("CATEGORIA_RECEITA");
                String tipo = rs.getString("TP_RECEITA");
                String origem = rs.getString("ORIGEM_RECEITA");
                Date data = rs.getDate("DT_PAGAMENTO_RECEITA");

                receita = new Receita( idReceita, descricao, valor, categoria, tipo, origem, data);
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
        return receita;
    }

    public List<Receita> listar() {

        List<Receita> lista = new ArrayList<Receita>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM RECEITA";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_RECEITA");
                String descricao = rs.getString("DESC_RECEITA");
                double valor = rs.getDouble("VL_RECEITA");
                String categoria = rs.getString("CATEGORIA_RECEITA");
                String tipo = rs.getString("TP_RECEITA");
                String origem = rs.getString("ORIGEM_RECEITA");
                Date data = rs.getDate("DT_RECEBIMENTO_RECEITA");


                Receita receita = new Receita(id, descricao, valor, categoria, tipo, origem, data);
                lista.add(receita);

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