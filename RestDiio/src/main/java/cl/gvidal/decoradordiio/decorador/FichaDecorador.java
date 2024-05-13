package cl.gvidal.decoradordiio.decorador;

import cl.gvidal.decoradordiio.Receta;

public class FichaDecorador implements Receta {

    protected Receta receta;

    public FichaDecorador(Receta receta) {
        this.receta = receta;
    }

    @Override
    public String getMedicamento() {
        return null;
    }

    @Override
    public String getIndicaciones() {
        return null;
    }
}
