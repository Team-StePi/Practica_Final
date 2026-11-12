package renting.servicio;

import renting.modelo.CamionetaSUV;
import renting.modelo.CarroSedan;
import renting.modelo.Vehiculo;
import renting.modelo.Vehiculo.EstadoVehiculo;
import renting.util.Validador;
import java.util.LinkedList;
import java.util.Scanner;

public class VehiculoService {

    private LinkedList<Vehiculo> listaVehiculos;
    private Validador va = new Validador();

    public VehiculoService() {
        this.listaVehiculos = new LinkedList<>();
    }

    // Agregar un vehículo al final de la lista
    public LinkedList<Vehiculo> registrarVehiculo(Scanner sc) {
        Validador va = new Validador();

        System.out.println("¿Qué tipo de vehículo desea registrar?");
        System.out.println("1. Carro Sedán");
        System.out.println("2. Camioneta SUV");
        int tipo = va.validarOpcionMenu(sc, 1, 2);

        System.out.print("Ingrese la placa: ");
        String placa = va.validarTexto(sc, 1);

        System.out.print("Ingrese la marca: ");
        String marca = va.validarTexto(sc, 1);

        System.out.print("Ingrese el modelo (año): ");
        int modelo = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el precio diario: ");
        float precio = sc.nextFloat();
        sc.nextLine();

        System.out.println("Seleccione el estado:");
        System.out.println("1. DISPONIBLE");
        System.out.println("2. ALQUILADO");
        int opcionEstado = va.validarOpcionMenu(sc, 1, 2);
        EstadoVehiculo estado;
        if (opcionEstado == 1) {
            estado = EstadoVehiculo.DISPONIBLE;
        } else {
            estado = EstadoVehiculo.ALQUILADO;
        }

        Vehiculo v = null;

        if (tipo == 1) {
            // --- CARRO SEDAN ---
            System.out.println("Seleccione el tipo de combustible:");
            System.out.println("1. GASOLINA");
            System.out.println("2. DIESEL");
            System.out.println("3. ELECTRICO");
            int opCombustible = va.validarOpcionMenu(sc, 1, 3);

            CarroSedan.Combustible combustible;
            switch (opCombustible) {
                case 1:
                    combustible = CarroSedan.Combustible.GASOLINA;
                    break;
                case 2:
                    combustible = CarroSedan.Combustible.DIESEL;
                    break;
                default:
                    combustible = CarroSedan.Combustible.ELECTRICO;
                    break;
            }

            System.out.println("Seleccione el tipo de transmisión:");
            System.out.println("1. MANUAL");
            System.out.println("2. AUTOMATICA");
            int opTransmision = va.validarOpcionMenu(sc, 1, 2);

            CarroSedan.TipoTransmision transmision;
            if (opTransmision == 1) {
                transmision = CarroSedan.TipoTransmision.MANUAL;
            } else {
                transmision = CarroSedan.TipoTransmision.AUTOMATICA;
            }

            v = new CarroSedan(placa, marca, modelo, precio, estado, combustible, transmision);

        } else if (tipo == 2) {
            // --- CAMIONETA SUV ---

            System.out.println("Seleccione el tipo de tracción:");
            System.out.println("1. 4X2");
            System.out.println("2. 4X4");
            int opTraccion = va.validarOpcionMenu(sc, 1, 2);

            CamionetaSUV.TipoTraccion traccion;
            if (opTraccion == 1) {
                traccion = CamionetaSUV.TipoTraccion._4x2;
            } else {
                traccion = CamionetaSUV.TipoTraccion._4x4;
            }

            System.out.print("Ingrese la capacidad del maletero (en litros): ");
            float capacidadMaletero = sc.nextFloat();
            sc.nextLine();

            v = new CamionetaSUV(placa, marca, modelo, precio, estado, traccion, capacidadMaletero);
        } else {
            System.out.println("No está disponible ese tipo de automóvil.");
        }

        listaVehiculos.addLast(v);
        System.out.println("Vehículo registrado correctamente.");

        return listaVehiculos;
    }

    // Buscar un vehículo por su placa
    public Vehiculo buscarVehiculo(Scanner sc) {
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = va.validarTexto(sc, 1);

        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }

        System.out.println("Vehículo con la placa " + placa + " no encontrado.");
        return null;
    }

    // Eliminar un vehículo por su placa
    public String eliminarVehiculo(Scanner sc) {
        System.out.print("Ingrese la placa del vehículo a eliminar: ");
        String placa = va.validarTexto(sc, 1);

        if (listaVehiculos.isEmpty()) {
            return "No hay vehículos registrados.";
        }

        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getPlaca().equalsIgnoreCase(placa)) {
                listaVehiculos.remove(i);
                return "Vehículo eliminado correctamente.";
            }
        }

        return "Vehículo con la placa " + placa + " no encontrado.";
    }

    // Mostrar todos los vehículos
    public String mostrarVehiculos() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return "No hay vehículos registrados.";
        }

        for (Vehiculo ve : listaVehiculos) {

            if (ve instanceof CarroSedan) {
                CarroSedan sedan = (CarroSedan) ve;

                System.out.println("--- CARRO SEDÁN ---");
                System.out.println("Placa: " + sedan.getPlaca());
                System.out.println("Marca: " + sedan.getMarca());
                System.out.println("Modelo: " + sedan.getModelo());
                System.out.println("Precio diario: " + sedan.getPrecioDiario());
                System.out.println("Estado: " + sedan.getEstado());
                System.out.println("Combustible: " + sedan.getTipoCombustible());
                System.out.println("Transmisión: " + sedan.getTransmision());

            } else if (ve instanceof CamionetaSUV) {
                CamionetaSUV suv = (CamionetaSUV) ve;

                System.out.println("--- CAMIONETA SUV ---");
                System.out.println("Placa: " + suv.getPlaca());
                System.out.println("Marca: " + suv.getMarca());
                System.out.println("Modelo: " + suv.getModelo());
                System.out.println("Precio diario: " + suv.getPrecioDiario());
                System.out.println("Estado: " + suv.getEstado());
                System.out.println("Capacidad del maletero: " + suv.getCapacidadMaletero());
                System.out.println("Tipo de tracción: " + suv.getTraccion());

            } 

            System.out.println("-------------------------");
        }
        return "Vehículos mostrados correctamente.";
    }
}