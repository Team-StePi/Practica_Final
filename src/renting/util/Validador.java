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
}