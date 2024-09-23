package main;

public class Banco {
    public synchronized void transferir(Conta de, Conta para, double valor) {
        if (de.sacar(valor)) {
            para.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada.");
        } else {
            System.out.println("Falha na transferência de R$" + valor);
        }
    }
}
