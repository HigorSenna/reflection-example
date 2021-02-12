package br.com.servico;

import br.com.dao.MeioDePagamentoDAO;
import br.com.entity.MeioPagamento;
import br.com.strategy.BoletoStrategy;
import br.com.strategy.CartaoCreditoStrategy;
import br.com.strategy.CartaoDebitoStrategy;
import br.com.strategy.IStrategy;

public class ServicoMeioPagamento {

    public void salvar(MeioPagamento meioPagamento) throws Exception {
        IStrategy iStrategy = this.definirStrategia(meioPagamento);

        iStrategy.preparar();

        new MeioDePagamentoDAO().salvar(meioPagamento);
    }

    public IStrategy definirStrategia(MeioPagamento meioPagamento) throws Exception {

        if(meioPagamento.ehBoleto()) {
            return new BoletoStrategy();
        } else if(meioPagamento.ehCartaoCredito()) {
            return new CartaoCreditoStrategy();
        } else if(meioPagamento.ehCartaoDebito()) {
            return new CartaoDebitoStrategy();
        }

        throw new Exception("Meio de pagamento não suportado");
    }
}
