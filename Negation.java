public class Negation extends Function {
    private Function function;

    public Negation(Function function) {
        this.function = function;
    }

    @Override
    public double valueAt(double x) {
        return -function.valueAt(x);
    }

    @Override
    public String toString() {
        return "(-" + function.toString() + ")";
    }

    @Override
    public Function derivative() {
        return new Negation(function.derivative());
    }
}
