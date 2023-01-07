package Models.Servicos;

import Models.Entidades.AluguelVeiculo;
import Models.Entidades.Fatura;

import java.time.Duration;
public class ServicoAluguel {
    private Double precoHora;
    private Double precoDia;
    private ServicoTaxaOnline servicoTaxaOnline;

    public ServicoAluguel() {
    }

    public ServicoAluguel(Double precoHora, Double precoDia, ServicoTaxaOnline taxaServico) {  //recebe a injeção de depencias vindo pelo main (upcast)
        this.precoHora = precoHora;
        this.precoDia = precoDia;
        this.servicoTaxaOnline = taxaServico;
    }

    public void ProcessoFatura(AluguelVeiculo aluguelVeiculo) {
        double minutes = Duration.between(aluguelVeiculo.getInicio(), aluguelVeiculo.getDevolucao()).toMinutes();
        double hours = minutes / 60.0;

        double pagamentoBasico;
        if (hours <= 12.0) {
            pagamentoBasico = precoHora * Math.ceil(hours);
        } else {
            pagamentoBasico = precoDia * Math.ceil(hours / 24);
        }
        double imposto = servicoTaxaOnline.Taxa(pagamentoBasico);
        aluguelVeiculo.setFatura(new Fatura(pagamentoBasico, imposto));
    }
}

