import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LetterCountExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el texto original: ");
        String textoOriginal = scanner.nextLine();

        String textoLimpio = textoOriginal.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Crear un mapa para almacenar las letras y su cantidad
        Map<Character, Integer> contador = new HashMap<>();

        // Iniciar el cronómetro
        long startTime = System.currentTimeMillis();

        // Crear un ExecutorService con un solo hilo
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Ejecutar la tarea de contar letras en un hilo separado
        executor.execute(() -> {
            // Contar la cantidad de cada letra en el texto
            for (int i = 0; i < textoLimpio.length(); i++) {
                char letra = textoLimpio.charAt(i);
                contador.put(letra, contador.getOrDefault(letra, 0) + 1);
            }
        });

        // Detener el ExecutorService y esperar a que la tarea se complete
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Detener el cronómetro y calcular el tiempo de ejecución
        long endTime = System.currentTimeMillis();
        long tiempoEjecucion = endTime - startTime;

        // Imprimir los resultados
        System.out.println("Conteo de letras: " + contador);
        System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " ms");

        scanner.close();
    }
}