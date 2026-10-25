package renting.servicio;
import renting.modelo.Cliente;
import renting.modelo.Validador;
import java.util.Scanner;

public class ClienteService {

    public Cliente registrarCliente(Scanner sc, Validador v){

        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = v.validarTexto(sc,3);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = v.validarTexto(sc,2);
        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = v.validarTexto(sc,2);
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = v.validarTexto(sc,3);
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = v.validarTexto(sc,1);
        System.out.print("Ingrese la licencia de conducción del cliente: ");
        String licenciaConduccion = v.validarTexto(sc,3);

        Cliente nuevoCliente = new Cliente(cedula, nombre, apellido, telefono, direccion, licenciaConduccion);
        
        return nuevoCliente;
    }
    
}
