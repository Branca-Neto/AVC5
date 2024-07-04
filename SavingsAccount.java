package Entidade;
import Interface.IContaDeposito;

import java.util.Date;

// Classe para representar uma conta poupança
class SavingsAccount extends BankAccount implements DepositAccount{
    private int numeroConta;
    private double saldo;
    private double taxaJuro;
    private Date dataInicio;

    public SavingsAccount(int numeroConta, double taxaJuro, Date dataInicio) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.taxaJuro = taxaJuro;
        this.dataInicio = dataInicio;
    }

    @Override
    public void depositar(double valor) throws InvalidDeposit {
        throw new InvalidDeposit("Não é possível depositar numa conta poupança");
    }

    @Override
    public void levantar(double valor) throws InvalidWithdrawal {
        throw new InvalidWithdrawal("Não é possível levantar de uma conta poupança");
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public int getNumeroConta() {
        return numeroConta;
    }

    @Override
    public void atualizarSaldo() {
        // Calcular juros e adicionar ao saldo
        // Aqui você implementaria a lógica para calcular os juros e adicionar ao saldo
    }

    public void fecharEDepositarJuros(DemandAccount demandAccount) throws InvalidDeposit {
        // Adicionar saldo e juros à conta bancária associada
        demandAccount.depositar(saldo);
        atualizarSaldo();
    }
}
