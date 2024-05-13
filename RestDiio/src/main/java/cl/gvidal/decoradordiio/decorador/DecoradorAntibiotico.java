package cl.gvidal.decoradordiio.decorador;

import cl.gvidal.decoradordiio.Receta;

public class DecoradorAntibiotico extends FichaDecorador{
    public DecoradorAntibiotico(Receta receta) {
        super(receta);
    }
    public String getMedicamento(){
        return receta.getMedicamento();
    }

    public String getObservaciones(){
        return receta.getIndicaciones();
    }
}
