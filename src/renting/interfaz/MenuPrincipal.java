package renting.interfaz;

import renting.servicio.ClienteService;
import renting.servicio.VehiculoService;
import renting.servicio.ContratoService;
import renting.servicio.InformeService;
import renting.util.Validador;
import java.util.Scanner;
import java.util.LinkedList;

public class MenuPrincipal {
    private Scanner sc = new Scanner(System.in);
    private ClienteService clienteService;
    private VehiculoService vehiculoService;
    private ContratoService contratoService;
    private InformeService informeService;
    private Validador v = new Validador(); // PA

    public MenuPrincipal() {
        this.clienteService = new ClienteService();
        this.vehiculoService = new VehiculoService();
        this.contratoService = new ContratoService();
        this.informeService = new InformeService();
    }

    // (HU5) Inicia el ciclo del menú principal
    public String mostrarMenu() {
        boolean bandera = false;
        while (!bandera) {
            System.out.println("\n==============================================");
            System.out.println("    SISTEMA DE RENTING DE VEHÍCULOS     ");
            System.out.println("==============================================");
            System.out.println("1. GESTIÓN DE CLIENTES");
            System.out.println("2. GESTIÓN DE VEHÍCULOS");
            System.out.println("3. GESTIÓN DE CONTRATOS DE RENTING");
            System.out.println("4. IMPRIMIR INFORME GENERAL");
            System.out.println("5. SALIR DEL SISTEMA");
            System.out.println("==============================================");

            //int opcion = Validador.validarOpcionMenu(sc);
            int opcion = v.validarOpcionMenu(sc, 1,5);

            switch (opcion) {
                case 1:
                    gestionarClientes();
                    break;
                case 2:
                    gestionarVehiculos();
                    break;
                case 3:
                    gestionarContratos();
                    break;
                case 4:
                    imprimirInforme();
                    break;
                case 5:
                    bandera = true;
                    System.out.println("\nGracias por usar el Sistema de Renting. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
        return "Menu mostrado";
    }

    //1. GESTIÓN DE CLIENTES
    public String gestionarClientes() {
        boolean volver = false;
        Validador val = new Validador();
        while (!volver) {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Volver al menú principal");

            int opcion = val.validarOpcionMenu(sc, 1,5);

            switch (opcion) {
                case 1:
                    clienteService.registrarCliente(sc);
                    break;
                case 2:
                    System.out.println("Funcionalidad de modificar cliente aún no implementada.");
                    //clienteService.modificarCliente(sc);
                    break;
                case 3:
                    clienteService.eliminarCliente(sc);
                    break;
                case 4:
                    clienteService.buscarCliente(sc);
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
        return "Gestión de clientes completada";
    }

    //2. GESTIÓN DE VEHÍCULOS
    public String gestionarVehiculos() {
        Validador val = new Validador();

        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIÓN DE VEHÍCULOS ---");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Modificar vehículo");
            System.out.println("3. Eliminar vehículo");
            System.out.println("4. Buscar vehículo");
            System.out.println("5. Volver al menú principal");

            int opcion = val.validarOpcionMenu(sc, 1, 5);

            switch (opcion) {
                case 1:
                    vehiculoService.registrarVehiculo(sc);
                    break;
                case 2:
                    System.out.println("Funcionalidad de modificar vehículo aún no implementada.");
                    //vehiculoService.modificarVehiculo(sc);
                    break;
                case 3:
                    vehiculoService.eliminarVehiculo(sc);
                    break;
                case 4:
                    vehiculoService.buscarVehiculo(sc);
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
        return "Gestión de vehículos completada";
    }

    //3. GESTIÓN DE CONTRATOS
    public String gestionarContratos() {
        boolean volver = false;
        Validador val = new Validador();
        while (!volver) {
            System.out.println("\n--- GESTIÓN DE CONTRATOS DE RENTING ---");
            System.out.println("1. Registrar nuevo contrato");
            System.out.println("2. Modificar contrato");
            System.out.println("3. Finalizar contrato (devolución)");
            System.out.println("4. Buscar contrato");
            System.out.println("5. Volver al menú principal");

            int opcion = val.validarOpcionMenu(sc, 1, 5);

            switch (opcion) {
                case 1:
                    contratoService.registrarContrato();
                    break;
                case 2:
                    contratoService.modificarContrato();
                    break;
                case 3:
                    contratoService.finalizarContrato();
                    break;
                case 4:
                    contratoService.buscarContrato();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
        return "Gestión de contratos completada";
    }

    //4. IMPRIMIR INFORME GENERAL
    public String imprimirInforme(){
        informeService.imprimirInformeGeneral();
        return "Informe general impreso";
    }

}