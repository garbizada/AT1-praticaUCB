package main;

public class Loja {
    private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(Conta conta, Funcionario[] funcionarios) {
        this.conta = conta;
        this.funcionarios = funcionarios;
    }

    public void processarPagamentoClientes(Banco banco, Cliente cliente, double valorCompra) {
        banco.transferir(cliente.getConta(), this.conta, valorCompra);
        System.out.println("Loja recebeu pagamento de R$" + valorCompra + " do cliente.");
        pagarFuncionarios(banco);
    }

    public void pagarFuncionarios(Banco banco) {
        for (Funcionario funcionario : funcionarios) {
            if (conta.getSaldo() >= 1400) {
                banco.transferir(conta, funcionario.getContaSalario(), 1400);
                funcionario.investir();
            }
        }
    }
}
