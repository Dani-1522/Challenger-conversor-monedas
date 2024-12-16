import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

public class CurrencyConverter {
    // Variables globales para almacenar tasas de cambio
    private static double usdToArs, usdToCop, usdToBrl;

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.exchangerate-api.com/v4/latest/USD"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Respuesta de la API: " + response.body()); // Inspeccionar respuesta

            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

            // Validar si 'rates' está presente
            if (!jsonResponse.has("rates")) {
                System.out.println("La clave 'rates' no está presente en la respuesta.");
                return;
            }

            JsonObject rates = jsonResponse.getAsJsonObject("rates");

            usdToArs = rates.get("ARS").getAsDouble();
            usdToCop = rates.get("COP").getAsDouble();
            usdToBrl = rates.get("BRL").getAsDouble();

            System.out.println("Tasas obtenidas:");
            System.out.println("USD to ARS: " + usdToArs);
            System.out.println("USD to COP: " + usdToCop);
            System.out.println("USD to BRL: " + usdToBrl);

            interactWithUser();

        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener las tasas de cambio: " + e.getMessage());
        }
    }

    public static double convert(double amount, double rate) {
        return amount * rate;
    }

    public static void interactWithUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBienvenido al Conversor de Monedas");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Convertir USD a ARS (Peso argentino)");
            System.out.println("2. Convertir USD a COP (Peso colombiano)");
            System.out.println("3. Convertir USD a BRL (Real brasileño)");
            System.out.println("4. Salir");

            int choice = scanner.nextInt();
            if (choice == 4) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            }

            System.out.print("Introduce el monto en USD: ");
            double amount = scanner.nextDouble();

            double result = 0.0;
            switch (choice) {
                case 1 -> result = convert(amount, usdToArs);
                case 2 -> result = convert(amount, usdToCop);
                case 3 -> result = convert(amount, usdToBrl);
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }

            if (choice >= 1 && choice <= 3) {
                System.out.println("Monto convertido: " + result);
            }
        }
    }
}
