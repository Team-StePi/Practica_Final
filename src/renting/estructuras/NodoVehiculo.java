package renting.estructuras;

import renting.modelo.Vehiculo;

public class NodoVehiculo {

    Vehiculo Dato;
    NodoVehiculo Siguiente;

    public NodoVehiculo(Vehiculo dato) {
        this.Dato = dato;
        this.Siguiente = null;
    }

    public Vehiculo getDato() {
        return Dato;
    }

    public NodoVehiculo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoVehiculo siguiente) {
        Siguiente = siguiente;
    }
}
