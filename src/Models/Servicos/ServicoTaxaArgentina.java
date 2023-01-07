package Models.Servicos;

public class ServicoTaxaArgentina implements ServicoTaxaOnline{
    @Override
    public Double Taxa(double montante) {
        if (montante <= 100.0) {
            return 0.30 * montante;
        } else {
            return 0.25 * montante;
        }
    }
}
