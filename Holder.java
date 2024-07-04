package Entidade;

// Classe para representar um titular de conta
public class Holder {
    private String nome;
    private int numeroCliente;

    public Holder(String nome, int numeroCliente) {
        this.nome = nome;
        this.numeroCliente = numeroCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
}

