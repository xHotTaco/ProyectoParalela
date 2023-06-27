import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

import javax.swing.*;

public class ventana extends JFrame {

    private JPanel panel;
    private JLabel lbTitulo,  lbSecuencial, lbForkJoin, lbExecuteService;
    private JTextArea taTextoOriginal, taSecuencial, taForkJoin, taExecuteService;
    private JScrollPane scrollPane1, scrollPane2, scrollPane3, scrollPane4;
    private JButton btnGuardarTexto, btnSecuencial, btnForkJoin, btnExecuteService, btnClear;

    private String textoOriginal;

    public ventana() {

        this.setSize(800, 600); // Tamaño del JFrame
        setTitle("Contador de letras"); // Titulo del JFrame
        setLocationRelativeTo(null); // Centrar la ventana al centro de la pantalla

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cerrar proceso de la ventana

        initComponents();

        guardarTextoOriginal();
        btnClear();

        btnSecuencial();
        btnForkJoin();
        btnExecuteService();
    }

    private void initComponents() {

        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        // Configiracion del Label principal
        lbTitulo = new JLabel();
        lbTitulo.setText("Ingresa el texto: ");
        lbTitulo.setBounds(20, -10, 250, 80);
        lbTitulo.setFont(new Font("cooper black", 0, 25));

        panel.add(lbTitulo);


        // Configuracion del TextArea del texto original
        taTextoOriginal = new JTextArea();
        taTextoOriginal.setBounds(250, 20, 500, 150);
        taTextoOriginal.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        scrollPane1 = new JScrollPane(taTextoOriginal, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane1.setBounds(250, 20, 500, 150);

        panel.add(scrollPane1);

        // Configuracion del boton para guardar el Texto original
        btnGuardarTexto = new JButton();
        btnGuardarTexto.setBounds(25, 65, 200, 35);
        btnGuardarTexto.setText("Guardar texto");

        panel.add(btnGuardarTexto);

        // Configuracion de los siguientes TextAreas (Secuencial, ForkJoin,
        // ExecuteService)
        taSecuencial = new JTextArea();
        taForkJoin = new JTextArea();
        taExecuteService = new JTextArea();

        taSecuencial.setBounds(8, 250, 250, 200);
        taSecuencial.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        scrollPane2 = new JScrollPane(taSecuencial, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane2.setBounds(8, 250, 250, 200);

        panel.add(scrollPane2);

        taForkJoin.setBounds(267, 250, 250, 200);
        taForkJoin.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        scrollPane3 = new JScrollPane(taForkJoin, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane3.setBounds(267, 250, 250, 200);

        panel.add(scrollPane3);

        taExecuteService.setBounds(525, 250, 250, 200);
        taExecuteService.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        scrollPane4 = new JScrollPane(taExecuteService, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane4.setBounds(525, 250, 250, 200);

        panel.add(scrollPane4);

        // Configuracion de los siguientes Labels (Secuencial, ForkJoin, ExecuteService)
        lbSecuencial = new JLabel();
        lbForkJoin = new JLabel();
        lbExecuteService = new JLabel();

        lbSecuencial.setText("Secuencial: ");
        lbForkJoin.setText("ForkJoin: ");
        lbExecuteService.setText("ExecuteService: ");

        lbSecuencial.setBounds(8, 220, 250, 30);
        lbForkJoin.setBounds(267, 220, 250, 30);
        lbExecuteService.setBounds(525, 220, 250, 30);

        panel.add(lbSecuencial);
        panel.add(lbForkJoin);
        panel.add(lbExecuteService);

        // Configuracion de los siguientes Buttons (Secuencial, ForkJoin,
        // ExecuteService)
        btnSecuencial = new JButton();
        btnForkJoin = new JButton();
        btnExecuteService = new JButton();

        btnSecuencial.setText("Secuencial");
        btnForkJoin.setText("ForkJoin");
        btnExecuteService.setText("ExecuteService");

        btnSecuencial.setBounds(8, 460, 250, 45);
        btnForkJoin.setBounds(267, 460, 250, 45);
        btnExecuteService.setBounds(525, 460, 250, 45);

        panel.add(btnSecuencial);
        panel.add(btnForkJoin);
        panel.add(btnExecuteService);

        // Configuracion del boton para limpiar los TextAreas
        btnClear = new JButton();
        btnClear.setText("Limpiar TextAreas");
        btnClear.setBounds(25, 135, 200, 35);

        panel.add(btnClear);
    }

    private void guardarTextoOriginal() {

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (!taTextoOriginal.getText().equals("")) {

                    textoOriginal = taTextoOriginal.getText();
                    JOptionPane.showMessageDialog(null, "El texto ingresado se ha guardado!");
                }

                else
                    JOptionPane.showMessageDialog(null, "Por favor ingresa un texto primero");
            }
        };

        btnGuardarTexto.addActionListener(listener);
    }

    private void btnClear() {

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                // Limpiamos los Text Areas
                taTextoOriginal.setText("");
                taSecuencial.setText("");
                taForkJoin.setText("");
                taExecuteService.setText("");

                // Limpiamos los labels de tiempo
                lbSecuencial.setText("Secuencial: ");
                lbForkJoin.setText("ForkJoin: ");
                lbExecuteService.setText("ExecuteService: ");
            }
        };

        btnClear.addActionListener(listener);
    }

    private void btnSecuencial() {

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                // Eliminar los caracteres no alfabéticos y convertir a minúsculas
                String textoLimpio = textoOriginal.replaceAll("[^a-zA-Z]", "").toLowerCase();

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
                // String TEXTO_SALIDA = "Texto ingresado: " + textoOrigina;
                String CANTIDAD_LETRAS = "Cantidad de letras en el texto: " + textoLimpio.length() + "\n";
                String LETRAS_SEPARADAS = "Letras y su cantidad de repeticiones: \n";
                for (Map.Entry<Character, Integer> entry : contador.entrySet()) {
                    LETRAS_SEPARADAS += "   " + entry.getKey() + ": " + entry.getValue() + "\n";
                }

                lbSecuencial.setText("Tiempo de ejecucion: " + tiempoEjecucion + " milisegundos");
                taSecuencial.setText(CANTIDAD_LETRAS + LETRAS_SEPARADAS);
            }
        };

        btnSecuencial.addActionListener(listener);
    }

    private void btnForkJoin() {

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {


                String textoLimpio = textoOriginal.replaceAll("[^a-zA-Z]", "").toLowerCase();
                Map<Character, Integer> contador = new HashMap<>();

                long startTime = System.currentTimeMillis();

                ForkJoinPool forkJoinPool = new ForkJoinPool();
                forkJoinPool.invoke(new forkContador(textoLimpio, 0, textoLimpio.length() - 1, contador));

                long endTime = System.currentTimeMillis();
                long tiempoEjecucion = endTime - startTime;

                String CANTIDAD_LETRAS = "Cantidad de letras en el texto: " + textoLimpio.length() + "\n";
                String LETRAS_SEPARADAS = "Letras y su cantidad de repeticiones: \n";
                for (Map.Entry<Character, Integer> entry : contador.entrySet()) {
                    LETRAS_SEPARADAS += "   " + entry.getKey() + ": " + entry.getValue() + "\n";
                }

                lbForkJoin.setText("Tiempo de ejecucion: " + tiempoEjecucion + " milisegundos");
                taForkJoin.setText(CANTIDAD_LETRAS + LETRAS_SEPARADAS);

            }
        };

        btnForkJoin.addActionListener(listener);
    }

    private void btnExecuteService() {

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                String textoLimpio = textoOriginal.replaceAll("[^a-zA-Z]", "").toLowerCase();

                Map<Character, Integer> contador = new HashMap<>();

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

                String CANTIDAD_LETRAS = "Cantidad de letras en el texto: " + textoLimpio.length() + "\n";
                String LETRAS_SEPARADAS = "Letras y su cantidad de repeticiones: \n";
                for (Map.Entry<Character, Integer> entry : contador.entrySet()) {
                    LETRAS_SEPARADAS += "   " + entry.getKey() + ": " + entry.getValue() + "\n";
                }

                lbExecuteService.setText("Tiempo de ejecucion: " + tiempoEjecucion + " milisegundos");
                taExecuteService.setText(CANTIDAD_LETRAS + LETRAS_SEPARADAS);

            }
        };

        btnExecuteService.addActionListener(listener);
    }

}

