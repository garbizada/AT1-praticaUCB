package main;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Conta contaLoja1 = new Conta(0);
        Conta contaLoja2 = new Conta(0);
        Loja loja1 = new Loja(contaLoja1, criarFuncionarios(banco));
        Loja loja2 = new Loja(contaLoja2, criarFuncionarios(banco));
        Loja[] lojas = {loja1, loja2};


        Cliente[] clientes = new Cliente[10];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(new Conta(2000), lojas, banco);
            clientes[i].start();
        }

        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       
        System.out.println("Saldo final da loja 1: " + contaLoja1.getSaldo());
        System.out.println("Saldo final da loja 2: " + contaLoja2.getSaldo());
    }

    private static Funcionario[] criarFuncionarios(Banco banco) {
        Funcionario[] funcionarios = new Funcionario[2];
        for (int i = 0; i < funcionarios.length; i++) {
            funcionarios[i] = new Funcionario(new Conta(0), new Conta(0));
            funcionarios[i].start();
        }
        return funcionarios;
    }
}

