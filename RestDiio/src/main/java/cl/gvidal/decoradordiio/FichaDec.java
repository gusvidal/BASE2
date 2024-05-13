package cl.gvidal.decoradordiio;

public class FichaDec implements Receta{

    private String medicamento;
    private String indicaciones;

    public FichaDec() {
    }

    public FichaDec(String medicamento, String indicaciones) {
        this.medicamento = medicamento;
        this.indicaciones = indicaciones;
    }

    @Override
    public String getMedicamento() {
        return this.medicamento;
    }

    @Override
    public String getIndicaciones() {
        return this.indicaciones;
    }
}
