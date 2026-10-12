public class CamionetaSUV extends Vehiculo {

    public enum Combustible {
        GASOLINA,
        DIESEL,
        ELECTRICO
    }

    public enum TipoTraccion {
        _4x2,
        _4x4
    }

    private Combustible TipoCombustible;
    private TipoTraccion Traccion;

    public CamionetaSUV() {
    }

    public CamionetaSUV(String placa, String marca, int modelo, Double precioDiario, Vehiculo.EstadoVehiculo estado,
            CamionetaSUV.Combustible tipoCombustible, CamionetaSUV.TipoTraccion tipoTraccion) {
        super(placa, marca, modelo, precioDiario, estado);
        TipoCombustible = tipoCombustible;
        Traccion = tipoTraccion;
    }

    public CamionetaSUV(CamionetaSUV.Combustible tipoCombustible, CamionetaSUV.TipoTraccion tipoTraccion) {
        TipoCombustible = tipoCombustible;
        Traccion = tipoTraccion;
    }

    public Combustible getTipoCombustible() {
        return TipoCombustible;
    }

    public void setTipoCombustible(Combustible tipoCombustible) {
        TipoCombustible = tipoCombustible;
    }

    public TipoTraccion getTraccion() {
        return Traccion;
    }

    public void setTraccion(TipoTraccion traccion) {
        Traccion = traccion;
    }
    
    
}
