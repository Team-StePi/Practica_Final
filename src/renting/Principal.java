package renting;
import renting.interfaz.MenuPrincipal;

/*HU1: Clase principal main()
 Instancia e inicia el menú principal */

public class Principal {
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();
    }
}