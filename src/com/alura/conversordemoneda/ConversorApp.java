package com.alura.conversordemoneda;

import com.google.gson.Gson;
import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ConversorApp {

    public static void main(String[] args) throws IOException, InterruptedException {

        String direccionapi = "https://v6.exchangerate-api.com/v6/03ab53d9d347483a80fae46e/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccionapi))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        CodeAndRates exchangeRate = gson.fromJson(json, CodeAndRates.class);
        System.out.println("=== Tasas Filtradas ===");

        String[] monedasFiltrar = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

        for (String codigo : monedasFiltrar) {
            Double valor = exchangeRate.getConversion_rates().get(codigo);
            if (valor != null) {
                System.out.println(codigo + ": " + valor);
            } else {
                System.out.println(codigo + ": No disponible");
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Conversión de Monedas ===");
        System.out.print("Moneda origen (ej: USD): ");
        String origen = scanner.nextLine().toUpperCase();

        System.out.print("Moneda destino (ej: CLP): ");
        String destino = scanner.nextLine().toUpperCase();

        System.out.print("Monto a convertir: ");
        double monto = scanner.nextDouble();

        double convertido = convertir(origen, destino, monto, exchangeRate);

        System.out.println("\nRESULTADO:");
        System.out.println(monto + " " + origen + " = " + convertido + " " + destino);
    }
    public static double convertir(String origen, String destino, double monto, CodeAndRates er) {
        double tasaOrigen = er.getConversion_rates().get(origen);
        double tasaDestino = er.getConversion_rates().get(destino);

        // Conversión: monto en destino = (monto / tasaOrigen) * tasaDestino
        return (monto / tasaOrigen) * tasaDestino;
    }
}
