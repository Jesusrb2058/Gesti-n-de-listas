# Gestión de Expertos y Agendas

Este proyecto en Java permite gestionar agendas y expertos mediante una interfaz gráfica simple. Permite agregar, mostrar, actualizar y eliminar registros de agendas y expertos. Los datos se almacenan en archivos para persistencia y se cargan automáticamente al iniciar la aplicación.

## Diagrama UML

<img src="Gestión de listas/Img/Diagrama UML.jpg" alt="Vista del juego" width="80">


## Características

- **Agendas**: Gestión de agendas con atributos como fecha de inicio, fecha de fin, ubicación, actividad, encargado, teléfono y compromiso.
- **Expertos**: Gestión de expertos con atributos como nombre, teléfono y especialidad.
- **Interfaz gráfica**: Uso de `JOptionPane` para la interacción con el usuario.
- **Persistencia de datos**: Los datos se guardan en archivos binarios (`agendas.ser` y `expertos.ser`), permitiendo su recuperación en futuras ejecuciones.
- **Manejo de excepciones**: Verificación de entrada para asegurar que los datos ingresados son válidos.

## Estructura del Proyecto

El proyecto está compuesto por tres clases principales:

1. **`Agendas`**: Define los métodos para gestionar las agendas y almacenar la lista de agendas en un archivo.
2. **`Expertos`**: Define los métodos para gestionar los expertos y almacenar la lista de expertos en un archivo.
3. **`Main`**: Clase principal que gestiona el menú de opciones y ejecuta los métodos correspondientes según la selección del usuario.

## Clases y Métodos

### Clase `Agendas`
- **Atributos**: `fecha_inicio`, `fecha_fin`, `ubicacion_lugar`, `actividadA_desarrollar`, `encargado_de_su_atencion`, `telefono_experto`, `compromiso`.
- **Métodos**:
  - `guardarAgendas()`: Guarda la lista de agendas en un archivo.
  - `cargarAgendas()`: Carga la lista de agendas desde el archivo.
  - `agregarAgenda()`: Permite agregar una nueva agenda.
  - `mostrarAgendas()`: Muestra todas las agendas registradas.
  - `actualizarAgenda(int index)`: Actualiza una agenda existente en la lista.
  - `eliminarAgenda(int index)`: Elimina una agenda específica de la lista.

### Clase `Expertos`
- **Atributos**: `nombre`, `telefono`, `especialidad`.
- **Métodos**:
  - `guardarExpertos()`: Guarda la lista de expertos en un archivo.
  - `cargarExpertos()`: Carga la lista de expertos desde el archivo.
  - `agregarExperto()`: Permite agregar un nuevo experto.
  - `mostrarExpertos()`: Muestra todos los expertos registrados.
  - `actualizarExperto(int index)`: Actualiza un experto existente en la lista.
  - `eliminarExperto(int index)`: Elimina un experto específico de la lista.

### Clase `Main`
- **Métodos**:
  - `gestionarExpertos(JFrame frame)`: Gestiona la interfaz de opciones para expertos.
  - `gestionarAgendas(JFrame frame)`: Gestiona la interfaz de opciones para agendas.
  - `guardarDatosYSalir()`: Guarda todos los datos antes de cerrar la aplicación.

## Requisitos del Sistema

- **Java 8 o superior**
- **Swing** para la interfaz gráfica

## Instalación y Ejecución

1. Clonar el repositorio o descargar el código fuente.
2. Compilar el proyecto:
   ```bash
   javac Main.java Agendas.java Expertos.java

# Descripción de métodos en Gestión de Expertos y Agendas

Este archivo documenta cada método en las clases `Agendas`, `Expertos`, y `Main`, explicando su funcionalidad en el sistema de gestión de agendas y expertos.

---

## Clase Agendas

La clase `Agendas` permite almacenar y gestionar información sobre reuniones, compromisos y eventos, incluyendo métodos para agregar, mostrar, actualizar y eliminar agendas.

### Métodos de la clase Agendas

- **`guardarAgendas()`**  
  Guarda la lista de agendas en un archivo serializado (`agendas.ser`) para su persistencia. Muestra un mensaje de error si no se puede guardar correctamente.

- **`cargarAgendas()`**  
  Carga la lista de agendas desde el archivo `agendas.ser`. Si no existen agendas previas o se encuentra un error, muestra un mensaje de notificación.

- **`agregarAgenda()`**  
  Permite al usuario ingresar la información necesaria para crear una nueva agenda (fechas, ubicación, actividad, encargado, teléfono y compromiso) mediante cuadros de diálogo de `JOptionPane`. Si el teléfono ingresado es inválido, solicita al usuario intentarlo nuevamente.

- **`mostrarAgendas()`**  
  Muestra todas las agendas registradas, incluyendo detalles como fecha de inicio, fecha de fin, ubicación, actividad, encargado, teléfono, y compromiso en un cuadro de diálogo. Si no hay agendas, notifica al usuario.

- **`actualizarAgenda(int index)`**  
  Permite actualizar los detalles de una agenda existente en base a su índice en la lista. Cada campo puede ser editado o dejado en blanco para conservar el valor actual.

- **`eliminarAgenda(int index)`**  
  Elimina una agenda de la lista según su índice. Muestra un mensaje de error si el índice es inválido.

---

## Clase Expertos

La clase `Expertos` permite gestionar la información de expertos, guardando su nombre, teléfono y especialidad. Proporciona métodos para la gestión básica de los expertos registrados en el sistema.

### Métodos de la clase Expertos

- **`guardarExpertos()`**  
  Guarda la lista de expertos en el archivo `expertos.ser`. Si hay un error durante el guardado, muestra un mensaje de error.

- **`cargarExpertos()`**  
  Carga la lista de expertos desde el archivo `expertos.ser`. Si el archivo no existe o hay un problema de carga, notifica al usuario.

- **`agregarExperto()`**  
  Permite al usuario agregar un nuevo experto mediante cuadros de diálogo de `JOptionPane` para ingresar nombre, teléfono y especialidad. Valida el teléfono y muestra un mensaje en caso de error.

- **`mostrarExpertos()`**  
  Muestra la lista de expertos en un cuadro de diálogo, con detalles de nombre, teléfono y especialidad de cada experto. Si la lista está vacía, se muestra un mensaje correspondiente.

- **`actualizarExperto(int index)`**  
  Permite actualizar los detalles de un experto específico usando su índice. Cada campo puede ser editado o dejado en blanco para conservar el valor actual.

- **`eliminarExperto(int index)`**  
  Elimina un experto de la lista basado en su índice y muestra un mensaje de confirmación. Si el índice es inválido, muestra un mensaje de error.

---

## Clase Main

La clase `Main` proporciona la interfaz principal de la aplicación mediante un menú donde el usuario puede seleccionar si quiere gestionar expertos, agendas, o salir de la aplicación.

### Métodos de la clase Main

- **`main(String[] args)`**  
  Método principal que carga los datos guardados de expertos y agendas, configura la ventana principal y permite al usuario elegir entre gestionar expertos, gestionar agendas o salir. 

- **`gestionarExpertos(JFrame frame)`**  
  Despliega un submenú de opciones para la gestión de expertos, permitiendo agregar, mostrar, actualizar y eliminar expertos. Cada acción se ejecuta en función de la elección del usuario.

- **`gestionarAgendas(JFrame frame)`**  
  Muestra un submenú para la gestión de agendas, con opciones para agregar, mostrar, actualizar y eliminar agendas. La ejecución de cada opción depende de la elección del usuario.

- **`guardarDatosYSalir()`**  
  Método de utilidad que guarda tanto la lista de expertos como la lista de agendas antes de salir del programa. 

---

Este proyecto permite gestionar de manera sencilla la información de expertos y agendas con persistencia de datos, asegurando que los cambios se mantengan aún después de cerrar la aplicación.

Las listas en este proyecto se guardan en archivos con extensión `.ser` para preservar los datos de forma persistente. Aquí tienes una explicación de por qué se usa este enfoque:

### ¿Por qué se utilizan listas serializadas en archivos `.ser`?

1. **Persistencia de datos**: 
   Al serializar las listas de `Agendas` y `Expertos` en archivos `.ser`, los datos permanecen almacenados incluso cuando se cierra la aplicación. Esto permite que la información se mantenga intacta entre sesiones de uso, lo cual es esencial en aplicaciones de gestión donde se necesita conservar registros previos.

2. **Eficiencia en la carga y el guardado**:
   Los archivos `.ser` son archivos binarios que permiten guardar la estructura completa de las listas en un solo paso. Al serializar el objeto, Java convierte la lista y todos los elementos en ella en un formato que puede ser guardado y recuperado eficientemente. Esto reduce el tiempo de carga y guardado en comparación con el manejo de archivos de texto o bases de datos cuando se necesita algo simple y rápido.

3. **Facilidad de uso**:
   Serializar listas es una forma simple de realizar la persistencia en aplicaciones pequeñas. La serialización permite a los desarrolladores guardar objetos enteros, como las listas de `Agendas` y `Expertos`, sin tener que mapear manualmente cada campo o dato. Además, Java proporciona la interfaz `Serializable` que simplifica este proceso.

4. **Flexibilidad para manipular los datos**:
   Usar archivos `.ser` permite modificar las listas de forma dinámica. Es decir, se pueden agregar, actualizar o eliminar elementos en la lista mientras la aplicación está en uso, y estos cambios se pueden guardar fácilmente con solo volver a serializar la lista al archivo.

5. **Facilidad en la recuperación de datos**:
   Al deserializar un archivo `.ser`, Java reconstruye la lista original y todos los objetos que contiene tal como fueron guardados. Esto simplifica la recuperación de los datos, ya que no es necesario interpretar o parsear manualmente el archivo. Los objetos se restauran con la estructura y los valores exactos que tenían al momento de ser guardados.

### ¿Cuándo es útil este enfoque?

Este método es especialmente útil en aplicaciones de escritorio o proyectos pequeños y medianos que necesitan almacenar datos estructurados, como la gestión de agendas o personas, pero que no requieren la complejidad de una base de datos completa. La serialización en `.ser` ofrece un equilibrio adecuado entre simplicidad y eficiencia para este tipo de aplicaciones.

# Autor
Desarrolladores del proyecto. 

- Jesus Ruben Rodriguez Bernal 
- Felipe Ramirez Cortes
- Yonath Hortega Herrera 