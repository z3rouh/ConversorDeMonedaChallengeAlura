# 💱 Conversor de Moneda | Challenge Alura ONE  
![Status](https://img.shields.io/badge/Estado-Completado-brightgreen)
![Java](https://img.shields.io/badge/Java-17-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Build](https://img.shields.io/badge/Build-IntelliJ%20Project-lightgrey)
![API](https://img.shields.io/badge/API-ExchangeRate--API-orange)
![Java](https://img.shields.io/badge/Java-17+-red?logo=java)
![Challenge](https://img.shields.io/badge/Challenge-Alura%20ONE-blue)

---

## 📘 Descripción del Proyecto
Este es un **Conversor de Monedas** desarrollado como parte del **Challenge ONE - Alura Latam**, utilizando Java y la API de ExchangeRate para obtener tasas de conversión en tiempo real.

El programa permite:
- Consultar tasas actuales filtradas.
- Convertir entre múltiples divisas.
- Mostrar todas las tasas provistas por la API.
- Guardar un **historial de conversiones**.
- Registrar cada conversión con **fecha y hora** (`java.time`).

---

## 🚀 Funcionalidades

### ✔️ 1. Conversión entre monedas  
Convierte entre distintas divisas utilizando tasas actualizadas.

### ✔️ 2. Listado completo de tasas  
Muestra todas las divisas retornadas por la API:
- USD -> 1.00  
- CLP -> 938.50  
- ARS -> 980.20  

### ✔️ 3. Historial de conversiones  
Registra:
- Monto original  
- Moneda origen  
- Moneda destino  
- Resultado  
- Fecha y hora  

### ✔️ 4. Soporte ampliado de monedas  
Incluye las monedas recomendadas del challenge:
- ARS  
- BOB  
- BRL  
- CLP  
- COP  
- USD  

---

## ⚙️ Tecnologías Utilizadas
- **Java 17**
- **Gson (JSON)**
- **HttpClient**
- **ExchangeRate API**
- **java.time API**

---

## 📦 Instalación y Ejecución

### 🔧 Requisitos
- Java 17+
- IntelliJ IDEA o Eclipse
- Conexión a internet

### ▶️ Ejecutar
1. Clonar el repositorio:

   ```bash
   git clone https://github.com/usuario/repositorio.git

2. Abrir el proyecto en tu IDE 
3. Ejecutar la clase ConversorApp.java.

## 📂 Estructura del Proyecto
    src/
        └── com/alura/conversordemoneda/
            ├── Menu
            │     └── Menuapp.java
            ├── Modelos
            │     ├── CodeAndRates.java
            │     └── RegistroConversion.java
            ├── Servicios
            │     ├── ConexionApi.java
            │     └── FuncionesConversor.java
            └── ConversorApp.java

### 📷  Vista Previa del Proyecto

<img width="831" height="278" alt="image" src="https://github.com/user-attachments/assets/210c4e11-d3a8-4fa6-b547-25669eb6ec17" />


## 👤 Autor  
[![GitHub](https://img.icons8.com/ios-glyphs/30/ffffff/github.png)](https://github.com/z3rouh) Felipe Rojas




