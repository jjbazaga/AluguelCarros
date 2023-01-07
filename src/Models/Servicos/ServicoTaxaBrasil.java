package Models.Servicos;

public class ServicoTaxaBrasil implements ServicoTaxaOnline {

    @Override
    public Double Taxa(double montante) {
        if (montante <= 100.0) {
            return 0.20 * montante;
        } else {
            return 0.15 * montante;
        }
    }
}