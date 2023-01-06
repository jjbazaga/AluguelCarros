package Models.Servicos;

public class TaxaServicoBrasil  implements TaxaServico {

    @Override
    public Double Taxa(double montante) {
        if (montante <= 100.0) {
            return 0.20 * montante;
        } else {
            return 0.15 * montante;
        }
    }
}