package com.alura.conversordemoneda.Servicios;

import com.alura.conversordemoneda.Modelos.CodeAndRates;
import com.alura.conversordemoneda.Modelos.RegistroConversion;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FuncionesConversor {

    private final List<RegistroConversion> historial = new ArrayList<>();

    public double convertir(String origen, String destino, double monto, CodeAndRates er) {
        Double tasaOrigen = er.getConversion_rates().get(origen);
        Double tasaDestino = er.getConversion_rates().get(destino);

        if (tasaOrigen == null || tasaDestino == null) {
            throw new IllegalArgumentException("Moneda no válida.");
        }
        double resultado = (monto / tasaOrigen) * tasaDestino;

        historial.add(new RegistroConversion(
                origen,
                destino,
                monto,
                resultado,
                LocalDateTime.now()
        ));

        return resultado;
    }

    public void mostrarHistorial() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        if (historial.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
            return;
        }

        System.out.println("\n⌗⌗⌗⌗ HISTORIAL DE CONVERSIONES ⌗⌗⌗⌗");
        historial.forEach(record -> {
            System.out.println(
                    record.getMonto() + " " + record.getOrigen() + " -> " +
                            record.getResultado() + " " + record.getDestino() +
                            " | Fecha: " + record.getFechaHora().format(formato)
            );
        });
    }

    public List<RegistroConversion> getHistorial() {
        return historial;
    }

    public void mostrarTasasFiltradas(CodeAndRates er, String[] filtros) {
        System.out.println("\nMostrando tasas filtradas importantes de la API:");
        System.out.println("⌗⌗⌗⌗ Tasas Filtradas TOP 6 ⌗⌗⌗⌗");
        for (String code : filtros) {
            Double valor = er.getConversion_rates().get(code);
            System.out.println(code + ": " + (valor != null ? valor : "No disponible"));
        }
    }
}
