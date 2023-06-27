
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ContadorLetras {

/*
    public static void main(String[] args) {
    String textoAleatorio = generarTextoAleatorio(1000000000);

    // Eliminar los caracteres no alfabéticos y convertir a minúsculas
    String textoLimpio = textoAleatorio.replaceAll("[^a-zA-Z]", "").toLowerCase();

    // Crear un mapa para almacenar las letras y su cantidad
    Map<Character, Integer> contador = new HashMap<>();

    // Iniciar el cronómetro
    long startTime = System.currentTimeMillis();

    // Contar la cantidad de cada letra en el texto
        for (int i = 0; i < textoLimpio.length(); i++) {
        char letra = textoLimpio.charAt(i);
        contador.put(letra, contador.getOrDefault(letra, 0) + 1);
    }

    // Detener el cronómetro
    long endTime = System.currentTimeMillis();
    long tiempoEjecucion = endTime - startTime;

    // Mostrar los resultados
        System.out.println("Texto aleatorio: " + textoAleatorio);
        System.out.println("Cantidad de letras en el texto: " + textoLimpio.length());
        System.out.println("Letras y su cantidad de repeticiones:");
        for (Map.Entry<Character, Integer> entry : contador.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
        System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos");
}

    public static String generarTextoAleatorio(int longitud) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            char letra = (char) (random.nextInt(26) + 'a');
            sb.append(letra);
        }

        return sb.toString();
    }

 */



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa un texto:");
        String texto = scanner.nextLine();

        // Eliminar los caracteres no alfabéticos y convertir a minúsculas
        String textoLimpio = texto.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Crear un mapa para almacenar las letras y su cantidad
        Map<Character, Integer> contador = new HashMap<>();

        // Iniciar el cronómetro
        long startTime = System.currentTimeMillis();

        // Contar la cantidad de cada letra en el texto
        for (int i = 0; i < textoLimpio.length(); i++) {
            char letra = textoLimpio.charAt(i);
            contador.put(letra, contador.getOrDefault(letra, 0) + 1);
        }

        // Detener el cronómetro y calcular el tiempo de ejecución
        long endTime = System.currentTimeMillis();
        long tiempoEjecucion = endTime - startTime;

        // Mostrar los resultados
        System.out.println("Texto ingresado: " + texto);
        System.out.println("Cantidad de letras en el texto: " + textoLimpio.length());
        System.out.println("Letras y su cantidad de repeticiones:");
        for (Map.Entry<Character, Integer> entry : contador.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos");

        scanner.close();
    }

}


