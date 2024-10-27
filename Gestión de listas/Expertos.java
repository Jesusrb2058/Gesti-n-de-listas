import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Expertos implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private long telefono;
    private String especialidad;

    public static List<Expertos> listaExpertos = new ArrayList<>();

    public Expertos(String nombre, long telefono, String especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    // Método para guardar lista de expertos en archivo
    public static void guardarExpertos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("expertos.ser"))) {
            out.writeObject(listaExpertos);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar expertos: " + e.getMessage());
        }
    }
    

    // Método para cargar lista de expertos desde archivo
public static void cargarExpertos() {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("expertos.ser"))) {
        listaExpertos = (List<Expertos>) in.readObject();
        // JOptionPane.showMessageDialog(null, "Expertos cargados exitosamente."); // lo mismo que en agenda
    } catch (IOException | ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, "No se encontraron expertos previos o hubo un error en la carga."); 
    }
}

    // Método para agregar un nuevo experto
    public static void agregarExperto() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del experto:");
        if (nombre == null) return; // Regresa al menú de expertos si se cancela
    
        String telefonoStr = JOptionPane.showInputDialog("Ingrese el teléfono del experto:");
        if (telefonoStr == null) return; // Regresa si se cancela
        long telefono;
        try {
            telefono = Long.parseLong(telefonoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Teléfono no válido. Intente de nuevo.");
            return;
        }
    
        String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del experto:");
        if (especialidad == null) return; // Regresa si se cancela
    
        Expertos nuevoExperto = new Expertos(nombre, telefono, especialidad);
        listaExpertos.add(nuevoExperto);
        JOptionPane.showMessageDialog(null, "Experto agregado exitosamente.");
    }

    // Método para mostrar todos los expertos
    public static void mostrarExpertos() {
        if (listaExpertos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay expertos registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Lista de Expertos:\n");
        for (Expertos experto : listaExpertos) {
            sb.append("Nombre: ").append(experto.nombre).append("\n");
            sb.append("Teléfono: ").append(experto.telefono).append("\n");
            sb.append("Especialidad: ").append(experto.especialidad).append("\n");
            sb.append("-----------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Método para actualizar un experto existente
    public static void actualizarExperto(int index) {
        if (index < 0 || index >= listaExpertos.size()) {
            JOptionPane.showMessageDialog(null, "Índice no válido.");
            return;
        }

        Expertos experto = listaExpertos.get(index);
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre (o presione Enter para mantener: " + experto.nombre + "):");
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            experto.nombre = nuevoNombre;
        }

        String nuevoTelefonoStr = JOptionPane.showInputDialog("Ingrese el nuevo teléfono (o presione Enter para mantener: " + experto.telefono + "):");
        if (nuevoTelefonoStr != null && !nuevoTelefonoStr.isEmpty()) {
            experto.telefono = Long.parseLong(nuevoTelefonoStr);
        }

        String nuevaEspecialidad = JOptionPane.showInputDialog("Ingrese la nueva especialidad (o presione Enter para mantener: " + experto.especialidad + "):");
        if (nuevaEspecialidad != null && !nuevaEspecialidad.isEmpty()) {
            experto.especialidad = nuevaEspecialidad;
        }

        JOptionPane.showMessageDialog(null, "Experto actualizado exitosamente.");
    }

    // Método para eliminar un experto
    public static void eliminarExperto(int index) {
        if (index < 0 || index >= listaExpertos.size()) {
            JOptionPane.showMessageDialog(null, "Índice no válido.");
            return;
        }
        listaExpertos.remove(index);
        JOptionPane.showMessageDialog(null, "Experto eliminado exitosamente.");
    }
}
