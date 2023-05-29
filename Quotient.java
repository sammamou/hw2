public class Quotient extends Function {
    private Function numerator;
    private Function denominator;

    public Quotient(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double valueAt(double x) {
        double numeratorValue = numerator.valueAt(x);
        double denominatorValue = denominator.valueAt(x);

        if (denominatorValue == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return numeratorValue / denominatorValue;
    }

    @Override
    public String toString() {
        return "(" + numerator.toString() + ") / (" + denominator.toString() + ")";
    }

    @Override
    public Function derivative() {
        Function numeratorDerivative = numerator.derivative();
        Function denominatorDerivative = denominator.derivative();

        Function numeratorTimesDenominatorDerivative = new Product(numeratorDerivative, denominator);
        Function denominatorTimesNumeratorDerivative = new Product(numerator, denominatorDerivative);

        Function numeratorDerivativeTimesDenominatorMinusDenominatorDerivativeTimesNumerator = new Difference(
                numeratorTimesDenominatorDerivative, denominatorTimesNumeratorDerivative);
        Function denominatorSquared = new Power(denominator, 2);

        return new Quotient(numeratorDerivativeTimesDenominatorMinusDenominatorDerivativeTimesNumerator, denominatorSquared);
    }
}
