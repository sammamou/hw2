public class Constant extends Function {
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double valueAt(double x) {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }
}
