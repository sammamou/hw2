public class Difference extends Sum {
    public Function leftFunction;
    public Function rightFunction;
    public Difference(Function leftFunction, Function rightFunction) {
        super(leftFunction, new Negation(rightFunction));
        this.leftFunction = leftFunction;
        this.rightFunction = rightFunction;
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(leftFunction) + " - " + String.valueOf(rightFunction) + ")";
    }
    @Override
    public Function derivative() {
        Function leftDerivative = leftFunction.derivative();
        Function rightDerivative = rightFunction.derivative();
        return new Difference(leftDerivative, rightDerivative);
    }
}
