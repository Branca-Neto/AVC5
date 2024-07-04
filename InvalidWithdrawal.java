package Entidade;

// Exceção para levantamento inválido
public class InvalidWithdrawal extends Exception {
    public InvalidWithdrawal(String message) {
        super(message);
    }
}
