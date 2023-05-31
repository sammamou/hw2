public class Power extends MultiProduct {
    private Function base;
    private double exponent;

    public Power(Function base, double exponent) {
        super(base, exponent);
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        if (exponent == 1) {
            return base.toString();
        } else {
            return "(" + base.toString() + ")^" + exponent;
        }
    }
    @Override
    public double valueAt(double x) {
        return Math.pow(base.valueAt(x), exponent);
    }

    @Override
    public Function derivative() {
        Function baseDerivative = base.derivative();
        Function exponentMinusOne = new Product(new Constant(exponent), new Power(base, exponent - 1));

        return new Product(exponentMinusOne, baseDerivative);
    }
}
