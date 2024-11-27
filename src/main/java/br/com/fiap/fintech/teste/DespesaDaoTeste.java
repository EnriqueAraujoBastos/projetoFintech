package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.dao.DespesaDao;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Despesa;

import java.util.List;

public class DespesaDaoTeste {
    public static void main(String[] args) {

        DespesaDao dao = DaoFactory.getDespesaDAO();

        DespesaDao despesaDao = new DespesaDao();



        Despesa despesa = new Despesa( 0,"mercado", 1050.40, "Alimentação", "Fixa", "Fulano de Tal", java.sql.Date.valueOf("2024-10-10"));
        try {
            dao.cadastrar(despesa);
            System.out.println("Despesa cadastrada.");
        } catch (DBException e) {
            e.printStackTrace();
        }

        despesa = dao.buscar(1);
        despesa.setValor(4444.00);
        despesa.setCategoria("Lazer");
        try {
            dao.atualizar(despesa);
            System.out.println("Despesa Atualizada.");
        } catch (DBException e) {
            e.printStackTrace();
        }

        List<Despesa> lista = dao.listar();
        for (Despesa item : lista) {
            System.out.println(
                    item.getDescricao() + " " +
                    item.getValor() + " " +
                    item.getTipo());
        }

        try {
            dao.remover(1);
            System.out.println("Despesa Removida.");
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}