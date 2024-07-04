package Entidade;

// Classe para representar uma conta bancária
public class BankAccount implements Comparable<BankAccount> {
    private int numeroConta;
    private Holder[] titulares;
    private DemandAccount demandAccount;
    private SavingsAccount[] contasPoupanca;
    private int contadorContasPoupanca;

    public BankAccount(int numeroConta) {
        this.numeroConta = numeroConta;
        this.titulares = new Holder[10]; // Inicializa com capacidade para 10 titulares
        this.demandAccount = new DemandAccount(numeroConta);
        this.contasPoupanca = new SavingsAccount[10]; // Inicializa com capacidade para 10 contas poupança
        this.contadorContasPoupanca = 0;
    }

    public void adicionarTitular(Holder holder) {
        for (int i = 0; i < titulares.length; i++) {
            if (titulares[i] == null) {
                titulares[i] = holder;
                break;
            }
        }
    }

    public void depositar(double valor) throws InvalidDeposit {
        demandAccount.depositar(valor);
    }

    public void levantar(double valor) throws InvalidWithdrawal {
        demandAccount.levantar(valor);
    }

    public double consultarSaldoContaOrdem() {
        return demandAccount.consultarSaldo();
    }

    public double consultarSaldoTotal() {
        double saldoTotal = demandAccount.consultarSaldo();
        for (SavingsAccount savingsAccount : contasPoupanca) {
            if (savingsAccount != null) {
                saldoTotal += savingsAccount.consultarSaldo();
            }
        }
        return saldoTotal;
    }

    public Holder[] getTitulares() {
        return titulares;
    }

    public SavingsAccount[] getContasPoupanca() {
        return contasPoupanca;
    }

    public void adicionarContaPoupanca(SavingsAccount savingsAccount) {
        if (contadorContasPoupanca < contasPoupanca.length) {
            contasPoupanca[contadorContasPoupanca] = savingsAccount;
            contadorContasPoupanca++;
        } else {
            System.out.println("Não é possível adicionar mais contas poupança.");
        }
    }

    public boolean podeSerRemovida() {
        return consultarSaldoTotal() == 0;
    }

    // Método para obter os dados de um cliente específico
    public Holder pesquisarCliente(int numeroCliente) {
        for (Holder holder : titulares) {
            if (holder != null && holder.getNumeroCliente() == numeroCliente) {
                return holder;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    @Override
    public int compareTo(BankAccount outraConta) {
        return Integer.compare(this.numeroConta, outraConta.numeroConta);
    }

    public void mostrarDadosCliente(Holder cliente){
        if (cliente != null) {
            System.out.println("Dados do cliente:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Número do cliente: " + cliente.getNumeroCliente());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
