import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agendas implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fecha_inicio;
    private String fecha_fin;
    private String ubicacion_lugar;
    private String actividadA_desarrollar;
    private String encargado_de_su_atencion;
    private long telefono_experto;
    private String compromiso;

    public static List<Agendas> lista_Agendas = new ArrayList<>();

    public Agendas(String fecha_inicio, String fecha_fin, String ubicacion_lugar, String actividadA_desarrollar,
                   String encargado_de_su_atencion, long telefono_experto, String compromiso) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.ubicacion_lugar = ubicacion_lugar;
        this.actividadA_desarrollar = actividadA_desarrollar;
        this.encargado_de_su_atencion = encargado_de_su_atencion;
        this.telefono_experto = telefono_experto;
        this.compromiso = compromiso;
    }

    // Método para guardar lista de agendas en archivo
    public static void guardarAgendas() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("agendas.ser"))) {
            out.writeObject(lista_Agendas);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar agendas: " + e.getMessage());
        }
    }

    // Método para cargar lista de agendas desde archivo
    public static void cargarAgendas() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("agendas.ser"))) {
            lista_Agendas = (List<Agendas>) in.readObject();
            //JOptionPane.showMessageDialog(null, "Agendas cargadas exitosamente."); //esto es lo que hacia que se cargaran los dos mensajes al inicio
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontraron agendas previas o hubo un error en la carga.");
        }
    }

    // Método para agregar una nueva agenda
    public static void agregarAgenda() {
        String fecha_inicio = JOptionPane.showInputDialog("Ingrese la fecha de inicio (formato: YYYY-MM-DD):");
        if (fecha_inicio == null) return; // Regresa al menú de agendas si se cancela
    
        String fecha_fin = JOptionPane.showInputDialog("Ingrese la fecha de fin (formato: YYYY-MM-DD):");
        if (fecha_fin == null) return;
    
        String ubicacion_lugar = JOptionPane.showInputDialog("Ingrese la ubicación:");
        if (ubicacion_lugar == null) return;
    
        String actividadA_desarrollar = JOptionPane.showInputDialog("Ingrese la actividad a desarrollar:");
        if (actividadA_desarrollar == null) return;
    
        String encargado_de_su_atencion = JOptionPane.showInputDialog("Ingrese el encargado de su atención:");
        if (encargado_de_su_atencion == null) return;
    
        String telefonoStr = JOptionPane.showInputDialog("Ingrese el teléfono del experto:");
        if (telefonoStr == null) return;
        long telefono_experto;
        try {
            telefono_experto = Long.parseLong(telefonoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Teléfono no válido. Intente de nuevo.");
            return;
        }
    
        String compromiso = JOptionPane.showInputDialog("Ingrese el compromiso:");
        if (compromiso == null) return;
    
        Agendas nuevaAgenda = new Agendas(fecha_inicio, fecha_fin, ubicacion_lugar, actividadA_desarrollar,
                encargado_de_su_atencion, telefono_experto, compromiso);
        lista_Agendas.add(nuevaAgenda);
        JOptionPane.showMessageDialog(null, "Agenda agregada exitosamente.");
    }
    

    // Método para mostrar todas las agendas
    public static void mostrarAgendas() {
        if (lista_Agendas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay agendas registradas.");
            return;
        }
        StringBuilder sb = new StringBuilder("Lista de Agendas:\n");
        for (Agendas agenda : lista_Agendas) {
            sb.append("Fecha de inicio: ").append(agenda.fecha_inicio).append("\n");
            sb.append("Fecha de fin: ").append(agenda.fecha_fin).append("\n");
            sb.append("Ubicación: ").append(agenda.ubicacion_lugar).append("\n");
            sb.append("Actividad: ").append(agenda.actividadA_desarrollar).append("\n");
            sb.append("Encargado: ").append(agenda.encargado_de_su_atencion).append("\n");
            sb.append("Teléfono: ").append(agenda.telefono_experto).append("\n");
            sb.append("Compromiso: ").append(agenda.compromiso).append("\n");
            sb.append("-----------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Método para actualizar una agenda existente
    public static void actualizarAgenda(int index) {
        if (index < 0 || index >= lista_Agendas.size()) {
            JOptionPane.showMessageDialog(null, "Índice no válido.");
            return;
        }

        Agendas agenda = lista_Agendas.get(index);
        String nuevaFechaInicio = JOptionPane.showInputDialog("Ingrese la nueva fecha de inicio (o presione Enter para mantener: " + agenda.fecha_inicio + "):");
        if (nuevaFechaInicio != null && !nuevaFechaInicio.isEmpty()) {
            agenda.fecha_inicio = nuevaFechaInicio;
        }

        String nuevaFechaFin = JOptionPane.showInputDialog("Ingrese la nueva fecha de fin (o presione Enter para mantener: " + agenda.fecha_fin + "):");
        if (nuevaFechaFin != null && !nuevaFechaFin.isEmpty()) {
            agenda.fecha_fin = nuevaFechaFin;
        }

        String nuevaUbicacion = JOptionPane.showInputDialog("Ingrese la nueva ubicación (o presione Enter para mantener: " + agenda.ubicacion_lugar + "):");
        if (nuevaUbicacion != null && !nuevaUbicacion.isEmpty()) {
            agenda.ubicacion_lugar = nuevaUbicacion;
        }

        String nuevaActividad = JOptionPane.showInputDialog("Ingrese la nueva actividad (o presione Enter para mantener: " + agenda.actividadA_desarrollar + "):");
        if (nuevaActividad != null && !nuevaActividad.isEmpty()) {
            agenda.actividadA_desarrollar = nuevaActividad;
        }

        String nuevoEncargado = JOptionPane.showInputDialog("Ingrese el nuevo encargado (o presione Enter para mantener: " + agenda.encargado_de_su_atencion + "):");
        if (nuevoEncargado != null && !nuevoEncargado.isEmpty()) {
            agenda.encargado_de_su_atencion = nuevoEncargado;
        }

        String nuevoTelefonoStr = JOptionPane.showInputDialog("Ingrese el nuevo teléfono (o presione Enter para mantener: " + agenda.telefono_experto + "):");
        if (nuevoTelefonoStr != null && !nuevoTelefonoStr.isEmpty()) {
            agenda.telefono_experto = Long.parseLong(nuevoTelefonoStr);
        }

        String nuevoCompromiso = JOptionPane.showInputDialog("Ingrese el nuevo compromiso (o presione Enter para mantener: " + agenda.compromiso + "):");
        if (nuevoCompromiso != null && !nuevoCompromiso.isEmpty()) {
            agenda.compromiso = nuevoCompromiso;
        }

        JOptionPane.showMessageDialog(null, "Agenda actualizada exitosamente.");
    }

    // Método para eliminar una agenda
    public static void eliminarAgenda(int index) {
        if (index < 0 || index >= lista_Agendas.size()) {
            JOptionPane.showMessageDialog(null, "Índice no válido.");
            return;
        }
        lista_Agendas.remove(index);
        JOptionPane.showMessageDialog(null, "Agenda eliminada exitosamente.");
    }
}
