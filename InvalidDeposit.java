package Entidade;

// Exceção para depósito inválido
public class InvalidDeposit extends Exception {
    public InvalidDeposit(String message) {
        super(message);
    }
}
