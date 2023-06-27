
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

    public class forkContador  extends RecursiveAction {
        private static final int THRESHOLD = 1000;
        private String textoLimpio;
        private int start;
        private int end;
        private Map<Character, Integer> contador;

        public forkContador(String textoLimpio, int start, int end, Map<Character, Integer> contador) {
            this.textoLimpio = textoLimpio;
            this.start = start;
            this.end = end;
            this.contador = contador;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                countLetters();
            } else {
                int mid = (start + end) / 2;
                forkContador left = new forkContador(textoLimpio, start, mid, contador);
                forkContador right = new forkContador(textoLimpio, mid + 1, end, contador);
                invokeAll(left, right);
            }
        }

        private void countLetters() {
            for (int i = start; i <= end; i++) {
                char letra = textoLimpio.charAt(i);
                synchronized (contador) {
                    contador.put(letra, contador.getOrDefault(letra, 0) + 1);
                }
            }
        }
    }


