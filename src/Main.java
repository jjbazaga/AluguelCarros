import Models.Entidades.AluguelVeiculo;
import Models.Entidades.Veiculo;
import Models.Servicos.ServicoAluguel;
import Models.Servicos.ServicoTaxaArgentina;
import Models.Servicos.ServicoTaxaBrasil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do veiculo: ");
        String modelo = sc.nextLine();
        System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(), dtf);
        System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
        LocalDateTime retorno = LocalDateTime.parse(sc.nextLine(), dtf);

        System.out.print("Entre o preço por hora: ");
        double precoHora = sc.nextDouble();
        System.out.print("Entre o preço por dia: ");
        double precoDia = sc.nextDouble();

        AluguelVeiculo aluguelCarro = new AluguelVeiculo(retirada, retorno, new Veiculo(modelo));

        System.out.println();
        // new TaxaServicoBrasil, injetado por upcast (dependecia)
        ServicoAluguel servicoAluguel = new ServicoAluguel(precoHora, precoDia, new ServicoTaxaBrasil());

        servicoAluguel.ProcessoFatura(aluguelCarro);

        System.out.println("FATURA:");
        System.out.println("Pagamento basico: " + String.format("%.2f", aluguelCarro.getFatura().getPagamentoBasico()));
        System.out.println("Imposto: " + String.format("%.2f", aluguelCarro.getFatura().getTaxa()));
        System.out.println("Pagamento total: " + String.format("%.2f", aluguelCarro.getFatura().getTotalPagamento()));

        sc.close();
    }
}