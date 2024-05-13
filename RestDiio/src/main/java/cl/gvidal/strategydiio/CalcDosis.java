package cl.gvidal.strategydiio;

import cl.gvidal.strategydiio.dosis.DosisTernero;
import cl.gvidal.strategydiio.dosis.DosisToro;
import cl.gvidal.strategydiio.dosis.DosisVaca;

public class CalcDosis {
    public CalcDosis() {
    }

    public static DosisStrategy getStrategy(double peso) {
        DosisStrategy strategy;
        if (peso >= 100 && peso <= 300) {
            strategy = new DosisTernero();
        } else if (peso >= 400 && peso <= 600) {
            strategy = new DosisVaca();
        } else {
            strategy = new DosisToro();
        }
        return strategy;
    }
}
