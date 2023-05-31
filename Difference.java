public class Difference extends Sum {
    public Function leftFunction;
    public Function rightFunction;
    public Difference(Function leftFunction, Function rightFunction) {
        super(leftFunction, new Negation(rightFunction));
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(leftFunction) + " - " + String.valueOf(rightFunction) + ")";
    }
}
