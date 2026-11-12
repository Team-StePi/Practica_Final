package renting.servicio;

import renting.modelo.Vehiculo;
import renting.estructuras.NodoVehiculo;
import renting.util.Validador;
import java.util.Scanner;

public class VehiculoService {

    private NodoVehiculo Cabeza;
    private Validador va = new Validador();

    // Agregar un vehículo al final de la lista
    public String agregarVehiculo(Vehiculo vehiculo) {

        NodoVehiculo nuevo = new NodoVehiculo(vehiculo);

        // Si la lista está vacía
        if (Cabeza == null) {
            Cabeza = nuevo;
        } else {

            NodoVehiculo actual = Cabeza;

            // Recorrer hasta encontrar el último nodo
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            // Enlazar el último nodo con el nuevo
            actual.setSiguiente(nuevo);
        }

        return "Vehículo agregado correctamente.";
    }

    // Buscar un vehículo por su placa
    public Vehiculo buscarVehiculo(Scanner sc) {

        System.out.print("Ingrese la placa del vehículo: ");
        String placa = va.validarTexto(sc, 1); 

        NodoVehiculo actual = Cabeza;

        while (actual != null) {

            if (actual.getDato().getPlaca().equalsIgnoreCase(placa)) {
                return actual.getDato();
            }

            actual = actual.getSiguiente();
        }

        System.out.println("Vehículo con la placa " + placa + " no encontrado.");
        return null;
    }

    // Eliminar un vehículo por su placa
    public String eliminarVehiculo(Scanner sc) {

        System.out.print("Ingrese la placa del vehículo a eliminar: ");
        String placa = va.validarTexto(sc, 1);

        // Verificar si la lista está vacía
        if (Cabeza == null) {
            return "No hay vehículos registrados.";
        }

        // Si el vehículo está en el primer nodo
        if (Cabeza.getDato().getPlaca().equalsIgnoreCase(placa)) {
            Cabeza = Cabeza.getSiguiente();
            return "Vehículo eliminado correctamente.";
        }

        NodoVehiculo actual = Cabeza;

        // Buscar el nodo anterior al que se desea eliminar
        while (actual.getSiguiente() != null) {

            if (actual.getSiguiente().getDato().getPlaca()
                    .equalsIgnoreCase(placa)) {

                // Saltar el nodo que se desea eliminar
                actual.setSiguiente(
                    actual.getSiguiente().getSiguiente()
                );

                return "Vehículo eliminado correctamente.";
            }

            actual = actual.getSiguiente();
        }

        return "Vehículo con la placa " + placa + " no encontrado.";
    }

    // Mostrar todos los vehículos
    public String mostrarVehiculos() {

        if (Cabeza == null) {
            System.out.println("No hay vehículos registrados.");
            return "No hay vehículos registrados.";
        }

        NodoVehiculo actual = Cabeza;

        while (actual != null) {

            Vehiculo ve = actual.getDato();

            System.out.println("Placa: " + ve.getPlaca());
            System.out.println("Marca: " + ve.getMarca());
            System.out.println("Modelo: " + ve.getModelo());
            System.out.println("Precio diario: " + ve.getPrecioDiario());
            System.out.println("Estado: " + ve.getEstado());

            System.out.println("-------------------------");

            actual = actual.getSiguiente();
        }
        return "Vehículos mostrados correctamente.";
    }

}
