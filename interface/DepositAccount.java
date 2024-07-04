package Interface;
import Entidade.InvalidDeposit;
import Entidade.InvalidWithdrawal;

// Interface comum para contas de depósito
public interface DepositAccount {
    void depositar(double valor) throws InvalidDeposit, InvalidDeposit;

    void levantar(double valor) throws InvalidWithdrawal, InvalidWithdrawal;

    double consultarSaldo();

    int getNumeroConta();

    void atualizarSaldo();
}
