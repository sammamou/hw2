/**
 * The Polynomial class extends the Function class and represents a polynomial function.
 * It provides methods to evaluate the value of the polynomial at a given point, compute its derivative,
 * and obtain a string representation of the polynomial.
 */
public class Polynomial extends Function {
    protected double[] coefficients;

    /**
     * Constructs a Polynomial object with the specified coefficients.
     *
     * @param coefficient The coefficients of the polynomial in ascending order of powers.
     */
    public Polynomial(double... coefficient) {
        this.coefficients = coefficient;
    }

    /**
     * Evaluates the value of the polynomial at the given point.
     *
     * @param x The point at which to evaluate the polynomial.
     * @return The value of the polynomial at the given point.
     */
    @Override
    public double valueAt(double x) {
        double result = 0;

        for (int i = 0; i < coefficients.length; i++) {
            double coefficient = coefficients[i];
            result += coefficient * Math.pow(x, i);
        }

        return result;
    }

    /**
     * Returns a string representation of the polynomial.
     *
     * @return A string representation of the polynomial.
     */
    @Override
    public String toString() {
        String expression = "";

        for (int i = 0; i < coefficients.length; i++) {
            double coefficient = coefficients[i];

            if (coefficient != 0) {
                if (!expression.isEmpty()) {
                    if (coefficient > 0) {
                        expression += " + ";
                    } else {
                        expression += " - ";
                        coefficient = -coefficient;
                    }
                }

                if (i == 0 || coefficient != 1) {
                    if (Math.floor(coefficient) == coefficient) {
                        expression += (int) coefficient;
                    } else {
                        expression += coefficient;
                    }
                }

                if (i > 0) {
                    expression += "x";

                    if (i > 1) {
                        expression += "^" + i;
                    }
                }
            }
        }
        if(expression == ""){
            expression = "0";
        }

        return "(" + expression + ")";
    }

    /**
     * Computes the derivative of the polynomial.
     *
     * @return A Function object representing the derivative of the polynomial.
     */
    @Override
    public Function derivative() {
        int n;
        if(coefficients.length == 0){
            n = 0;
        }else{
            n = coefficients.length - 1;
        }
        double[] derivativeCoefficients = new double[n];

        for (int i = 0; i < n; i++) {
            derivativeCoefficients[i] = coefficients[i + 1] * (i + 1);
        }

        return new Polynomial(derivativeCoefficients);
    }
}