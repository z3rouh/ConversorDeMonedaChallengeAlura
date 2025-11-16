package com.alura.conversordemoneda;

import java.util.Map;

// Esta clase representa el JSON que devuelve la API
public class CodeAndRates {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}
