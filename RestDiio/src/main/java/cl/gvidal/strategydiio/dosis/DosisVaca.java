package cl.gvidal.strategydiio.dosis;

import cl.gvidal.strategydiio.DosisStrategy;

public class DosisVaca implements DosisStrategy {
    @Override
    public int applyDosis(double peso) {
        return (int) (peso/100*6); // 6 ml por cada 100 kilos
    }
}
