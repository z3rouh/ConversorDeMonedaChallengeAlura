package com.alura.conversordemoneda.Servicios;

import com.alura.conversordemoneda.Modelos.CodeAndRates;

import java.text.DecimalFormat;
import java.util.Map;

public class FuncionesConversor {

    public double convertir(String origen, String destino, double monto, CodeAndRates er) {
        Double tasaOrigen = er.getConversion_rates().get(origen);
        Double tasaDestino = er.getConversion_rates().get(destino);

        if (tasaOrigen == null || tasaDestino == null) {
            throw new IllegalArgumentException("Moneda no válida.");
        }

        return (monto / tasaOrigen) * tasaDestino;
    }

    public void mostrarTasasFiltradas(CodeAndRates er, String[] filtros) {
        for (String code : filtros) {
            Double valor = er.getConversion_rates().get(code);
            System.out.println(code + ": " + (valor != null ? valor : "No disponible"));
        }
    }
}
