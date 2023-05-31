public class Variable extends Function {
    private String symbol;

    public Variable(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public double valueAt(double x) {
        return x;
    }

    @Override
    public String toString() {
        return symbol;
    }

    @Override
    public Function derivative() {
        return new Constant(1);
    }
}
