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
        if (Math.floor(value) == value) {
            return "(" + (int)value + ")";
        } else {
            return "(" + value + ")" ;
        }
    }


    @Override
    public Function derivative() {
        
        return new Constant(0);
    }

    @Override
    public Function taylorPolynomial(int n) {
        return this;
    }

}
