
/**
 *
 * @author João
 */
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorMoeda {

    private static final String API_KEY = "c1f9a8792f1dac7367a3af78"; // Substitua pela sua chave real
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Selecione a conversão desejada:");
            System.out.println("1- Dólar =>> Peso argentino");
            System.out.println("2- Peso argentino =>> Dólar");
            System.out.println("3- Dólar =>> Real brasileiro");
            System.out.println("4- Real brasileiro =>> Dólar");
            System.out.println("5- Dólar =>> Peso colombiano");
            System.out.println("6- Peso colombiano =>> Dólar");
            System.out.println("7- Sair");
            System.out.print("Digite sua opção: ");

            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.print("Digite o valor a ser convertido: ");
                double valor = scanner.nextDouble();
                double resultado = 0.0;
                String moedaBase = "";
                String moedaDestino = "";

                switch (opcao) {
                    case 1:
                        moedaBase = "USD";
                        moedaDestino = "ARS";
                        break;
                    case 2:
                        moedaBase = "ARS";
                        moedaDestino = "USD";
                        break;
                    case 3:
                        moedaBase = "USD";
                        moedaDestino = "BRL";
                        break;
                    case 4:
                        moedaBase = "BRL";
                        moedaDestino = "USD";
                        break;
                    case 5:
                        moedaBase = "USD";
                        moedaDestino = "COP";
                        break;
                    case 6:
                        moedaBase = "COP";
                        moedaDestino = "USD";
                        break;
                }

                resultado = converterMoeda(valor, moedaBase, moedaDestino);
                System.out.printf("%.2f %s equivalem a %.2f %s\n", valor, moedaBase, resultado, moedaDestino);
            } else if (opcao != 7) {
                System.out.println("Opção inválida. Por favor, tente novamente.");
            }

        } while (opcao != 7);

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    public static double converterMoeda(double valor, String moedaBase, String moedaDestino) {
        try {
            URL url = new URL(API_URL + moedaBase);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("apikey", API_KEY); // Informando a chave da API no cabeçalho (pode variar)

            InputStream responseStream = connection.getInputStream();
            String jsonResponse = new String(responseStream.readAllBytes());

            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("rates");

            if (rates.has(moedaDestino)) {
                double taxa = rates.get(moedaDestino).getAsDouble();
                return valor * taxa;
            } else {
                System.out.println("Moeda de destino não encontrada.");
                return 0.0;
            }

        } catch (IOException e) {
            System.err.println("Erro ao acessar a API: " + e.getMessage());
            return 0.0;
        }
    }
}
