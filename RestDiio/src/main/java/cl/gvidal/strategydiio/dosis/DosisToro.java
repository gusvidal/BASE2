package cl.gvidal.strategydiio.dosis;

import cl.gvidal.strategydiio.DosisStrategy;

public class DosisToro implements DosisStrategy {
    @Override
    public int applyDosis(double peso) {
        return (int) (peso/100*7); // 7ml por cada 100 kilos
    }
}
