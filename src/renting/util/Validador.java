package renting.util;

import java.util.Scanner;

public class Validador {
    public String validarTexto(Scanner sc, int opcion) {
        /**
         * Validar que el texto ingresado no esté vacío y que cumpla con las condiciones según la opción seleccionada:
         * 1. Solo letras y números (sin caracteres especiales)
         * 2. Solo letras (sin números ni caracteres especiales)
         * 3. Solo números (sin letras ni caracteres especiales)
         */

        String texto = sc.nextLine();
        if (texto.equals("") ) {
            System.out.println("El dato no puede estar vacío, por favor intente de nuevo.");
            return validarTexto(sc, opcion);
        }

        switch (opcion) {
            case 1:
                if (!texto.matches("^[a-zA-Z0-9]*$")) {
                    System.out.println("El dato no debe contener caracteres especiales, por favor intente de nuevo.");
                    return validarTexto(sc, opcion);
                }
                break;
            case 2:
                if (!texto.matches("^[a-zA-Z]*$")) {
                    System.out.println("El dato no debe contener números ni caracteres especiales, por favor intente de nuevo.");
                    return validarTexto(sc, opcion);
                }
                break;
            case 3:
                if (!texto.matches("^[0-9]*$")) {
                    System.out.println("El dato debe contener solo números, por favor intente de nuevo.");
                    return validarTexto(sc, opcion);
                }
                break;
            default:
                return "Opción no válida";
        }
        return texto;
    }

    public int validarEntero(Scanner sc) {
        /**
         * Validar que el número sea positivo (mayor que cero)
         */

        int numero;
        try {
            numero = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            sc.nextLine(); // Limpiar el buffer de entrada
            return validarEntero(sc);
        }
        if (numero <= 0) {
            System.out.println("El número debe ser positivo (mayor que cero). Por favor, intente de nuevo.");
            return validarEntero(sc);
        }

        return numero;
    }

    public float validarDecimal(Scanner sc) {
        /**
         * Validar que el número sea positivo (mayor que cero)
         */

        float numero;
        try {
            numero = sc.nextFloat();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número decimal.");
            sc.nextLine(); // Limpiar el buffer de entrada
            return validarDecimal(sc);
        }
        if (numero <= 0) {
            System.out.println("El número debe ser positivo (mayor que cero). Por favor, intente de nuevo.");
            return validarDecimal(sc);
        }
        return numero;
    }

    public int validarOpcionMenu(Scanner sc, int min, int max) {
        /**
         * Validar que la opción seleccionada esté dentro del rango de opciones disponibles
         */

        int opcion;
        try {
            opcion = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            sc.nextLine(); // Limpiar el buffer de entrada
            return validarOpcionMenu(sc, min, max);
        }
        if (opcion < min || opcion > max) {
            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            return validarOpcionMenu(sc, min, max);
        }
        sc.nextLine(); // Limpiar el buffer de entrada

        return opcion;
    }
}