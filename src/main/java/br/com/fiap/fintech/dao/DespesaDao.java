package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Despesa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDao {

    private Connection conexao;

    public void cadastrar(Despesa despesa) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Despesa (id_despesa, desc_despesa, vl_despesa, categoria_despesa, tp_despesa, origem_despesa, dt_pagamento_despesa) VALUES (despesa_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, despesa.getDescricao());
            stmt.setDouble(2, despesa.getValor());
            stmt.setString(3, despesa.getCategoria());
            stmt.setString(4, despesa.getTipo());
            stmt.setString(5, despesa.getOrigem());
            stmt.setDate(6, despesa.getData());
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


    public void atualizar(Despesa despesa) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE DESPESA SET " + "DESC_DESPESA = ?, " + "VL_DESPESA = ?, " + "CATEGORIA_DESPESA = ?, " + "TP_DESPESA = ?, " + "ORIGEM_DESPESA = ?, " + "DT_PAGAMENTO_DESPESA = ? " + "WHERE ID_DESPESA = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, despesa.getDescricao());
            stmt.setDouble(2, despesa.getValor());
            stmt.setString(3, despesa.getCategoria());
            stmt.setString(4, despesa.getTipo());
            stmt.setString(5, despesa.getOrigem());
            stmt.setDate(6, despesa.getData());
            stmt.setInt(7, despesa.getId());
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
            String sql = "DELETE FROM DESPESA WHERE ID_DESPESA = ?";
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

    public Despesa buscar(int id) {

        Despesa despesa = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM DESPESA WHERE ID_DESPESA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idDespesa = rs.getInt(("id_despesa"));
                String descricao = rs.getString("DESC_DESPESA");
                double valor = rs.getDouble("VL_DESPESA");
                String categoria = rs.getString("CATEGORIA_DESPESA");
                String tipo = rs.getString("TP_DESPESA");
                String origem = rs.getString("ORIGEM_DESPESA");
                Date data = rs.getDate("DT_PAGAMENTO_DESPESA");

                despesa = new Despesa( idDespesa, descricao, valor, categoria, tipo, origem, data);
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
        return despesa;
    }

    public List<Despesa> listar() {

        List<Despesa> lista = new ArrayList<Despesa>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM DESPESA";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_DESPESA");
                String descricao = rs.getString("DESC_DESPESA");
                double valor = rs.getDouble("VL_DESPESA");
                String categoria = rs.getString("CATEGORIA_DESPESA");
                String tipo = rs.getString("TP_DESPESA");
                String origem = rs.getString("ORIGEM_DESPESA");
                Date data = rs.getDate("DT_PAGAMENTO_DESPESA");


                Despesa despesa = new Despesa(id, descricao, valor, categoria, tipo, origem, data);
                lista.add(despesa);

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