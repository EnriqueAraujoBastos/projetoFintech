package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.dao.ReceitaDao;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DaoFactory;
import br.com.fiap.fintech.model.Receita;

import java.util.List;

public class ReceitaDaoTeste {
    public static void main(String[] args) {

        ReceitaDao dao = DaoFactory.getReceitaDAO();

        ReceitaDao receitaDao = new ReceitaDao();



        Receita receita = new Receita( 0,"Salário", 1000, "Salário", "Fixa", "EMPRESA XYZ", java.sql.Date.valueOf("2024-10-10"));
        try {
            dao.cadastrar(receita);
            System.out.println("Receita cadastrada.");
        } catch (DBException e) {
            e.printStackTrace();
        }

        receita = dao.buscar(1);
        receita.setValor(4444.00);
        receita.setCategoria("Lazer");
        try {
            dao.atualizar(receita);
            System.out.println("Receita Atualizada.");
        } catch (DBException e) {
            e.printStackTrace();
        }

        List<Receita> lista = dao.listar();
        for (Receita item : lista) {
            System.out.println(
                    item.getDescricao() + " " +
                            item.getValor() + " " +
                            item.getTipo());
        }

        try {
            dao.remover(1);
            System.out.println("Receita Removida.");
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}