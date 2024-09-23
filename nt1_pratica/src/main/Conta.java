package main;

import java.text.DecimalFormat;

public class Conta {
    private double saldo;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$" + df.format(valor) + ". Novo saldo: R$" + df.format(saldo));
    }

    public synchronized boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + df.format(valor) + ". Novo saldo: R$" + df.format(saldo));
            return true;
        } else {
            System.out.println("Saldo insuficiente. Saque de R$" + df.format(valor) + " falhou.");
            return false;
        }
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}

