package Entidade;

import Interface.IContaDeposito;

// Classe para representar uma conta à ordem
class DemandAccount extends BankAccount implements DepositAccount {
    private int numeroConta;
    private double saldo;

    public DemandAccount(int numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    @Override
    public void depositar(double valor) throws InvalidDeposit {
        if (valor < 0) {
            throw new InvalidDeposit("Não é possível depositar um valor negativo");
        }
        saldo += valor;
    }

    @Override
    public void levantar(double valor) throws InvalidWithdrawal {
        if (valor < 0 || valor > saldo) {
            throw new InvalidWithdrawal("Valor de levantamento inválido");
        }
        saldo -= valor;
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
        // Não há atualização de saldo para conta à ordem
    }
}

