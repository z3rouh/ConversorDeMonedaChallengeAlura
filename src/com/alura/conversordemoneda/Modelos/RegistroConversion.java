package com.alura.conversordemoneda.Modelos;

import java.time.LocalDateTime;

public class RegistroConversion {

    private final String origen;
    private final String destino;
    private final double monto;
    private final double resultado;
    private final LocalDateTime fechaHora;

    public RegistroConversion(String origen, String destino, double monto, double resultado, LocalDateTime fechaHora) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
        this.resultado = resultado;
        this.fechaHora = fechaHora;
    }

    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public double getMonto() { return monto; }
    public double getResultado() { return resultado; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}
