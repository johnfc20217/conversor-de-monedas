# Conversor de Monedas

Este proyecto es un Conversor de Monedas desarrollado en Java, convierte entre varias monedas como 
(dólar estadounidense, peso colombiano, real brasileño y peso argentino) 
utilizamos una API de tipo Exchange Rate El objetivo de este proyecto es realizar conversiones de monedas de manera rápida y precisa.

# Descripcion

El proyecto permite a los usuarios seleccionar diferentes opciones para la conversión y posteriormente ingresar la cantidad que desean convertir, 
seleccionamos la opción e ingresamos el valor, el programa realiza una solicitud a una API para obtener la tasa de cambio actual y 
devuelve el valor convertido.

escogimos tres tipos de Monedas :
- Dólar (USD)  Peso Argentino (ARS)
- Dólar (USD)  Real Brasileño (BRL)
- Dólar (USD)  Peso Colombiano (COP)

# Tecnologías Utilizadas

- Lenguaje: Java 17
- Dependencias: 
- Gson para la manipulación de JSON.
- HttpClient de Java para realizar solicitudes HTTP.
- API utilizada: [ExchangeRate-API](https://www.exchangerate-api.com/)

# requisitos:

1. Java: tener instalada una versión reciente de Java (Java 17).
2. IDE: Puedes ejecutar este proyecto en cualquier IDE que soporte Java (IntelliJ IDEA, Eclipse)

# Instalación:
- Asegúrate de tener la dependencia de Gson configurada. Puedes agregarla usando Maven o descargándola manualmente.


# Ejecución:

1. Ejecuta la clase main o Principal.java
2. Elige la opción de conversión en el menú interactivo.
3. Ingresa el valor que deseas convertir.
4. Obtendrás el resultado en pantalla con la conversión actualizada.


# Funcionamiento

- Convertir diferentes monedas utilizando tasas de cambio en tiempo real.
- Manejo de errores de entrada excepciones (evita fallos por datos incorrectos).

# proximas versiones Mejoras
- Soporte para más monedas.

