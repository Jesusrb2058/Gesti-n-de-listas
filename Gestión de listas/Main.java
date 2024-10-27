import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
public class Main {
    public static void main(String[] args) {
        // Cargar los datos de expertos y agendas desde el archivo al inicio
        Expertos.cargarExpertos();
        Agendas.cargarAgendas();

        JFrame frame = new JFrame("Gestión de Expertos y Agendas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Agregar un listener para manejar el cierre del JFrame
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                guardarDatosYSalir();
            }
        });

        while (true) {
            String[] options = {"Gestionar Expertos", "Gestionar Agendas", "Salir"};
            int opcion = JOptionPane.showOptionDialog(frame,
                    "Seleccione una opción:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (opcion == JOptionPane.CLOSED_OPTION || opcion == -1) {
                guardarDatosYSalir();
            }

            switch (opcion) {
                case 0:
                    gestionarExpertos(frame);
                    break;
                case 1:
                    gestionarAgendas(frame);
                    break;
                case 2:
                    guardarDatosYSalir();
                    break;
                default:
                    break;
            }
        }
    }

    private static void gestionarExpertos(JFrame frame) {
        while (true) {
            String[] options = {"Agregar Experto", "Mostrar Expertos", "Actualizar Experto", "Eliminar Experto", "Regresar al Menú Principal"};
            int opcion = JOptionPane.showOptionDialog(frame,
                    "Gestión de Expertos",
                    "Seleccione una opción:",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (opcion == JOptionPane.CLOSED_OPTION || opcion == -1) {
                guardarDatosYSalir();
            }

            switch (opcion) {
                case 0:
                    Expertos.agregarExperto();
                    break;
                case 1:
                    Expertos.mostrarExpertos();
                    break;
                case 2:
                    String inputUpdate = JOptionPane.showInputDialog(frame, "Ingrese el índice del experto a actualizar:");
                    if (inputUpdate == null) {
                        guardarDatosYSalir();
                    }
                    try {
                        int indexUpdate = Integer.parseInt(inputUpdate);
                        Expertos.actualizarExperto(indexUpdate);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(frame, "Entrada no válida. Intente de nuevo.");
                    }
                    break;
                case 3:
                    String inputDelete = JOptionPane.showInputDialog(frame, "Ingrese el índice del experto a eliminar:");
                    if (inputDelete == null) {
                        guardarDatosYSalir();
                    }
                    try {
                        int indexDelete = Integer.parseInt(inputDelete);
                        Expertos.eliminarExperto(indexDelete);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(frame, "Entrada no válida. Intente de nuevo.");
                    }
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    private static void gestionarAgendas(JFrame frame) {
        while (true) {
            String[] options = {"Agregar Agenda", "Mostrar Agendas", "Actualizar Agenda", "Eliminar Agenda", "Regresar al Menú Principal"};
            int opcion = JOptionPane.showOptionDialog(frame,
                    "Gestión de Agendas",
                    "Seleccione una opción:",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);
    
            if (opcion == JOptionPane.CLOSED_OPTION || opcion == -1) {
                guardarDatosYSalir();
            }
    
            switch (opcion) {
                case 0:
                    Agendas.agregarAgenda();
                    break;
                case 1:
                    Agendas.mostrarAgendas();
                    break;
                case 2:
                    String inputUpdate = JOptionPane.showInputDialog(frame, "Ingrese el índice de la agenda a actualizar:");
                    if (inputUpdate == null) {
                        guardarDatosYSalir();
                    }
                    try {
                        int indexUpdate = Integer.parseInt(inputUpdate);
                        Agendas.actualizarAgenda(indexUpdate);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(frame, "Entrada no válida. Intente de nuevo.");
                    }
                    break;
                case 3:
                    String inputDelete = JOptionPane.showInputDialog(frame, "Ingrese el índice de la agenda a eliminar:");
                    if (inputDelete == null) {
                        guardarDatosYSalir();
                    }
                    try {
                        int indexDelete = Integer.parseInt(inputDelete);
                        Agendas.eliminarAgenda(indexDelete);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(frame, "Entrada no válida. Intente de nuevo.");
                    }
                    break;
                case 4:
                    return;  
                default:
                    break;
            }
        }
    }
    

    private static void guardarDatosYSalir() {
        Expertos.guardarExpertos(); // Guardar expertos al salir
        Agendas.guardarAgendas();   // Guardar agendas al salir
        JOptionPane.showMessageDialog(null, "Expertos y agendas guardados exitosamente."); //pal mensaje del final
        System.exit(0); // Termina la ejecución del programa
    }
}
