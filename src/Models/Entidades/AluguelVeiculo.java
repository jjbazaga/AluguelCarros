package Models.Entidades;

import java.time.LocalDateTime;

public class AluguelVeiculo {
    private LocalDateTime inicio;
    private LocalDateTime devolucao;
    private Veiculo modelo;
    private Fatura fatura;

    public AluguelVeiculo() {
    }

    public AluguelVeiculo(LocalDateTime inicio, LocalDateTime devolucao, Veiculo modelo) {
        this.inicio = inicio;
        this.devolucao = devolucao;
        this.modelo = modelo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDateTime devolucao) {
        this.devolucao = devolucao;
    }

    public Veiculo getModelo() {
        return modelo;
    }

    public void setModelo(Veiculo modelo) {
        this.modelo = modelo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
