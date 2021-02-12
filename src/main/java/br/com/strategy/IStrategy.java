package br.com.strategy;

import br.com.entity.MeioPagamento;

public interface IStrategy {

    MeioPagamento preparar(MeioPagamento meioPagamento);
}
