public class Power extends Product {
    private Function base;
    private double exponent;

    public Power(Function base, double exponent) {
        super(base, new Constant(exponent));
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
    public Function derivative() {
        Function baseDerivative = base.derivative();
        Function exponentTimesBaseToExponentMinusOne = new Product(new Constant(exponent), new Power(base, exponent - 1));

        return new Product(exponentTimesBaseToExponentMinusOne, baseDerivative);
    }
}
