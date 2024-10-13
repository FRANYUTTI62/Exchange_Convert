import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String code = "";
        String target = "";
        String result = "error";
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        String API_KEY = "9c9759f227851fcbce41fe60";

        String tryOne;
        HttpRequest request;
        HttpResponse response;
        String json;
        JsonElement jsonElement;
        JsonObject jsonObject;
        while(!result.equals("success")) {
            System.out.println("Please enter your base currency code (ISO 4217) Ej. USD: ");
            code = scanner.nextLine().toUpperCase(Locale.ROOT);
            tryOne = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + code;
            request = HttpRequest.newBuilder().uri(URI.create(tryOne)).build();
            response = client.send(request, BodyHandlers.ofString());
            json = (String)response.body();
            jsonElement = JsonParser.parseString(json);
            jsonObject = jsonElement.getAsJsonObject();
            result = jsonObject.get("result").getAsString();
            if (result.equals("error")) {
                System.out.println("Error, enter a valid code");
            }
        }

        result = "error";

        while(!result.equals("success")) {
            System.out.println("Please enter the target currency code (ISO 4217) Ej. USD: ");
            target = scanner.nextLine().toUpperCase(Locale.ROOT);
            tryOne = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + target;
            request = HttpRequest.newBuilder().uri(URI.create(tryOne)).build();
            response = client.send(request, BodyHandlers.ofString());
            json = (String)response.body();
            jsonElement = JsonParser.parseString(json);
            jsonObject = jsonElement.getAsJsonObject();
            result = jsonObject.get("result").getAsString();
            if (result.equals("error")) {
                System.out.println("Error, enter a valid target currency code");
            }
        }

        int quantity = 0;

        while(true) {
            System.out.printf("Please enter your quantity in %s ", code);
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                String direction = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + code + "/" + target + "/" + quantity;
                HttpRequest request3 = HttpRequest.newBuilder().uri(URI.create(direction)).build();
                HttpResponse var17 = client.send(request3, BodyHandlers.ofString());
                json = (String)var17.body();
                Conversion conversion = (Conversion)gson.fromJson(json, Conversion.class);
                System.out.print(conversion);
                return;
            }

            System.out.println("Enter a valid quantity");
            scanner.nextLine();
        }
    }
}

