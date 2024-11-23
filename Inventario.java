
import java.util.ArrayDeque; // Hola mi Arte
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Inventario {

    //1. CREAMOS ARREGLO DE INVENTARIO
    private static Productos[] Inventario;
    private static List<Orden> ordenes = new ArrayList<>();
    private static Deque<Productos> almacen = new ArrayDeque<>();
    private static Queue<Orden> colaOrdenes = new LinkedList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        inicializarInventario();
        int opcion;

        System.out.println("BIENVENIDO A TECNO-ARTE:");

        do {
            System.out.println("POR FAVOR SELECCIONE ALGUNA OPCION CON EL NUMERO INDICADO:");
            System.out.println("1. Consulta el inventario");
            System.out.println("2. Actualiza el inventario");
            System.out.println("3. Agrega una orden");
            System.out.println("4. Modifica una orden");
            System.out.println("5. Elimina una orden");
            System.out.println("6. Procesa una orden");
            System.out.println("7. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarInventario();
                    break;
                case 2:
                    actualizarInventario(scanner);
                    break;
                case 7:
                System.out.println("GRACIAS TE ESPERO PRONTO PARA QUE HAGAS TUS CONSULTAS");
                    break;
                default:
                    System.out.println("LO SIENTO Opción no válida.");

                    break;
            }
        } while (opcion != 7);

        scanner.close();
    }

    //INICIALIZAMOS EL INVENTARIO QUE TENEMOS EN EL SISTEMA

    private static void inicializarInventario() {
        Inventario = new Productos[]{
                new Productos(80, "Monitores"),
                new Productos(25, "Lavadoras"),
                new Productos(62, "Televisores Samsung"),
                new Productos(42, "Estufas")
        };
    }

    //CONLSUTAR ACTUALIZAR EL INVENTARIO

    private static void consultarInventario() {
        System.out.println("INVENTARIO ACTUAL:");
        for (Productos producto : Inventario) {
            System.out.println("Nombre: " + producto.nombre + ", Cantidad: " + producto.cantidad);
        }
    }

    private static void actualizarInventario(Scanner scanner) {
        System.out.println("Ingrese el nombre del producto a actualizar:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la Nueva cantidad :");
        int nuevaCantidad = scanner.nextInt();
        scanner.nextLine();

        for (Productos producto : Inventario) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                producto.cantidad = nuevaCantidad;
                System.out.println("el inventario ha sido actualizado con éxito.");
                return;
            }
        }
        System.out.println("Lo siento no he podido encontrar el producto.");
    }


}

