package main;

import java.util.Random;

public class Cliente extends Thread {
    private Conta conta;
    private Loja[] lojas;
    private Banco banco;
    private Random random = new Random();

    public Cliente(Conta conta, Loja[] lojas, Banco banco) {
        this.conta = conta;
        this.lojas = lojas;
        this.banco = banco;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public void run() {
        for (Loja loja : lojas) {
            for (int i = 0; i < 2; i++) { // Duas compras por loja
                double valorCompra = 200 + random.nextInt(301); // Entre R$ 200 e R$ 500
                loja.processarPagamentoClientes(banco, this, valorCompra);
            }
        }
    }
}

