package cl.gvidal.strategydiio;

public class Context {
    private DosisStrategy dosisStrategy;

    public Context(DosisStrategy dosisStrategy) {
        this.dosisStrategy = dosisStrategy;
    }

    public int executeStrategy(double dosis){
        return dosisStrategy.applyDosis(dosis);
    }
}
