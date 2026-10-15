public class CarroSedan extends Vehiculo{

    public enum Combustible {
        GASOLINA,
        DIESEL,
        ELECTRICO
    }

    public enum TipoTransmision {
        MANUAL,
        AUTOMATICA
    }

    private Combustible TipoCombustible;
    private TipoTransmision Transmision;

    public CarroSedan() {
    }

    public CarroSedan(String placa, String marca, int modelo, float precioDiario, Vehiculo.EstadoVehiculo estado,
            CarroSedan.Combustible tipoCombustible, CarroSedan.TipoTransmision transmision) {
        super(placa, marca, modelo, precioDiario, estado);
        TipoCombustible = tipoCombustible;
        Transmision = transmision;
    }

    public CarroSedan(CarroSedan.Combustible tipoCombustible, CarroSedan.TipoTransmision transmision) {
        TipoCombustible = tipoCombustible;
        Transmision = transmision;
    }

    public Combustible getTipoCombustible() {
        return TipoCombustible;
    }

    public void setTipoCombustible(Combustible tipoCombustible) {
        TipoCombustible = tipoCombustible;
    }

    public TipoTransmision getTransmision() {
        return Transmision;
    }

    public void setTransmision(TipoTransmision transmision) {
        Transmision = transmision;
    }
    
}
