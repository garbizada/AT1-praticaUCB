package main;

public class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta contaInvestimentos;

    public Funcionario(Conta contaSalario, Conta contaInvestimentos) {
        this.contaSalario = contaSalario;
        this.contaInvestimentos = contaInvestimentos;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public void investir() {
        double valorInvestido = contaSalario.getSaldo() * 0.2;
        contaSalario.sacar(valorInvestido);
        contaInvestimentos.depositar(valorInvestido);
        System.out.println("Funcionário investiu R$" + valorInvestido);
    }
}

