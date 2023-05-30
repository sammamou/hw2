public class Constant extends Function {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double valueAt(double x) {
        return value;
    }

    @Override
    public String toString() {
        if (value % 1 == 0) {
            long intValue = (long) value;
            return "(" + String.valueOf(intValue) + ")";
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public Function derivative() {
        
        return new Constant(0);
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return super.bisectionMethod(a, b);
    }
    @Override
    public Function taylorPolynomial(int n) {
        return this;
    }

}
