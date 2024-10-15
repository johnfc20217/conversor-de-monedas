import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static final Scanner miTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        int opcionBucle;

        do {
            mostrarMenu();
            opcionBucle = obtenerOpcion();
            if (opcionBucle != 7) {
                procesarOpcion(opcionBucle);
            }
        } while (opcionBucle != 7);

        System.out.println("conversor de Monedas que vuelvas.");
    }

    private static void mostrarMenu() {
        System.out.println("""
                Bienvenido al Conversor de Monedas digita la opcion..!
                
                1.) Dólar a Peso Colombiano.
                2.) Peso Colombiano a Dólar.
                3.) Dólar a Real Brasileño.
                4.) Real Brasileño a Dólar.
                5.) Dólar a Peso Argentino.
                6.) Peso Argentino a Dólar.
                7.) Salir.
                
                Elige una opción:
                *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
                """);
    }
    //validaciones
    private static int obtenerOpcion() {
        try { return miTeclado.nextInt();}
        catch (InputMismatchException e) {
            miTeclado.nextLine();
            System.out.println("Opción incorrecta. Intenta nuevamente..!");
            return 0;
        }
    }

    private static void procesarOpcion(int opcion) {
        try {
            System.out.println("Ingrese el valor que desea convertir..!");
            double cantidad = miTeclado.nextDouble();
            ApiRequest consulta = new ApiRequest(opcion, cantidad);
            consulta.llamadaRequest();
            System.out.printf("El valor de %s de %.2f es de %.2f%n", consulta.getValores(), cantidad, consulta.getResultado());
            }
        catch (InputMismatchException e) {
            System.out.println("Entrada incorrecta. Por favor, Digita un número válido.");
            miTeclado.nextLine();
        }
    }
}
