import Entidade.BankAccount;
import Entidade.InvalidDeposit;
import Entidade.InvalidWithdrawal;
import Entidade.Holder;


public class Banck {
    public static void main(String[] args) {
        // Exemplo de uso
        BankAccount conta = new BankAccount(12345);
        Holder holder1 = new Holder("Nelio dos Santos", 1);
        Holder holder2 = new Holder("Ana dos Santos", 2);
        conta.adicionarTitular(holder1);
        conta.adicionarTitular(holder2);

        try {
            conta.depositar(1000);
            conta.levantar(500);
        } catch (InvalidDeposit | InvalidWithdrawal e) {
            e.printStackTrace();
        }

        // Exemplo de obtenção dos dados de um cliente específico
        int numeroCliente = 2; // Número do cliente que deseja obter os dados
        Holder cliente = conta.pesquisarCliente(numeroCliente);
        conta.mostrarDadosCliente(cliente);

    }
}
