package br.com.fiap.fintech.factory;


import br.com.fiap.fintech.dao.DespesaDao;
import br.com.fiap.fintech.dao.InvestimentoDao;
import br.com.fiap.fintech.dao.ReceitaDao;
import br.com.fiap.fintech.dao.UsuarioDao;

public class DaoFactory {

    public static DespesaDao getDespesaDAO() {
        return new DespesaDao();
    }

    public static UsuarioDao getUsuarioDAO() {
        return new UsuarioDao();
        }

    public static ReceitaDao getReceitaDAO() {
        return new ReceitaDao();
    }

    public static InvestimentoDao getInvestimentoDAO() {
        return new InvestimentoDao();
    }
}

