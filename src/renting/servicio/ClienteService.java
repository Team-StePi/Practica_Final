package renting.servicio;

import renting.modelo.Cliente;
import renting.util.Validador;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ClienteService {

    private LinkedList<Cliente> listaClientes;
    private Validador va = new Validador();

    public ClienteService() {
        this.listaClientes = new LinkedList<>();
    }

    // Registrar un cliente
    public LinkedList<Cliente> registrarCliente(Scanner sc) {
        
        System.out.print("Ingrese la cédula: ");
        String cedula = va.validarTexto(sc, 1);

        System.out.print("Ingrese el nombre: ");
        String nombre = va.validarTexto(sc, 1);

        System.out.print("Ingrese el apellido: ");
        String apellido = va.validarTexto(sc, 1);

        System.out.print("Ingrese el teléfono: ");
        String telefono = va.validarTexto(sc, 1);

        System.out.print("Ingrese la dirección: ");
        String direccion = va.validarTexto(sc, 1);

        System.out.print("Ingrese la licencia de conducción: ");
        String licencia = va.validarTexto(sc, 1);

        Cliente c = new Cliente(cedula, nombre, apellido, telefono, direccion, licencia);

        listaClientes.addLast(c);
        System.out.println("Cliente registrado correctamente.");

        return listaClientes;
    }

    // Buscar cliente por su cédula
    public Cliente buscarCliente(Scanner sc) {

        System.out.print("Ingrese la cédula del cliente a buscar: ");
        String cedula = va.validarTexto(sc, 1);

        for (Cliente c : listaClientes) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                return c;
            }
        }

        System.out.println("Cliente con la cédula " + cedula + " no encontrado.");
        return null;
    }

    // Eliminar cliente por su cédula
    public String eliminarCliente(Scanner sc) {

        System.out.print("Ingrese la cédula del cliente a eliminar: ");
        String cedula = va.validarTexto(sc, 1);

        if (listaClientes.isEmpty()) {
            return "No hay clientes registrados.";
        }

        Iterator<Cliente> it = listaClientes.iterator();
        while (it.hasNext()) {
            if (it.next().getCedula().equalsIgnoreCase(cedula)) {
                it.remove(); // Elimina el cliente de forma segura
                return "Cliente eliminado correctamente.";
            }
        }

        return "Cliente con la cédula " + cedula + " no encontrado.";
    }

    // Mostrar todos los clientes
    public String mostrarClientes() {

        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return "No hay clientes registrados.";
        }

        for (Cliente c : listaClientes) {
            System.out.println("Cédula: " + c.getCedula());
            System.out.println("Nombre: " + c.getNombre() + " " + c.getApellido());
            System.out.println("Teléfono: " + c.getTelefono());
            System.out.println("Dirección: " + c.getDireccion());
            System.out.println("Licencia: " + c.getLicenciaConduccion());
            System.out.println("-------------------------");
        }
        return "Clientes mostrados correctamente.";
    }
}