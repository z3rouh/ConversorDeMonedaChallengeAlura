package com.alura.conversordemoneda;

import com.alura.conversordemoneda.Modelos.CodeAndRates;
import com.alura.conversordemoneda.Servicios.ConexionApi;
import com.alura.conversordemoneda.Servicios.FuncionesConversor;
import com.alura.conversordemoneda.Menu.Menuapp;

import java.util.Scanner;

public class ConversorApp {

    private static final String[] MONEDAS_FILTRADAS = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConexionApi api = new ConexionApi();
        FuncionesConversor conversor = new FuncionesConversor();

        CodeAndRates tasa = null;

        // cargar tasas
        try {
            tasa = api.fetchRates();
            System.out.println("Tasas cargadas correctamente.\n");
        } catch (Exception e) {
            System.out.println("No fue posible cargar las tasas al inicio.");
        }

        boolean salir = false;

        while (!salir) {

            Menuapp.mostrarMenu();
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    if (tasa != null) conversor.mostrarTasasFiltradas(tasa, MONEDAS_FILTRADAS);
                    else System.out.println("Sin tasas cargadas.");
                    break;

                case "2":
                    if (tasa != null)
                        tasa.getConversion_rates().forEach((k, v) -> System.out.println(k + " -> " + v));
                    else
                        System.out.println("Sin tasas cargadas.");
                    break;

                case "3":
                    if (tasa != null) {
                        System.out.print("Eliga el tipo de moneda origen, Ejemplo USD. Ingrese su opcion de moneda: ");
                        String origen = scanner.nextLine().toUpperCase();

                        System.out.print("Eliga el tipo de moneda destino, Ejemplo ARS. Ingrese su opcion de moneda: ");
                        String destino = scanner.nextLine().toUpperCase();

                        System.out.print("Ingrese el Monto que quiere convertir: $");
                        double monto = Double.parseDouble(scanner.nextLine());

                        double resultado = conversor.convertir(origen, destino, monto, tasa);
                        System.out.println("\nSu resultado es: " + resultado + " Este es valor de convertir: " + monto +
                                " de origen " + origen + " y convertirlo a destino " + destino);
                    }
                    break;

                case "4":
                    try {
                        tasa = api.fetchRates();
                        System.out.println("Tasas actualizadas correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al actualizar.");
                    }
                    break;

                case "0":
                    salir = true;
                    System.out.println("¡Adiós muchas gracias por utilizar el servicio!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println();
        }
    }
}
