package cl.gvidal.strategydiio.dosis;

import cl.gvidal.strategydiio.DosisStrategy;

public class DosisTernero implements DosisStrategy {
    @Override
    public int applyDosis(double peso) {

        return (int) (peso/100*5); //5ml por cada 100 kilos
    }
}
