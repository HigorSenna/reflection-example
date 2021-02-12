package br.com.entity;

public abstract class MeioPagamento {

    private String nomeCliente;

    public boolean ehBoleto() {
        return this instanceof Boleto;
    }

    public boolean ehCartaoCredito() {
        return this instanceof CartaoCredito;
    }

    public boolean ehCartaoDebito() {
        return this instanceof CartaoDebito;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
